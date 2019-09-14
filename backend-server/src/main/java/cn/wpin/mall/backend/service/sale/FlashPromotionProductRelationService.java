package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.FlashPromotionProductRelationClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.FlashPromotionProduct;
import cn.wpin.mall.sale.entity.FlashPromotionProductRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 限时购商品关联管理Service实现类
 *
 * @author wangpin
 */
@Service
public class FlashPromotionProductRelationService {
    @Autowired
    private FlashPromotionProductRelationClient client;


    public int create(List<FlashPromotionProductRelation> relationList) {
        return client.create(relationList);
    }

    public int update(Long id, FlashPromotionProductRelation relation) {
        return client.update(id, relation);
    }

    public int delete(Long id) {
        return client.delete(id);
    }

    public FlashPromotionProductRelation getItem(Long id) {
        return client.getItem(id);
    }

    public CommonPage<FlashPromotionProduct> list(Long flashPromotionId, Long flashPromotionSessionId, Integer pageSize, Integer pageNum) {
        return client.list(flashPromotionId, flashPromotionSessionId, pageSize, pageNum);
    }

}
