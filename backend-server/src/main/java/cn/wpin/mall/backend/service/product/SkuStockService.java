package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.SkuStockClient;
import cn.wpin.mall.product.entity.SkuStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品sku库存管理Service实现类
 *
 * @author wangpin
 */
@Service
public class SkuStockService {

    @Autowired
    private SkuStockClient skuStockClient;


    public List<SkuStock> getList(Long pid, String keyword) {
        return skuStockClient.getList(pid, keyword);
    }


    public int update(Long pid, List<SkuStock> skuStockList) {
        return skuStockClient.update(pid, skuStockList);
    }
}
