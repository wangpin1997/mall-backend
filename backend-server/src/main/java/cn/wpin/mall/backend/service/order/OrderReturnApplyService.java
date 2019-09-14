package cn.wpin.mall.backend.service.order;


import cn.wpin.mall.client.order.OrderReturnApplyClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.order.dto.OrderReturnApplyResult;
import cn.wpin.mall.order.dto.ReturnApplyQueryParam;
import cn.wpin.mall.order.dto.UpdateStatusParam;
import cn.wpin.mall.order.entity.OrderReturnApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退货申请管理Service
 * @author wangpin
 */
@Service
public class OrderReturnApplyService {

    @Autowired
    private OrderReturnApplyClient orderReturnApplyClient;


    /**
     * 分页查询申请
     */
    public CommonPage<OrderReturnApply> list(ReturnApplyQueryParam queryParam, Integer pageSize, Integer pageNum) {
       return orderReturnApplyClient.list(queryParam, pageSize, pageNum);
    }

    /**
     * 批量删除申请
     */
    public int delete(List<Long> ids) {
        return orderReturnApplyClient.delete(ids);
    }

    /**
     * 修改申请状态
     */
    public int updateStatus(Long id, UpdateStatusParam statusParam) {
        return orderReturnApplyClient.updateStatus(id, statusParam);
    }

    /**
     * 获取指定申请详情
     */
    public OrderReturnApplyResult getItem(Long id) {
        return orderReturnApplyClient.getItem(id);
    }



}
