package cn.com.hiseas.mgmt.application.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/Refresh")
@RefreshScope
public class DynamicRefreshController {

    @Value("${url:123}")
    private String url;


    @SaIgnore
    @GetMapping("/getUrl")
    public String getUrl() {
        return url;
    }

}