package cn.com.hiseas.mgmt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients({
        "cn.com.hiseas.center.course.api",
        "cn.com.hiseas.center.user.api"
})
public class HiseasMgmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiseasMgmtApplication.class, args);
    }

}
