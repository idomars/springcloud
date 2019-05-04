package me.zhongmin.product.service;

import me.zhongmin.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目

 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
