package org.anowls.sys.web

import org.anowls.sys.common.PageQuery
import org.anowls.sys.common.SimplePage
import org.anowls.sys.common.message.SimpleMessage
import org.anowls.sys.domain.SysEnum
import org.anowls.sys.domain.SysEnumItem
import org.anowls.sys.domain.view.SysEnumVO
import org.anowls.sys.service.SysEnumService

import com.google.common.collect.Lists
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiImplicitParams
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * <p>Title: sys-platform</p>
 * <p>Description: 这里填写描述信息</p>
 * <p>Copyright: Copyright © 2017-2020 汉博德信息技术有限公司 All Rights Reserved</p>
 * <p>Company: http://www.hanboard.com</p>
 *
 * @author haopeisong
 * @date 2018/1/26 0026
 */
@RestController
@RequestMapping(value = "/enum")
@Api(tags = "数据字典分类-控制层")
class SysEnumController {

    @Autowired
    private SysEnumService sysEnumService

    /**
     * 根据数据字典分类编码查询对应数据项
     *
     * @param codes 数据字典分类编码，多个以“,”分隔
     * @return 数据字典分类数据项列表
     */
    @ApiOperation(value = "查询字典数据分类数据项", notes = "查询字典数据分类数据项")
    @GetMapping(value = "/queryByCodes/{codes}")
    List<SysEnumVO> queryByCodes(
            @ApiParam(value = "数据字典分类编码，多个以“,”分隔", required = true) @PathVariable String codes) {
        sysEnumService.queryByCodes(codes)
    }

    /**
     * 分页查询数据字典分类
     *
     * @param pagerQuery 分页参数
     * @return 数据字典分类列表
     */
    @ApiOperation(value = "分页查询数据字典分类", notes = "分页查询数据字典分类")
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParams([
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数据条数", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "filter", value = "查询条件（title=）", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "排序规则（id=asc）", paramType = "query")
    ])
    SimplePage<SysEnum> query(PageQuery pagerQuery) {
        sysEnumService.query(pagerQuery)
    }

    /**
     * 根据数据字典分类ID查询数据字典分类数据项
     *
     * @param id 数据字典分类ID
     * @return 数据字典分类数据项列表
     */
    @ApiOperation(value = "查询数据字典分类数据项", notes = "根据数据字典分类ID查询数据字典分类数据项")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SimpleMessage getById(@ApiParam(value = "数据字典ID", required = true) @PathVariable String id) {
        sysEnumService.getById(id)
    }

    /**
     * 新增数据字典分类
     *
     * @param sysEnum 数据字典分类信息
     * @return 操作结果
     */
    @PostMapping
    @ApiOperation(value = "新增数据字典分类", notes = "新增数据字典分类")
    SimpleMessage insert(@ApiParam(value = "数据字典信息", required = true) @RequestBody SysEnum sysEnum) {
        sysEnumService.insert(sysEnum)
        SimpleMessage.info("保存成功！")
    }

    /**
     * 修改数据字典分类信息
     *
     * @param sysEnum 数据字典分类信息
     * @return 操作结果
     */
    @PutMapping
    @ApiOperation(value = "修改数据字典分类信息", notes = "修改数据字典分类信息")
    SimpleMessage update(@ApiParam(value = "数据字典分类信息", required = true) @RequestBody SysEnum sysEnum) {
        sysEnumService.update(sysEnum)
        SimpleMessage.info("修改成功！")
    }

    /**
     * 删除数据字典分类数据
     *
     * @param id 数据字典分类ID
     * @return 操作结果
     */
    @ApiOperation(value = "删除数据字典数据", notes = "删除数据字典数据")
    @DeleteMapping(value = "/{id}")
    SimpleMessage delete(@ApiParam(value = "数据字典分类ID", required = true) @PathVariable String id) {
        sysEnumService.delete(id)
        SimpleMessage.info("删除成功！")
    }

    /**
     * 启用数据字典分类
     *
     * @param id 数据字典分类ID
     * @return 操作结果
     */
    @PostMapping(value = "/enable/{id}")
    @ApiOperation(value = "启用数据字典分类", notes = "启用数据字典分类")
    SimpleMessage enable(@ApiParam(value = "数据字典分类ID", required = true) @PathVariable String id) {
        sysEnumService.enable(id)
    }

    /**
     * 停用数据字典分类
     *
     * @param id 数据字典分类ID
     * @return 操作结果
     */
    @PostMapping(value = "/disable/{id}")
    @ApiOperation(value = "停用数据字典分类", notes = "停用数据字典分类")
    SimpleMessage disable(@ApiParam(value = "数据字典分类ID", required = true) @PathVariable String id) {
        sysEnumService.disable(id)
    }

    /**
     * 根据数据字典分类数据项ID查询数据字典分类数据项信息
     *
     * @param id 数据字典分类数据项ID
     * @return 数据字典分类数据项信息
     */
    @GetMapping(value = "/item/{id}")
    @ApiOperation(value = "根据数据字典分类数据项ID查询数据字典分类数据项信息", notes = "根据数据字典分类数据项ID查询数据字典分类数据项信息")
    SimpleMessage getItemById(@ApiParam(value = "数据字典分类数据项ID", required = true) @PathVariable String id) {
        sysEnumService.getItemById(id)
    }

    /**
     * 分页查询数据字典分类数据项
     *
     * @param pageQuery 分页参数
     * @return 数据字典分类数据项列表
     */
    @ApiOperation(value = "分页查询数据字典分类数据项", notes = "分页查询数据字典分类数据项")
    @GetMapping(value = "/item")
    @ApiImplicitParams([
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数据条数", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "filter", value = "查询条件（id=code=title=)", paramType = "query"),
            @ApiImplicitParam(name = "order", value = "排序规则", paramType = "query")
    ])
    SimplePage<SysEnumItem> queryItem(PageQuery pageQuery) {
        sysEnumService.queryItem(pageQuery)
    }

    /**
     * 新增数据字典分类数据项
     *
     * @param enumItem 数据字典分类数据项
     * @return 操作结果
     */
    @PostMapping(value = "/item")
    @ApiOperation(value = "新增数据字典分类数据项", notes = "新增数据字典分类数据项")
    SimpleMessage insertItem(@ApiParam(value = "数据字典数据项", required = true) @RequestBody SysEnumItem enumItem) {
        sysEnumService.insertItem(enumItem)
        SimpleMessage.info("保存成功！")
    }

    /**
     * 修改数据字典分类数据项
     *
     * @param enumItem 数据字典分类数据项
     * @return 操作结果
     */
    @PutMapping(value = "/item")
    @ApiOperation(value = "修改数据字典分类数据项", notes = "修改数据字典分类数据项")
    SimpleMessage updateItem(@ApiParam(value = "数据字典分类数据项", required = true) @RequestBody SysEnumItem enumItem) {
        sysEnumService.updateItem(enumItem)
        SimpleMessage.info("保存成功！")
    }

    /**
     * 删除数据字典分类数据项
     *
     * @param 数据字典数据项ID
     * @return 操作结果
     */
    @DeleteMapping(value = "/item/{id}")
    @ApiOperation(value = "删除数据字典分类数据项", notes = "删除数据字典分类数据项")
    SimpleMessage deleteItem(@ApiParam(value = "数据字典分类数据项ID", required = true) @PathVariable String id) {
        sysEnumService.deleteItem(Lists.newArrayList(id))
        SimpleMessage.info("删除成功！")
    }

    /**
     * 启用数据字典分类数据项
     *
     * @param id 数据字典分类数据项ID
     * @return 操作结果
     */
    @PostMapping(value = "/item/enable/{id}")
    @ApiOperation(value = "启用数据字典分类数据项", notes = "启用数据字典分类数据项")
    SimpleMessage enableItem(@ApiParam(value = "数据字典分类数据项ID", required = true) @PathVariable String id) {
        sysEnumService.enableItem(id)
    }

    /**
     * 停用数据字典分类数据项
     *
     * @param id 数据字典分类数据项ID
     * @return 操作结果
     */
    @PostMapping(value = "/item/disable/{id}")
    @ApiOperation(value = "停用数据字典分类数据项", notes = "停用数据字典分类数据项")
    SimpleMessage disableItem(@ApiParam(value = "数据字典分类数据项ID", required = true) @PathVariable String id) {
        sysEnumService.disableItem(id)
    }
}
