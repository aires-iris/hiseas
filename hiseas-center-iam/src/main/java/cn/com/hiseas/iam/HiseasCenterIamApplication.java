package cn.com.hiseas.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients({
        "cn.com.hiseas.center.user.api"
})
public class HiseasCenterIamApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiseasCenterIamApplication.class, args);
    }

}
