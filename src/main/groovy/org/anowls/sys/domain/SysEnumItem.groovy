package org.anowls.sys.domain

import javax.persistence.Column
import javax.persistence.Table

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.NotBlank

@ApiModel(value = "数据字典分类数据项")
@Table(name = "sys_enum_item")
class SysEnumItem extends BaseDomain implements Serializable {

    private static final long serialVersionUID = -8665301651565824015L

    @ApiModelProperty(value = "数据字典数据项Id", required = true)
    @Column(name = "se_id")
    private String seId

    @ApiModelProperty(value = "数据字典数据项父Id")
    @Column(name = "sei_parent_id")
    private String seParentId

    @ApiModelProperty(value = "数据字典数据项父编码")
    @Column(name = "sei_parent_code")
    private String seiParentCode

    @ApiModelProperty(value = "编码", required = true)
    @NotBlank(message = "数据字典数据项编码必填！")
    @Length(max = 50, message = "数据字典数据项编码长度不能超过50位！")
    @Column(name = "sei_code")
    private String seiCode

    @ApiModelProperty(value = "名称", required = true)
    @NotBlank(message = "数据字典数据项名称必填！")
    @Length(max = 60, message = "数据字典数据项名称长度不能超过60位！")
    @Column(name = "sei_name")
    private String seiName

    @ApiModelProperty(value = "描述")
    @Length(max = 150, message = " 数据字典数据项描述长度不能超过150位！")
    @Column(name = "sei_desc")
    private String seiDesc

    @ApiModelProperty(value = "排序号", required = true)
    @NotBlank(message = "数据字典数据项排序号必填！")
    @Column(name = "sei_sort")
    private Integer seiSort

    @ApiModelProperty(value = "拼音")
    @Length(max = 100, message = " 数据字典数据项拼音长度不能超过100位！")
    @Column(name = "pinyin")
    private String pinYin

    @ApiModelProperty(value = "简拼")
    @Length(max = 30, message = "数据字典数据项简拼长度不能超过30位！")
    @Column(name = "fast_pinyin")
    private String fastPinYin

    @ApiModelProperty(value = "状态 (1 启用 0 停用) 默认1", required = true)
    @Column(name = "status")
    private Integer status = 1

}
