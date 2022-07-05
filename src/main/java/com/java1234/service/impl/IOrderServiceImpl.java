package com.java1234.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java1234.entity.Order;
import com.java1234.mapper.OrderMapper;
import com.java1234.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单Service实现类
 * @author 龙翔宇
 * @create 2022-07-05
 */
@Service("orderService")
public class IOrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
}
