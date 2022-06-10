package com.java1234.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 商品大类
 * @author 龙翔宇
 * @date 2022-06-10
 */
@TableName("t_bigType")
@Data
public class BigType {

    private Integer id; // 编号

    private String name; // 名称

    private String remark; // 备注

    private String image="default.jpg"; // 封面图片


}
