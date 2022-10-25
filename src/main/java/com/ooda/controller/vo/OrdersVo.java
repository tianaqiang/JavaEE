package com.ooda.controller.vo;

import com.ooda.model.OrderItem;
import com.ooda.model.Orders;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 按照前端传过来的新建订单的属性设计字段
 * @Author 田阿强
 * @create 2022/10/10 20:44
 */
@Data
@ApiModel(description = "订单视图对象")
public class OrdersVo {

    private String consignee;

    private Long regionId;

    private String address;

    private String mobile;

    private String message;

    private Long couponId;

    private Long presaleId;

    private Long grouponId;

    private List<OrderItemVo> orderItems;

    public Orders createOrders() {
        Orders orders = new Orders();
        orders.setConsignee(this.consignee);
        orders.setRegionId(this.regionId);
        orders.setAddress(this.address);
        orders.setMobile(this.mobile);
        orders.setMessage(this.message);
        orders.setCouponId(this.couponId);
        orders.setPid(this.presaleId);
        orders.setGrouponId(this.grouponId);

        if (orderItems != null) {
            List<OrderItem> orderItemList = new ArrayList<>(orderItems.size());
            for (OrderItemVo orderItemVo : orderItems)
                orderItemList.add(orderItemVo.createOrderItem());
            orders.setOrderItemList(orderItemList);
        }

        return orders;
    }
}
