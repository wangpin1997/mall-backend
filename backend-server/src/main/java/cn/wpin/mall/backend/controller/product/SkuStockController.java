package cn.wpin.mall.backend.controller.product;

import cn.wpin.mall.backend.service.product.SkuStockService;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.product.entity.SkuStock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sku库存Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "sku商品库存管理")
@RequestMapping("/sku")
public class SkuStockController {

    @Autowired
    private SkuStockService skuStockService;

    @ApiOperation("根据商品编号及编号模糊搜索sku库存")
    @RequestMapping(value = "/{pid}", method = RequestMethod.GET)
    public CommonResult<List<SkuStock>> getList(@PathVariable Long pid, @RequestParam(value = "keyword", required = false) String keyword) {
        List<SkuStock> skuStockList = skuStockService.getList(pid, keyword);
        return CommonResult.success(skuStockList);
    }

    @ApiOperation("批量更新库存信息")
    @RequestMapping(value = "/update/{pid}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long pid, @RequestBody List<SkuStock> skuStockList) {
        int count = skuStockService.update(pid, skuStockList);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
