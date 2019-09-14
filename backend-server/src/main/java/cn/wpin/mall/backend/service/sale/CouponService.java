package cn.wpin.mall.backend.service.sale;


import cn.wpin.mall.client.sale.CouponClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.dto.CouponParam;
import cn.wpin.mall.sale.entity.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 优惠券管理Service实现类
 *
 * @author wangpin
 */
@Service
public class CouponService {

    @Autowired
    private CouponClient couponClient;


    public int create(CouponParam couponParam) {
        return couponClient.add(couponParam);
    }

    public int delete(Long id) {
        return couponClient.delete(id);
    }

    public int update(Long id, CouponParam couponParam) {
        return couponClient.update(id, couponParam);
    }

    public CommonPage<Coupon> list(String name, Integer type, Integer pageSize, Integer pageNum) {
        return couponClient.list(name, type, pageSize, pageNum);
    }

    public CouponParam getItem(Long id) {
        return couponClient.getItem(id);
    }
}
