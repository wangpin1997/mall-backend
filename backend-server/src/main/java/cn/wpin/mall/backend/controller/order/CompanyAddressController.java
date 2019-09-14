package cn.wpin.mall.backend.controller.order;


import cn.wpin.mall.backend.service.order.CompanyAddressService;
import cn.wpin.mall.order.entity.CompanyAddress;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 收货地址管理Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "收货地址管理")
@RequestMapping("/companyAddress")
public class CompanyAddressController {

    @Autowired
    private CompanyAddressService companyAddressService;

    @ApiOperation("获取所有收货地址")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<CompanyAddress> list() {
        return companyAddressService.list();
    }
}
