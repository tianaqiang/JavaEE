package com.ooda.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author TianAqiang
 * @since 2022-10-10
 */
@Data
@ApiModel(description = "订单持久化对象")
public class OrdersPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long customerId;

    private Long shopId;

    private String orderSn;

    private Long pid;

    private String consignee;

    private Long regionId;

    private String address;

    private String mobile;

    private String message;

    private Integer orderType;

    private Long freightPrice;

    private Long couponId;

    private Long couponActivityId;

    private Long discountPrice;

    private Long originPrice;

    private Long presaleId;

    private Long grouponDiscount;

    private Integer rebateNum;

    private LocalDateTime confirmTime;

    private String shipmentSn;

    private Integer state;

    private Integer substate;

    private Integer beDeleted;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;

    private Long grouponId;

}
