package me.zhongmin.product.service;

import me.zhongmin.product.common.DecreaseStockInput;
import me.zhongmin.product.common.ProductInfoOutput;
import me.zhongmin.product.dataobject.ProductInfo;

import java.util.List;

/**

 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
