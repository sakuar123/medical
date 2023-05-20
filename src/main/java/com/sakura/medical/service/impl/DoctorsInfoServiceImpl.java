package com.sakura.medical.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sakura.medical.common.enums.EnumDoctorLables;
import com.sakura.medical.common.exception.ErrorException;
import com.sakura.medical.common.utils.CommonsUtil;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.DoctorsInfo;
import com.sakura.medical.mapper.DoctorsInfoMapper;
import com.sakura.medical.service.DoctorsInfoService;

import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 医生信息表 服务实现类
 * </p>
 *
 * @author 李七夜
 * @since 2023-05-15
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class DoctorsInfoServiceImpl extends ServiceImpl<DoctorsInfoMapper, DoctorsInfo> implements DoctorsInfoService {

    @Autowired
    private DoctorsInfoMapper doctorsInfoMapper;

    private String[] doctorImgs = {
            "https://img0.baidu.com/it/u=3495541663,4174246784&fm=253&app=120&size=w931&n=0&f=JPEG&fmt=auto?sec=1684256400&t=cfa06c60c0ca691b5a3bada36285143f",
            "https://img0.baidu.com/it/u=2038510064,2336564911&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1684256400&t=20f5e4fa9b72cc2f465474d304995c2b",
            "https://img2.baidu.com/it/u=3036208171,397290434&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1684256400&t=72365646c3afa3fc144860b2c2b95d1e",
            "https://img2.baidu.com/it/u=159185945,1234241018&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=750",
            "https://img0.baidu.com/it/u=1782810384,1454869217&fm=253&fmt=auto&app=138&f=JPEG?w=357&h=500",
            "https://img1.baidu.com/it/u=1135595730,1746044138&fm=253&fmt=auto&app=120&f=JPEG?w=600&h=481",
            "https://img2.baidu.com/it/u=4251793949,2676110129&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500",
            "https://img0.baidu.com/it/u=3704078223,1926685394&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=750",
            "https://img0.baidu.com/it/u=3937172295,2045510512&fm=253&fmt=auto?w=900&h=600",
            "https://img2.baidu.com/it/u=1301822020,1639687244&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=739"};

    @Override
    public DoctorsInfo get(Integer id) {
        return doctorsInfoMapper.selectById(id);
    }

    @Override
    public Page<PageData> search(Page<PageData> page, PageData pageData) {
        return doctorsInfoMapper.search(page, pageData);
    }

    @Override
    public Boolean create(DoctorsInfo doctorsInfo) {
        try {
            doctorsInfo.setDoctorImg(doctorImgs[CommonsUtil.getRandomNumber(1).intValue() - 1]);
            doctorsInfoMapper.insert(doctorsInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("新增医生异常", e);
            throw new ErrorException("新增医生失败");
        }
    }

    @Override
    public Boolean modify(DoctorsInfo doctorsInfo) {
        try {
            doctorsInfoMapper.updateById(doctorsInfo);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("修改医生异常", e);
            throw new ErrorException("编辑医生失败");
        }
    }

    @Override
    public Boolean remove(Integer id) {
        try {
            doctorsInfoMapper.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("删除医生异常", e);
            throw new ErrorException("删除医生失败");
        }
    }

    @Override
    public List<PageData> getDoctorLables() {
        List<PageData> result = Lists.newArrayList();
        Arrays.stream(EnumDoctorLables.values()).forEach(enumDoctorLables -> {
            PageData pageData = new PageData();
            pageData.put("code", enumDoctorLables.getCode());
            pageData.put("value", enumDoctorLables.getValue());
            result.add(pageData);
        });
        return result;
    }
}
