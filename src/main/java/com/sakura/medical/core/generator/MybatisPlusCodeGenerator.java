package com.sakura.medical.core.generator;

import java.util.Collections;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.fill.Column;

/**
 * @author 李七夜
 * Created by 李七夜 on 2022/4/30 18:09
 * mybatis plus 代码生成器
 */
public class MybatisPlusCodeGenerator {

    private static final String URL = "jdbc:mysql://localhost:3306/medical?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";

    /**
     * 需要生成的表名
     */
    private static String tableName = "announcement_info";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        //获取项目路径
        FastAutoGenerator.create(URL, "root", "123456")
                //全局配置
                .globalConfig(builder -> builder.author("李七夜")
                        //输出路径
                        .outputDir(projectPath + "/src/main/java")
                        //开启swagger3
                        .enableSwagger()
                        //覆盖文件
                        .fileOverride()
                        //不打开文件夹
                        .disableOpenDir())
                //包名配置
                .packageConfig(builder -> builder.parent("com.sakura")
                        .moduleName("medical")
                        .service("service")
                        .serviceImpl("service.impl")
                        .controller("web.controller")
                        .entity("entity")
                        .mapper("mapper")
                        //自定义输出路径，mapper.xml生成到resources目录下
                        .pathInfo(Collections
                                .singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper")))
                //策略配置
                .strategyConfig(builder -> builder.addInclude(tableName)
                        .addTablePrefix("t_")//表前缀
                        //去掉Service的 "I" 前缀
                        .serviceBuilder().formatServiceFileName("%sService")
                        .controllerBuilder()
                        //restful开启
                        .enableRestStyle()
                        //url改变 例如：index_id_1
                        .enableHyphenStyle()
                        .entityBuilder()
                        //开启lombok
                        .enableLombok()
                        //添加表字段填充，"create_time"字段自动填充为插入时间，"modify_time"字段自动填充为插入修改时间
                        .addTableFills(
                                new Column("create_time", FieldFill.INSERT),
                                new Column("modify_time", FieldFill.INSERT_UPDATE))
                        //开启生成实体时生成字段注解
                        .enableTableFieldAnnotation())
                //如果不需要哪个文件就将参数设置为null
                .templateConfig(builder ->
                        builder
//                                .controller(null)
//                                .service(null)
//                                .serviceImpl(null)
                                .build())
                //执行
                .execute();
    }
}
