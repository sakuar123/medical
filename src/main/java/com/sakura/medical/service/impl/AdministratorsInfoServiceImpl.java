package com.sakura.medical.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.medical.common.enums.EnumJsonResultMsg;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.Assert;
import com.sakura.medical.common.utils.CommonConstant;
import com.sakura.medical.common.utils.CommonsUtil;
import com.sakura.medical.common.utils.JwtUtil;
import com.sakura.medical.common.utils.MD5Util;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;
import com.sakura.medical.mapper.AdministratorsInfoMapper;
import com.sakura.medical.service.AdministratorsInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-04-12
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class AdministratorsInfoServiceImpl extends ServiceImpl<AdministratorsInfoMapper, AdministratorsInfo> implements
        AdministratorsInfoService {

    private String msg = "角色";
    @Autowired
    private AdministratorsInfoMapper administratorsInfoMapper;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public AdministratorsInfo get(Integer id) {
        return administratorsInfoMapper.selectById(id);
    }

    @Override
    public Page<PageData> search(String account, Page page) {
        return administratorsInfoMapper.search(account, page);
    }

    @Override
    public Boolean insert(AdministratorsInfo administratorsInfo) {
        try {
            //获取随机的密码盐
            String salt = CommonsUtil.getRandomString(8);
            //将密码进行MD5加密
            String password = MD5Util.getMd5(administratorsInfo.getAdministratorPassword(), salt);
            administratorsInfo.setAdministratorPassword(password);
            administratorsInfo.setAdministratorPasswordSalt(salt);
            return this.save(administratorsInfo);
        } catch (Exception e) {
            log.error("新增" + msg + "失败", e);
            throw new ErrorException("新增" + msg + "失败");
        }

    }

    @Override
    public Boolean modify(AdministratorsInfo administratorsInfo) {
        try {
            this.updateById(administratorsInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            msg = "修改" + msg + "失败";
            log.error(msg, e);
            throw new ErrorException(msg);
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            this.removeById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除" + msg + "失败", e);
            throw new ErrorException("删除" + msg + "失败");
        }
    }

    @Override
    public Boolean updatePwd(String newPassword, PageData pageData) {
        try {
            Integer userId = pageData.getIntegerVal("userId");
            AdministratorsInfo administratorsInfo = this.get(userId);
            newPassword = MD5Util.getMd5(newPassword, administratorsInfo.getAdministratorPasswordSalt());
            administratorsInfo.setAdministratorPassword(newPassword);
            return this.removeById(administratorsInfo);
        } catch (Exception e) {
            log.error("修改密码失败", e);
            throw new ErrorException("修改密码失败");
        }
    }

    @Override
    public PageData login(String accout, String password) {
        LambdaQueryWrapper<AdministratorsInfo> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(AdministratorsInfo::getAdministratorAccount, accout);
        AdministratorsInfo administratorsInfo = administratorsInfoMapper.selectOne(queryWrapper);
        //判断下账户是否存在
        Assert.isTrue(ObjectTools.isNotBlank(administratorsInfo), "账户不存在");
        //在判断下账户是否已经启用
        Assert.isTrue(administratorsInfo.getAdministratorStatus().equals(0), EnumJsonResultMsg.USER_BAD);
        //在校验下密码是否正确
        password = MD5Util.getMd5(password, administratorsInfo.getAdministratorPasswordSalt());
        Assert.isTrue(password.equals(administratorsInfo.getAdministratorPassword()),
                EnumJsonResultMsg.USER_NAME_OR_PWD_ERROR);
        //校验完成,生成token
        PageData result = new PageData();
        result.put("token", getToken(administratorsInfo));
        return result;
    }

    private String getToken(AdministratorsInfo administratorsInfo) {
        //生成下jwttoken
        String token = JwtUtil.createJwt(JSON.toJSONString(administratorsInfo));
        //生成下Rediskey
        String redisKey = StringUtils.join(CommonConstant.REDIS_USER_KEY, administratorsInfo.getId());
        //将生成的token放到Redis中
        redisTemplate.opsForValue().set(redisKey, token);
        return token;
    }
}
