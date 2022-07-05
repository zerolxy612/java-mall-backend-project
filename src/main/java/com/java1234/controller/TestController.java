package com.java1234.controller;

import com.java1234.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 * @author 龙翔宇
 * @create 2022-06-09
 */
@RestController
@RequestMapping("/java1234")
public class TestController {

    /**
     * 测试
     * @return
     */
    @GetMapping("/test")
    public R test(){
        return R.ok("haoren");
    }
}
