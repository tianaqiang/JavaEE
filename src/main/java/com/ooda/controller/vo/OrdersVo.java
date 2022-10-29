package com.ooda.controller.vo;

import com.ooda.dao.bo.OrderItemBo;
import com.ooda.dao.bo.OrdersBo;
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

    public OrdersBo createOrders() {
        OrdersBo ordersBo = new OrdersBo();
        ordersBo.setConsignee(this.consignee);
        ordersBo.setRegionId(this.regionId);
        ordersBo.setAddress(this.address);
        ordersBo.setMobile(this.mobile);
        ordersBo.setMessage(this.message);
        ordersBo.setCouponId(this.couponId);
        ordersBo.setPid(this.presaleId);
        ordersBo.setGrouponId(this.grouponId);

        if (orderItems != null) {
            List<OrderItemBo> orderItemBoList = new ArrayList<>(orderItems.size());
            for (OrderItemVo orderItemVo : orderItems)
                orderItemBoList.add(orderItemVo.createOrderItem());
            ordersBo.setOrderItemList(orderItemBoList);
        }

        return ordersBo;
    }
}
