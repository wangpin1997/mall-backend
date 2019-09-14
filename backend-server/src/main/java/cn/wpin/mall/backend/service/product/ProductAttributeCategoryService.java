package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.ProductAttributeCategoryClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductAttributeCategoryItem;
import cn.wpin.mall.product.entity.ProductAttributeCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductAttributeCategoryService实现类
 *
 * @author wangpin
 */
@Service
public class ProductAttributeCategoryService {

    @Autowired
    private ProductAttributeCategoryClient productAttributeCategoryClient;

    public int create(String name) {
        return productAttributeCategoryClient.create(name);
    }


    public int update(Long id, String name) {
        return productAttributeCategoryClient.update(id, name);
    }


    public int delete(Long id) {
        return productAttributeCategoryClient.delete(id);
    }


    public ProductAttributeCategory getItem(Long id) {
        return productAttributeCategoryClient.getItem(id);
    }


    public CommonPage<ProductAttributeCategory> getList(Integer pageSize, Integer pageNum) {
        return productAttributeCategoryClient.getList(pageSize, pageNum);
    }


    public List<ProductAttributeCategoryItem> getListWithAttr() {
        return productAttributeCategoryClient.getListWithAttr();
    }
}
