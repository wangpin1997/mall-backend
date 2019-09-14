package cn.wpin.mall.backend.controller.content;


import cn.wpin.mall.backend.service.content.SubjectService;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.content.entity.Subject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品专题Controller
 *
 * @author wangpin
 */
@RestController
@Api(tags = "商品专题管理")
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<Subject>> listAll() {
        return CommonResult.success(subjectService.listAll());
    }

    @ApiOperation(value = "根据专题名称分页获取专题")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<Subject>> getList(@RequestParam(value = "keyword", required = false) String keyword,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                     @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
        return CommonResult.success(subjectService.list(keyword, pageNum, pageSize));
    }
}
