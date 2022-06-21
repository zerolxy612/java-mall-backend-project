package com.java1234.controller;
/**
 * 订单Controller控制器
 * @author 龙翔宇
 * @create 2022-06-09
 */
import com.java1234.entity.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//商品大类
@RestController
@RequestMapping("/my/order")
public class OrderController {

    /**
     * 创建订单,返回订单号
     * @param token
     * @return
     */
    @RequestMapping("/create")
    public R create(@RequestHeader(value = "token")String token{
        return R.ok();
    }

}
