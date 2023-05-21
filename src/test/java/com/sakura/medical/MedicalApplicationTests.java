package com.sakura.medical;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sakura.medical.common.utils.CommonsUtil;
import com.sakura.medical.common.utils.JwtUtil;
import com.sakura.medical.common.utils.PageData;
import com.sakura.medical.entity.AdministratorsInfo;
import com.sakura.medical.entity.ComboTypeInfo;
import com.sakura.medical.mapper.ComboTypeInfoMapper;
import com.sakura.medical.mapper.DoctorsInfoMapper;
import com.sakura.medical.mapper.ProfessionalTitleInfoMapper;
import com.sakura.medical.service.AdministratorsInfoService;
import com.sakura.medical.service.PermissionsInfoService;

import io.jsonwebtoken.Claims;

@SpringBootTest
class MedicalApplicationTests {

    public static void main(String[] args) {
//        Claims c = JwtUtil.parseJwt(
//                "eyJhbGciOiJIUzI1NiJ9.eyJhZG1pbmlzdHJhdG9yUGhvbmUiOiIxNjc4OTAwOTA5MCIsImFkbWluaXN0cmF0b3JOYW1lIjoiYWRtaW4iLCJhZG1pbmlzdHJhdG9yUGFzc3dvcmQiOiJiZDdlZjU1MzcyY2ZhNmNkMTczODVjNjc0MTU1NmZiZCIsInJvbGVJZCI6MSwiYWRtaW5pc3RyYXRvclN0YXR1cyI6MCwiaWQiOjEsImV4cCI6MTY4MjkyMzM4NiwiaWF0IjoxNjgyOTIzNDk1LCJhZG1pbmlzdHJhdG9yUGFzc3dvcmRTYWx0IjoibDZZazEySnIiLCJqdGkiOiI0ODU4MzQ1NTUzMTY4MjkyMzQ5NTcwNSIsImFkbWluaXN0cmF0b3JBY2NvdW50IjoiYWQxMzQ3ODkwQDE2My5jb20iLCJjcmVhdGVEYXRlIjoiMjAyMy0wNC0xMlQyMToyMDoyNiJ9._49J0hSfKKl7_ulEB1p7-MmInq11FINaB0Otd8iwYA0");
//        System.out.println(c.getId());
        for (int i = 0; i < 10; i++) {
            System.out.println(CommonsUtil.getRandomNumber(1));
        }

    }

    @Autowired
    private ProfessionalTitleInfoMapper professionalTitleInfoMapper;

    @Test
    void t1() {
//        professionalTitleInfoMapper.insert(ProfessionalTitleInfo
//                .builder()
//                .professionalTitleName("主任医师")
//                .professionalTitleDesc("职称描述职称描述")
//                .registrationFee(new BigDecimal(60))
//                .build());
        System.out.println(professionalTitleInfoMapper.selectById(1));
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

    @Test
    void t4() {
        PageData pageData = administratorsInfoService.login("ad1347890@163.com", "123456");
        Claims claims = JwtUtil.parseJwt(pageData.getStringVal("token"));
        System.out.println(JSON.toJSONString(claims));
    }

    @Autowired
    private PermissionsInfoService permissionsInfoService;

    @Test
    public void t5() {
        System.out.println(JSON.toJSONString(permissionsInfoService.getPermissionList()));
    }

    @Autowired
    private DoctorsInfoMapper doctorsInfoMapper;

    @Test
    public void t6() {
        doctorsInfoMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Autowired
    private ComboTypeInfoMapper comboTypeInfoMapper;

    @Test
    void t7() {
        ComboTypeInfo comboTypeInfo = ComboTypeInfo
                .builder()
                .comboName("儿童套餐A")
                .comboDesc("这是儿童套餐B")
                .build();
        System.out.println(comboTypeInfoMapper.insert(comboTypeInfo));
        System.out.println(comboTypeInfo.getId());
    }
}
