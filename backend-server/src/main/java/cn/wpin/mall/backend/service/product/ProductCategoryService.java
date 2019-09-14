package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.ProductCategoryClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductCategoryParam;
import cn.wpin.mall.product.dto.ProductCategoryWithChildrenItem;
import cn.wpin.mall.product.entity.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductCategoryService实现类
 *
 * @author wangpin
 */
@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryClient productCategoryClient;


    public int create(ProductCategoryParam productCategoryParam) {
        return productCategoryClient.create(productCategoryParam);
    }


    public int update(Long id, ProductCategoryParam productCategoryParam) {
        return productCategoryClient.update(id, productCategoryParam);
    }


    public CommonPage<ProductCategory> getList(Long parentId, Integer pageSize, Integer pageNum) {
        return productCategoryClient.getList(parentId, pageSize, pageNum);
    }


    public int delete(Long id) {
        return productCategoryClient.delete(id);
    }


    public ProductCategory getItem(Long id) {
        return productCategoryClient.getItem(id);
    }


    public int updateNavStatus(List<Long> ids, Integer navStatus) {
        return productCategoryClient.updateNavStatus(ids, navStatus);
    }


    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        return productCategoryClient.updateShowStatus(ids, showStatus);
    }


    public List<ProductCategoryWithChildrenItem> listWithChildren() {
        return productCategoryClient.listWithChildren();
    }

}
