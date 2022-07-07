package com.java1234.controller;
/**
 * 订单Controller控制器
 * @author 龙翔宇
 * @create 2022-06-09
 */
import com.java1234.entity.Order;
import com.java1234.entity.OrderDetail;
import com.java1234.entity.R;
import com.java1234.service.IOrderDetailService;
import com.java1234.service.IOrderService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试
 * @author 订单controller控制器
 * @create 2022-06-21
 */
//商品订单
@RestController
@RequestMapping("/my/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;


    /**
     * 创建订单,返回订单号
     * @param token
     * @return
     */
    @RequestMapping("/create")
    public R create(@RequestBody Order order,@RequestHeader(value = "token")String token){
        // 通过token 获取 openid
        System.out.println("token" + token);
        // 通过token获取openid
        System.out.println("token="+token);
        System.out.println("order="+order);
        // 添加订单到数据库
        Claims claims = JwtUtils.validateJWT(token).getClaims();
        if(claims!=null){
            System.out.println("openid="+claims.getId());
            order.setUserId(claims.getId());
        }
        order.setOrderNo("JAVA"+DateUtil.getCurrentDateStr());
        order.setCreateDate(new Date());

        OrderDetail[] goods = order.getGoods();
        orderService.save(order);

        // 添加订单详情到数据库
        return R.ok();
    }

}
