package com.sakura.medical.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sakura.medical.entity.HospitalInsideNavigation;
import com.sakura.medical.mapper.HospitalInsideNavigationMapper;
import com.sakura.medical.service.HospitalInsideNavigationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 李七夜
 * Created by 李七夜 on 2023/5/11 21:09
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class HospitalInsideNavigationServiceImpl extends
        ServiceImpl<HospitalInsideNavigationMapper, HospitalInsideNavigation> implements
        HospitalInsideNavigationService {

}
