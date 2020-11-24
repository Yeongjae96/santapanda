package kr.co.santapanda.config.database;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration 
//@MapperScan(value = "kr.co.santapanda")
public class MybatisConfig {
	
	@Bean
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
	    sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
	 
	    Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
	    sessionFactory.setConfigLocation(myBatisConfig);
	 
	    return sessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }	
}
