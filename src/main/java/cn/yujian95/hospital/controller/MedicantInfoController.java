package cn.yujian95.hospital.controller;

import cn.yujian95.hospital.common.api.CommonPage;
import cn.yujian95.hospital.common.api.CommonResult;
import cn.yujian95.hospital.dto.param.MedicantInfoParam;
import cn.yujian95.hospital.entity.MedicantInfo;
import cn.yujian95.hospital.service.IMedicantInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;



@Api(value = "药物模块", tags = "药物信息接口")
@RestController
@CrossOrigin
@RequestMapping("/medicant")
public class MedicantInfoController {

    @Resource
    private IMedicantInfoService infoService;

    @ApiOperation(value = "添加药物信息", notes = "传入 药物信息参数（名称，图片、数量，地址，简介）")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public CommonResult insertMedicantInfo(@RequestBody MedicantInfoParam param) {

        if (infoService.insert(param)) {
            return CommonResult.success();
        }

        return CommonResult.failed("服务器错误，请联系管理员！");
    }

    @ApiOperation(value = "更新药物信息", notes = "传入 药物编号、药物信息参数（名称，图片、数量，地址，简介）")
    @ApiImplicitParam(name = "id", value = "药物编号", paramType = "path", dataType = "Long", required = true)
    @RequestMapping(value = "/info/{id}", method = RequestMethod.PUT)
    public CommonResult updateMedicantInfo(@PathVariable Long id, @RequestBody MedicantInfoParam param) {

        if (!infoService.count(id)) {
            return CommonResult.validateFailed("不存在，该药物编号！");
        }

        if (infoService.update(id, param)) {
            return CommonResult.success();
        }

        return CommonResult.failed("服务器错误，请联系管理员！");
    }

    @ApiOperation(value = "删除药物信息", notes = "传入 药物编号")
    @ApiImplicitParam(name = "id", value = "药物编号", paramType = "path", dataType = "Long", required = true)
    @RequestMapping(value = "/info/{id}", method = RequestMethod.DELETE)
    public CommonResult deleteMedicantInfo(@PathVariable Long id) {

        if (!infoService.count(id)) {
            return CommonResult.validateFailed("不存在，该药物编号！");
        }

        if (infoService.delete(id)) {
            return CommonResult.success();
        }

        return CommonResult.failed("服务器错误，请联系管理员！");
    }

    @ApiOperation(value = "分页：搜索药物信息", notes = "传入 药物名称")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "药物名称", paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "第几页", paramType = "query", dataType = "Integer",
                    required = true),
            @ApiImplicitParam(name = "pageSize", value = "页大小", paramType = "query", dataType = "Integer",
                    required = true)
    })
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<MedicantInfo>> searchMedicantInfo(@RequestParam(required = false) String name,
                                                                     @RequestParam Integer pageNum,
                                                                     @RequestParam Integer pageSize) {

        return CommonResult.success(CommonPage.restPage(infoService.list(name, pageNum, pageSize)));
    }


}
