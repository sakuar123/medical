package com.sakura.medical;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;
import com.sakura.medical.entity.ProfessionalTitleInfo;
import com.sakura.medical.mapper.ProfessionalTitleInfoMapper;
import com.sakura.medical.service.AdministratorsInfoService;

@SpringBootTest
class MedicalApplicationTests {

    @Autowired
    private ProfessionalTitleInfoMapper professionalTitleInfoMapper;

    @Test
    void t1() {
        professionalTitleInfoMapper.insert(ProfessionalTitleInfo
                .builder()
                .professionalTitleName("主任医师")
                .professionalTitleDesc("职称描述职称描述")
                .registrationFee(new BigDecimal(60))
                .build());
    }

    @Autowired
    private AdministratorsInfoService administratorsInfoService;

    @Test
    void t2() {
        Boolean result = administratorsInfoService.insert(AdministratorsInfo
                .builder()
                .administratorAccount("ad1347890@163.com")
                .administratorName("admin")
                .administratorPassword("123456")
                .administratorPhone("16789009090")
                .roleId(1)
                .build());
        System.out.println(result);
    }

    @Test
    void t3() {
        Page<PageData> page = new Page<>(1, 2);
        System.out.println(JSON.toJSONString(administratorsInfoService.search("", page)));
    }

}
