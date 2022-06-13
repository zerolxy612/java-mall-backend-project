package com.java1234.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.java1234.entity.Product;
import com.java1234.entity.ProductSwiperImage;
import com.java1234.entity.R;
import com.java1234.service.IProductService;
import com.java1234.service.IProductSwiperImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品Controller
 * @author 龙翔宇
 * @create 2022-06-09
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IProductSwiperImageService productSwiperImageService;

    /**
     * 查询轮播商品
     * @return
     */
    @GetMapping("/findSwiper")
    public R findSwiper(){
        List<Product> swiperProductList = productService.list(new QueryWrapper<Product>().eq("isSwiper", true).orderByAsc("swiperSort"));
        Map<String,Object> map=new HashMap<>();
        map.put("message",swiperProductList);
        return R.ok(map);
    }

    /**
     * 查询前8个热卖商品
     * @return
     */
    @GetMapping("/findHot")
    public R findHot(){

        Page<Product> page = new Page<>(0,8);
        Page<Product> pageProduct = productService.page(page,new QueryWrapper<Product>().eq("isHot",true).orderByAsc("hotDateTime"));
        List<Product> hotProductList = pageProduct.getRecords();
        Map<String,Object> map=new HashMap<>();
        map.put("message",hotProductList);
        return R.ok(map);
    }

    /**
     * 根据id 查询商品信息
     * @return
     */
    @GetMapping("detail")
    public R dedatils(Integer id){
        Product product = productService.getById(id);
        List<ProductSwiperImage> productSwiperList = productSwiperImageService.list(new QueryWrapper<ProductSwiperImage>().eq("productId",product.getId()).orderByAsc("sort"));
        product.setProductSwiperImageList(productSwiperList);
        Map<String,Object> map=new HashMap<>();
        map.put("message",product);
        return R.ok(map);
    }

}
