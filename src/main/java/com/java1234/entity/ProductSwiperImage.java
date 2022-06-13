package com.java1234.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品轮播图片
 * @author 龙翔宇
 * @create 2022-06-13
 */
@TableName("t_product_swiper_image")
@Data
public class ProductSwiperImage {

    private Integer id; // 编号

    private String image; // 图片名称

    private Integer sort; // 排列序号 从小到大排序

    private Integer productId; // 所属产品


}
