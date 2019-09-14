package cn.wpin.mall.backend.controller.user;

import cn.wpin.mall.backend.service.user.MemberLevelService;
import cn.wpin.mall.common.entity.CommonResult;
import cn.wpin.mall.user.entity.MemberLevel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员等级管理Controller
 * @author wangpin
 */
@RestController
@Api(tags = "会员等级")
@RequestMapping("memberLevel")
public class MemberLevelController {

    @Autowired
    private MemberLevelService memberLevelService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation("查询所有会员等级")
    public CommonResult<List<MemberLevel>> list(@RequestParam("defaultStatus") Integer defaultStatus) {
        List<MemberLevel> memberLevelList = memberLevelService.list(defaultStatus);
        return CommonResult.success(memberLevelList);
    }
}
