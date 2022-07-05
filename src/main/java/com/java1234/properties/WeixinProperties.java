package com.java1234.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信小程序配置文件
 * @author 龙翔宇
 * @create 2022-06-23
 */
@Component
@ConfigurationProperties(prefix = "weixin")
@Data
public class WeixinProperties {

    private String jscode2sessionUrl; // 登录凭证校验请求地址

    private String appid; // 小程序 appId

    private String secret; // 小程序 appSecret


}
