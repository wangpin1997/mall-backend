package cn.wpin.mall.backend.controller.content;


import cn.wpin.mall.backend.service.content.PrefrenceAreaService;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.content.entity.PrefrenceArea;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品优选管理Controller
 * @author wangpin 
 */
@RestController
@Api(tags = "商品优选管理")
@RequestMapping("/prefrenceArea")
public class PrefrenceAreaController {
    @Autowired
    private PrefrenceAreaService prefrenceAreaService;

    @ApiOperation("获取所有商品优选")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<PrefrenceArea>> listAll() {
        List<PrefrenceArea> prefrenceAreaList = prefrenceAreaService.listAll();
        return CommonResult.success(prefrenceAreaList);
    }
}
