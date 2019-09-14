package cn.wpin.mall.backend.controller.sale;


import cn.wpin.mall.backend.service.sale.CouponHistoryService;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.sale.entity.CouponHistory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 优惠券领取记录管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "优惠券领取记录管理")
@RequestMapping("/couponHistory")
public class CouponHistoryController {

    @Autowired
    private CouponHistoryService historyService;

    @ApiOperation("根据优惠券id，使用状态，订单编号分页获取领取记录")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<CouponHistory>> list(@RequestParam(value = "couponId", required = false) Long couponId,
                                                        @RequestParam(value = "useStatus", required = false) Integer useStatus,
                                                        @RequestParam(value = "orderSn", required = false) String orderSn,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(historyService.list(couponId, useStatus, orderSn, pageSize, pageNum));
    }
}
