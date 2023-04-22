package com.sakura.medical.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.RoleInfo;
import com.sakura.medical.mapper.RoleInfoMapper;
import com.sakura.medical.service.RoleInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 * @author 李七夜
 * @since 2023-04-10
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {

    private String msg = "角色";

    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @Override
    public RoleInfo get(Integer id) {
        return roleInfoMapper.selectById(id);
    }

    @Override
    public Page<PageData> search(String roleName, Pageable pageable) {
        Page<PageData> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
        return roleInfoMapper.search(page, roleName);
    }

    @Override
    public Boolean create(RoleInfo roleInfo) {
        try {
            this.save(roleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增" + msg + "失败", e);
            throw new ErrorException("新增" + msg + "失败");
        }
    }

    @Override
    public Boolean update(RoleInfo roleInfo) {
        try {
            this.updateById(roleInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改" + msg + "失败", e);
            throw new ErrorException("修改" + msg + "失败");
        }
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            this.removeById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            msg = StringUtils.join("删除", msg, "失败");
            log.error(msg, e);
            throw new ErrorException(msg);
        }
    }
}
