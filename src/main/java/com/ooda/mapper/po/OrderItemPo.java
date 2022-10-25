package com.ooda.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * @author TianAqiang
 * @since 2022-10-10
 */
@Data
@ApiModel(description = "订单明细-持久化对象")
public class OrderItemPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long orderId;

    private Long goodsSkuId;

    private Integer quantity;

    private Long price;

    private Long discount;

    private String name;

    private Long couponActivityId;

    private Long beShareId;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;
}
