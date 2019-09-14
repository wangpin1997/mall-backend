package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.HomeRecommendProductClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页人气推荐管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:28:37
 */
@Service
public class HomeRecommendProductService {
    @Autowired
    private HomeRecommendProductClient homeRecommendProductClient;

    public int create(List<HomeRecommendProduct> homeRecommendProductList) {
        return homeRecommendProductClient.create(homeRecommendProductList);
    }

    public int updateSort(Long id, Integer sort) {
        return homeRecommendProductClient.updateSort(id, sort);
    }

    public int delete(List<Long> ids) {
        return homeRecommendProductClient.delete(ids);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return homeRecommendProductClient.updateRecommendStatus(ids, recommendStatus);
    }

    public CommonPage<HomeRecommendProduct> list(String productName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return homeRecommendProductClient.list(productName, recommendStatus, pageSize, pageNum);
    }
}
