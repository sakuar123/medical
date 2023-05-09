package com.sakura.medical.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.dto.PermissionsInfoDto;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.CommonConstant;
import com.sakura.medical.common.utils.ObjectTools;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.PermissionsInfo;
import com.sakura.medical.entity.RoleInfo;
import com.sakura.medical.mapper.PermissionsInfoMapper;
import com.sakura.medical.mapper.RoleInfoMapper;
import com.sakura.medical.service.PermissionsInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 权限集合表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-05
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class PermissionsInfoServiceImpl extends ServiceImpl<PermissionsInfoMapper, PermissionsInfo> implements
        PermissionsInfoService {

    @Autowired
    private RoleInfoMapper roleInfoMapper;
    @Autowired
    private PermissionsInfoMapper permissionsInfoMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Override
    public PageData getPermissions(Integer roleId) {
        //从缓存里获取当前登录用户角色所拥有的权限集合
        String permissions = redisTemplate.opsForValue()
                .get(StringUtils.join(CommonConstant.REDIS_PERMISSION, roleId));
        PageData result = new PageData();
        result.put("permissions", ObjectTools.isNotBlank(permissions) ? permissions.split(",") : null);
        return result;
    }

    @Override
    public List<PermissionsInfoDto> getPermissionList() {
        String permission = redisTemplate.opsForValue()
                .get(StringUtils.join(CommonConstant.REDIS_PERMISSION, "0"));
        List<PermissionsInfo> permissionsInfoList = JSON
                .parseObject(permission, new TypeReference<List<PermissionsInfo>>() {
                });
        // 操作所有的数据
        // 通过Collectors.groupingBy(Address::getPid)方法按照Pid进行分组，也就是将pid相同的放在一起
        List<PermissionsInfoDto> result = Lists.newArrayList();
        permissionsInfoList.forEach(permissionsInfo -> {
            PermissionsInfoDto permissionsInfoDto = new PermissionsInfoDto();
            BeanUtils.copyProperties(permissionsInfo, permissionsInfoDto);
            result.add(permissionsInfoDto);
        });
        Map<Integer, List<PermissionsInfoDto>> map = result.stream()
                .collect(Collectors.groupingBy(PermissionsInfoDto::getPId));
        log.info(JSON.toJSONString(map));
        // 循环addresses,给它设置children属性
        result.forEach(permissionsInfo -> permissionsInfo.setPermissionsInfoList(map.get(permissionsInfo.getId())));
        // 现在已经形成了多棵树，最后我们再通过filter()方法挑选出根节点的那颗树即可。 这里我的根节点的pid为0
        return result.stream().filter(authorityDetail -> authorityDetail.getPId().equals(0))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean create(PermissionsInfo permissionsInfo) {
        try {
            permissionsInfoMapper.insert(permissionsInfo);
            init();
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增权限失败", e);
            throw new ErrorException("新增权限失败");
        }
    }

    @Override
    public Boolean modify(PermissionsInfo permissionsInfo) {
        try {
            permissionsInfoMapper.updateById(permissionsInfo);
            init();
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改权限失败", e);
            throw new ErrorException("修改权限失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            permissionsInfoMapper.deleteById(id);
            init();
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除权限失败", e);
            throw new ErrorException("删除权限失败");
        }
    }

    @Override
    public void setPermission(Integer roleId) {
        LambdaQueryWrapper<RoleInfo> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (ObjectTools.isNotBlank(roleId)) {
            lambdaQueryWrapper.eq(RoleInfo::getId, roleId);
        }
        //先获取所有的角色
        List<RoleInfo> roleInfoList = roleInfoMapper.selectList(lambdaQueryWrapper);
        //再将所有角色对应的权限集合放到缓存里
        roleInfoList.forEach(roleInfo -> {
            String redisKey = StringUtils.join(CommonConstant.REDIS_PERMISSION, roleInfo.getId());
            redisTemplate.opsForValue()
                    .set(redisKey, ObjectTools.isNotBlank(roleInfo.getPermissions()) ? roleInfo.getPermissions() : "");
        });
    }

    @Override
    public void init() {
        String redisKey = StringUtils.join(CommonConstant.REDIS_PERMISSION, 0);
        List<PermissionsInfo> permissionsInfoList = permissionsInfoMapper.selectList(new LambdaQueryWrapper<>());
        redisTemplate.opsForValue().set(redisKey, JSON.toJSONString(permissionsInfoList));
    }
}
