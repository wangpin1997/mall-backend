package cn.wpin.mall.backend.service.order;

import cn.wpin.mall.client.order.OrderSettingClient;
import cn.wpin.mall.order.entity.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单设置Service
 * @author wangpin
 */
@Service
public class OrderSettingService {

    @Autowired
    private OrderSettingClient orderSettingClient;

    /**
     * 获取指定订单设置
     */
    public OrderSetting getItem(Long id) {
        return orderSettingClient.getItem(id);
    }


    /**
     * 修改指定订单设置
     */
    public int update(Long id, OrderSetting orderSetting) {
       return orderSettingClient.update(id, orderSetting);
    }
    
    
}
