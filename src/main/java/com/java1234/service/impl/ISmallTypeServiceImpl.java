package com.java1234.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.java1234.entity.SmallType;
import com.java1234.mapper.BigTypeMapper;
import com.java1234.mapper.SmallTypeMapper;
import com.java1234.service.ISmallTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品小类Service实现类
 * @author 龙翔宇
 * @create 2022-06-09
 */
@Service("smallTypeService")
public class ISmallTypeServiceImpl extends ServiceImpl<SmallTypeMapper, SmallType> implements ISmallTypeService {

    @Autowired
    private BigTypeMapper smallTypeMapper;
}
