package com.sakura.medical.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sakura.medical.common.utils.CommonConstant;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.RegionInfo;
import com.sakura.medical.mapper.RegionInfoMapper;
import com.sakura.medical.service.RegionInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 区域 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-13
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RegionInfoServiceImpl extends ServiceImpl<RegionInfoMapper, RegionInfo> implements RegionInfoService {

    @Autowired
    private RegionInfoMapper regionInfoMapper;


    @Override
    public List<RegionInfo> getRegion() {
        List<RegionInfo> regionInfoList = regionInfoMapper.selectList(new LambdaQueryWrapper<>());
        //先将pId相同的数据分为一组
        Map<Integer, List<RegionInfo>> map = regionInfoList.stream()
                .collect(Collectors.groupingBy(RegionInfo::getParentId));
        //在给每个数据设置children,因为之前已经分过组了,所以直接用每个数据的id去找pId是自己的就行了
        regionInfoList.forEach(regionInfo -> regionInfo.setRegionInfoList(map.get(regionInfo.getId())));
        //上面的处理后会有些空数据,在过滤下就行了,pid等于就是最顶级的节点了,因为之前所有的children已经设置完成了,这里直接过滤完就行了
        return regionInfoList.stream().filter(regionInfo -> regionInfo.getParentId().equals(0))
                .collect(Collectors.toList());
    }
}
