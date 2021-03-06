package kh.com.kshrd.ipcam.configuration.swagger;

import com.mangofactory.swagger.plugin.EnableSwagger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("kh.com.kshrd.ipcam.repository")
@EnableSwagger
public class MybatisConfiguration {

    @Autowired private DataSource datasource;

    @Bean
    public DataSource getDataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/demo");//120.136.24.174//IPCAM_MANAGEMENT_DB
        dataSource.setUsername("postgres");//IPCAM_USER
        dataSource.setPassword("rina");
        
        /*dataSource.setUrl("jdbc:postgresql://localhost/cctv");
        dataSource.setUsername("postgres");
        dataSource.setPassword("123456");*/
        
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlsessionfactorybean(){
        SqlSessionFactoryBean sqlsessionfactoryBean = new SqlSessionFactoryBean();
        sqlsessionfactoryBean.setDataSource(datasource);
        return sqlsessionfactoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(datasource);
    }

}
