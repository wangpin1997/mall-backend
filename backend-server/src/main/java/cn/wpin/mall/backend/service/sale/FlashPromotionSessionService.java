package cn.wpin.mall.backend.service.sale;


import cn.wpin.mall.client.sale.FlashPromotionSessionClient;
import cn.wpin.mall.sale.dto.FlashPromotionSessionDetail;
import cn.wpin.mall.sale.entity.FlashPromotionSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 限时购场次管理Service实现类
 *
 * @author wangpin
 */
@Service
public class FlashPromotionSessionService {

    @Autowired
    private FlashPromotionSessionClient promotionSessionClient;


    public int create(FlashPromotionSession promotionSession) {
        return promotionSessionClient.create(promotionSession);
    }

    public int update(Long id, FlashPromotionSession promotionSession) {
        return promotionSessionClient.update(id, promotionSession);
    }

    public int updateStatus(Long id, Integer status) {
        return promotionSessionClient.updateStatus(id, status);
    }

    public int delete(Long id) {
        return promotionSessionClient.delete(id);
    }

    public FlashPromotionSession getItem(Long id) {
        return promotionSessionClient.getItem(id);
    }

    public List<FlashPromotionSession> list() {
        return promotionSessionClient.list();
    }

    public List<FlashPromotionSessionDetail> selectList(Long flashPromotionId) {
        return promotionSessionClient.selectList(flashPromotionId);
    }
}
