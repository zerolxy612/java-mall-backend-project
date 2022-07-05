package com.java1234.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.java1234.entity.R;
import com.java1234.entity.WxUserInfo;
import com.java1234.properties.WeixinProperties;
import com.java1234.service.IWxUserInfoService;
import com.java1234.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 微信用户Controller
 * @author 龙翔宇
 * @create 2022-06-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private WeixinProperties weixinProperties;

    @Autowired
    private HttpClientUtil httpClientUtil;

    @Autowired
    private IWxUserInfoService wxUserInfoService;
    /**
     * 微信用户登录
     * @return
     */
    @RequestMapping("/wxlogin")
    public R wxLogin(@RequestBody WxUserInfo wxUserInfo){
        System.out.println(wxUserInfo.getCode());
        String jscode2sessionUrl=weixinProperties.getJscode2sessionUrl()+"?appid="+weixinProperties.getAppid()+"&secret="+weixinProperties.getSecret()+"&js_code="+wxUserInfo.getCode()+"&grant_type=authorization_code";
        System.out.println(jscode2sessionUrl);

        String result = httpClientUtil.sendHttpGet(jscode2sessionUrl);
        System.out.println(result);

        JSONObject jsonObject= JSON.parseObject(result);
        String openid = jsonObject.get("openid").toString();
        System.out.println(openid);

        //插入用户到数据库 用户不存在插入用户 存在则更新用户
        WxUserInfo resultWxUserInfo =  wxUserInfoService.getOne(new QueryWrapper<WxUserInfo>().eq("openid",openid));
        if(resultWxUserInfo==null){
            //用户不存在
            wxUserInfo.setOpenid(openid);
            wxUserInfo.setRegisterDate(new Date());
            wxUserInfo.setLastLoginDate(new Date());
            wxUserInfoService.save(wxUserInfo);
        }else{
            resultWxUserInfo.setNickName(wxUserInfo.getNickName());
            resultWxUserInfo.setAvatarUrl(wxUserInfo.getAvatarUrl());
            resultWxUserInfo.setLastLoginDate(new Date());
            wxUserInfoService.updateById(resultWxUserInfo);
        }

        return R.ok();
    }
}
