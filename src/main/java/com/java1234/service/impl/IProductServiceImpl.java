package com.java1234.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java1234.entity.Product;
import com.java1234.mapper.ProductMapper;
import com.java1234.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品Service实现类
 * @author 龙翔宇
 * @create 2022-06-09
 */
@Service("productService")
public class IProductServiceImpl extends ServiceImpl<ProductMapper,Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;
}
