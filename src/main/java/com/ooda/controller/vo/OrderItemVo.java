package com.ooda.controller.vo;

import com.ooda.model.OrderItem;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Desc 新建订单参数 -> OrderInfo -> orderItems
 * @Author 田阿强
 * @create 2022/10/10 20:52
 */
@Data
@ApiModel(description = "订单明细-视图对象")
public class OrderItemVo {

    private Long skuId;

    private Integer quantity;

    private Long couponActId;

    public OrderItem createOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setGoodsSkuId(this.skuId);
        orderItem.setQuantity(this.quantity);
        orderItem.setCouponActivityId(this.couponActId);
        return orderItem;
    }
}
