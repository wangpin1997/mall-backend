package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.HomeNewProductClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeNewProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页新品推荐管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:27:53
 */
@Service
public class HomeNewProductService {
    @Autowired
    private HomeNewProductClient homeNewProductClient;

    public int create(List<HomeNewProduct> homeNewProductList) {
        return homeNewProductClient.create(homeNewProductList);
    }

    public int updateSort(Long id, Integer sort) {
        return homeNewProductClient.updateSort(id, sort);
    }

    public int delete(List<Long> ids) {
        return homeNewProductClient.delete(ids);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return homeNewProductClient.updateRecommendStatus(ids, recommendStatus);
    }

    public CommonPage<HomeNewProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return homeNewProductClient.list(productName, recommendStatus, pageSize, pageNum);
    }
}
