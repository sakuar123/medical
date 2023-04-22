package com.sakura.medical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.CommonsUtil;
import com.sakura.medical.common.utils.MD5Util;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;
import com.sakura.medical.mapper.AdministratorsInfoMapper;
import com.sakura.medical.service.AdministratorsInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 管理员信息表 服务实现类
 * </p>
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
}
