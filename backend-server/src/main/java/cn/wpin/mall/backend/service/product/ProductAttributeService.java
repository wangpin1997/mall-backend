package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.ProductAttributeClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttrInfo;
import cn.wpin.mall.product.dto.ProductAttributeParam;
import cn.wpin.mall.product.entity.ProductAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品属性Service实现类
 *
 * @author wangpin
 */
@Service
public class ProductAttributeService {

    @Autowired
    private ProductAttributeClient productAttributeClient;


    public CommonPage<ProductAttribute> getList(Long cid, Integer type, Integer pageSize, Integer pageNum) {
        return productAttributeClient.getList(cid, type, pageSize, pageNum);
    }


    public int create(ProductAttributeParam productAttributeParam) {
        return productAttributeClient.create(productAttributeParam);
    }


    public int update(Long id, ProductAttributeParam productAttributeParam) {
        return productAttributeClient.update(id, productAttributeParam);
    }


    public ProductAttribute getItem(Long id) {
        return productAttributeClient.getItem(id);
    }


    public int delete(List<Long> ids) {
        return productAttributeClient.delete(ids);
    }


    public List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId) {
        return productAttributeClient.getAttrInfo(productCategoryId);
    }
}
