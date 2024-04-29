package cn.yujian95.hospital.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;



@MapperScan("cn.yujian95.hospital.mapper")
@Configuration
public class MybatisConfig {
}
