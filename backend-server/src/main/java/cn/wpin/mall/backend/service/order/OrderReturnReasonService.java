package cn.wpin.mall.backend.service.order;


import cn.wpin.mall.client.order.OrderReturnReasonClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.order.entity.OrderReturnReason;
import cn.wpin.mall.order.example.OrderReturnReasonExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 订单原因管理Service
 * @author wangpin
 */
@Service
public class OrderReturnReasonService {

    @Autowired
    private OrderReturnReasonClient orderReturnReasonClient;


    /**
     * 添加订单原因
     */
    public int create(OrderReturnReason returnReason) {
        return orderReturnReasonClient.create(returnReason);
    }

    /**
     * 修改退货原因
     */
    public int update(Long id, OrderReturnReason returnReason) {
        return orderReturnReasonClient.update(id, returnReason);
    }

    /**
     * 批量删除退货原因
     */
    public int delete(List<Long> ids) {
       return orderReturnReasonClient.delete(ids);
    }


    /**
     * 分页获取退货原因
     */
    public CommonPage<OrderReturnReason> list(Integer pageSize, Integer pageNum) {
        return orderReturnReasonClient.list(pageSize, pageNum);
    }

    /**
     * 批量修改退货原因状态
     */
    public int updateStatus(List<Long> ids, Integer status) {
       return orderReturnReasonClient.updateStatus(status,ids);
    }

    /**
     * 获取单个退货原因详情信息
     */
    public OrderReturnReason getItem(Long id) {
        return orderReturnReasonClient.getItem(id);
    }


}
