package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.ProductClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.ProductParam;
import cn.wpin.mall.product.dto.ProductQueryParam;
import cn.wpin.mall.product.dto.ProductResult;
import cn.wpin.mall.product.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品管理Service实现类
 *
 * @author wangpin
 */
@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductClient productClient;


    public int create(ProductParam productParam) {
        return productClient.create(productParam);
    }


    public ProductResult getUpdateInfo(Long id) {
        return productClient.getUpdateInfo(id);
    }


    public int update(Long id, ProductParam productParam) {
        return productClient.update(id, productParam);
    }


    public CommonPage<Product> list(ProductQueryParam productQueryParam, Integer pageSize, Integer pageNum) {
        return productClient.getList(productQueryParam, pageSize, pageNum);
    }


    public int updateVerifyStatus(List<Long> ids, Integer verifyStatus, String detail) {
        return productClient.updateVerifyStatus(ids, verifyStatus, detail);
    }


    public int updatePublishStatus(List<Long> ids, Integer publishStatus) {
        return productClient.updatePublishStatus(ids, publishStatus);
    }


    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return productClient.updateRecommendStatus(ids, recommendStatus);
    }


    public int updateNewStatus(List<Long> ids, Integer newStatus) {
        return productClient.updateNewStatus(ids, newStatus);
    }


    public int updateDeleteStatus(List<Long> ids, Integer deleteStatus) {
        return productClient.updateDeleteStatus(ids, deleteStatus);
    }


    public List<Product> list(String keyword) {
        return productClient.getList(keyword);
    }


}
