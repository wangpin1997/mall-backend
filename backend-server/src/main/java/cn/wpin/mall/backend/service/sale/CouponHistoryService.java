package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.CouponHistoryClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.CouponHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 优惠券领取记录管理Service实现类
 *
 * @author wangpin
 */
@Service
public class CouponHistoryService {

    @Autowired
    private CouponHistoryClient couponHistoryClient;

    public CommonPage<CouponHistory> list(Long couponId, Integer useStatus, String orderSn, Integer pageSize, Integer pageNum) {
        return couponHistoryClient.list(couponId, useStatus, orderSn, pageSize, pageNum);
    }
}
