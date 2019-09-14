package cn.wpin.mall.backend.service.order;


import cn.wpin.mall.client.order.OrderClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.order.dto.*;
import cn.wpin.mall.order.entity.Order;
import cn.wpin.mall.order.entity.OrderOperateHistory;
import cn.wpin.mall.order.example.OrderExample;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单管理Service
 * @author wangpin 
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderClient orderClient;




    public CommonPage<Order> list(OrderQueryParam queryParam, Integer pageSize, Integer pageNum) {
        return orderClient.list(queryParam, pageSize, pageNum);
    }


    public int delivery(List<OrderDeliveryParam> deliveryParamList) {
       return orderClient.delivery(deliveryParamList);
    }


    public int close(List<Long> ids, String note) {
        return orderClient.close(ids, note);
    }

    public int delete(List<Long> ids) {
        return orderClient.delete(ids);
    }

    public OrderDetail detail(Long id) {
        return orderClient.detail(id);
    }


    public int updateReceiverInfo(ReceiverInfoParam receiverInfoParam) {
       return orderClient.updateReceiverInfo(receiverInfoParam);
    }



    public int updateMoneyInfo(MoneyInfoParam moneyInfoParam) {
        return orderClient.updateReceiverInfo(moneyInfoParam);
    }


    /**
     * 修改订单备注
     */

    public int updateNote(Long id, String note, Integer status) {
      return orderClient.updateNote(id,note,status);
    }

}
