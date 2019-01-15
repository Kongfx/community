package com.xinrui.common.util;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.xinrui.common.pojo.CodeGeneratorParam;

public class CodeGeneratorUtil {

	public static void executeCodeGenerator(CodeGeneratorParam codeGeneratorParam) {
		//代码生成器
		AutoGenerator mpg = new AutoGenerator();
		//全局配置
		GlobalConfig gc = new GlobalConfig()
		.setOutputDir(codeGeneratorParam.getProjectPath()+"src\\main\\java\\")
		.setFileOverride(true)
		.setEnableCache(false)
		.setAuthor(codeGeneratorParam.getAuthor())
		.setBaseResultMap(true)
		.setBaseColumnList(true)
		.setActiveRecord(false)
		.setIdType(IdType.AUTO);

		//自定义文件命名
		gc.setControllerName("%sController");
		gc.setServiceName("%sService");
		gc.setServiceImplName("%sServiceImpl");
		gc.setMapperName("%sMapper");
		gc.setXmlName("%sMapper");
		mpg.setGlobalConfig(gc);

		//数据源配置
		DataSourceConfig dsc = new DataSourceConfig()
		.setUrl("jdbc:mysql://127.0.0.1:3306/community_admin?useSSL=false&autoReconnect=true&tinyInt1isBit=false&useUnicode=true&characterEncoding=utf8")
		.setUsername("root")
		.setPassword("root@mysql")
		.setDriverName("com.mysql.jdbc.Driver")
		.setDbType(DbType.MYSQL);
		mpg.setDataSource(dsc);

		PackageConfig pc = new PackageConfig()
		.setParent("com.xinrui.admin")
		.setController("controller")
		.setService("service")
		.setServiceImpl("service.impl")
		.setMapper("dao")
		.setEntity("dto")
		.setXml("mapper");
		mpg.setPackageInfo(pc);

		//策略配置
		StrategyConfig strategy = new StrategyConfig()
		.setNaming(NamingStrategy.underline_to_camel)
		.setColumnNaming(NamingStrategy.underline_to_camel)
		.setRestControllerStyle(true)
		.setEntityLombokModel(true)
//		.setSuperEntityClass("com.baomidou.mybatisplus.activerecord.Model")
//		.setSuperEntityColumns("id")
//		.setSuperControllerClass(null)
//		.setSuperServiceClass("com.baomidou.mybatisplus.service.IService")
//		.setSuperServiceImplClass("com.baomidou.mybatisplus.service.impl.ServiceImpl")
//		.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
		.setInclude(codeGeneratorParam.getIncludeTablesNames());
		mpg.setStrategy(strategy);
		//执行代码生成器
		mpg.execute();
	}

}