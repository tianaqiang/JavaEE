package com.ooda.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @desc: 实体类代码生成器
 * @Author: 田阿强
 * @Date: 2022/10/10 16:20
 */
public class AutoGenerator {
    public static void main(String[] args) {
        //1.获取代码生成器的对象
        com.baomidou.mybatisplus.generator.AutoGenerator autoGenerator = new com.baomidou.mybatisplus.generator.AutoGenerator();

        //设置数据库相关配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://120.77.92.117:3306/JavaEELab?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("15185912234Taq");
        autoGenerator.setDataSource(dataSource);

        //设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/src/main/java");    //设置代码生成位置
        globalConfig.setOpen(false);    //设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setAuthor("TianAqiang");    //设置作者
        globalConfig.setFileOverride(true);     //设置是否覆盖原始生成的文件
        globalConfig.setMapperName("%sMapper");    //设置数据层接口名，%s为占位符，指代模块名称
        globalConfig.setServiceName("%sService");    //去掉Service接口的首字母I
        globalConfig.setIdType(IdType.AUTO);   //设置Id生成策略
        autoGenerator.setGlobalConfig(globalConfig);

        //设置包名相关配置
        PackageConfig packageInfo = new PackageConfig();
        packageInfo.setParent("com.ooda");   //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
        packageInfo.setEntity("entity");    //设置实体类包名
        packageInfo.setMapper("mapper");   //设置数据层包名
        autoGenerator.setPackageInfo(packageInfo);

        //策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("goods_sku");  //设置当前参与生成的表名，参数为可变参数
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略,下划线转驼峰
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        //strategyConfig.setTablePrefix("tbl_");  //设置数据库表的前缀名称，模块名 = 数据库表名 - 前缀名  例如： User = tbl_user - tbl_
        //strategyConfig.setRestControllerStyle(true);    //设置是否启用Rest风格
        //strategyConfig.setVersionFieldName("version");  //设置乐观锁字段名
        //strategyConfig.setLogicDeleteFieldName("deleted");  //设置逻辑删除字段名
        //strategyConfig.setEntityLombokModel(true);  //设置是否启用lombok
        autoGenerator.setStrategy(strategyConfig);
        //2.执行生成操作
        autoGenerator.execute();
    }
}