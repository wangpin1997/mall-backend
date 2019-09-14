package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.FlashPromotionClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.FlashPromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 限时购活动管理Service实现类
 *
 * @author wangpin
 */
@Service
public class FlashPromotionService {

    @Autowired
    private FlashPromotionClient flashPromotionClient;

    public int create(FlashPromotion flashPromotion) {
        return flashPromotionClient.create(flashPromotion);
    }

    public int update(Long id, FlashPromotion flashPromotion) {
        return flashPromotionClient.update(id, flashPromotion);
    }

    public int delete(Long id) {
        return flashPromotionClient.delete(id);
    }

    public int updateStatus(Long id, Integer status) {
        return flashPromotionClient.update(id, status);
    }

    public FlashPromotion getItem(Long id) {
        return flashPromotionClient.getItem(id);
    }

    public CommonPage<FlashPromotion> list(String keyword, Integer pageSize, Integer pageNum) {
        return flashPromotionClient.getItem(keyword, pageSize, pageNum);
    }
}
