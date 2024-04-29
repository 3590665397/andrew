package cn.yujian95.hospital.dto.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;



@ApiModel(value = "MedicantInfoParam", description = "医院信息参数")
@Data
public class MedicantInfoParam implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 药物名称
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "药物名称")
    private String name;

    /**
     * 药物数量
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "药物数量")
    private String muber;

    /**
     * 医院地址
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "医院地址")
    private String address;

    /**
     * 药物简介
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "药物简介")
    private String description;

    /**
     * 药物图片
     *
     * @mbg.generated
     */
    @ApiModelProperty(value = "药物图片")
    private String picture;
}
