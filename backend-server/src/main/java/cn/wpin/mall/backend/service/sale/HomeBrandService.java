package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.HomeBrandClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页品牌管理Service实现类
 *
 * @author wpin
 * @date 2019-9-13 10:27:09
 */
@Service
public class HomeBrandService {
    @Autowired
    private HomeBrandClient homeBrandClient;

    public int create(List<HomeBrand> homeBrandList) {
        return homeBrandClient.create(homeBrandList);
    }

    public int updateSort(Long id, Integer sort) {
        return homeBrandClient.updateSort(id, sort);
    }

    public int delete(List<Long> ids) {
        return homeBrandClient.delete(ids);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return homeBrandClient.updateRecommendStatus(ids, recommendStatus);
    }

    public CommonPage<HomeBrand> list(String brandName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return homeBrandClient.list(brandName, recommendStatus, pageSize, pageNum);
    }
}
