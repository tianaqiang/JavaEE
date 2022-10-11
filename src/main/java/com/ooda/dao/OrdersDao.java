package com.ooda.dao;

import com.ooda.entity.OrderItem;
import com.ooda.entity.OrderItemPo;
import com.ooda.entity.Orders;
import com.ooda.entity.OrdersPo;
import com.ooda.mapper.OrdersMapper;
import com.ooda.util.ResponseCode;
import com.ooda.util.ReturnObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author 田阿强
 * @create 2022/10/10 20:06
 */
@Repository
public class OrdersDao {
    private OrdersMapper ordersMapper;

    @Autowired
    public OrdersDao(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    /**
     * 根据id查找订单order
     * @param id
     * @return
     */
    public ReturnObject<Orders> findOrderById(Long id) {

        // 获取不包含OrderItems的OrdersPo，并交由Order代理
        OrdersPo ordersPo = ordersMapper.selectOrderById(id);
        Orders orders = new Orders(ordersPo);

        List<OrderItem> orderItemList = null;
        // 查询不为空
        if (ordersPo != null) {
            // 根据OrderId查找OrderItemPo，并交由OrderItem处理
            List<OrderItemPo> orderItemPoList = ordersMapper.selectOrderItemsByOrderId(ordersPo.getId());
            orderItemList = new ArrayList<>(orderItemPoList.size());
            for (OrderItemPo orderItemPo : orderItemPoList)
                orderItemList.add(new OrderItem(orderItemPo));
        }

        orders.setOrderItemList(orderItemList);

        return new ReturnObject<Orders>(orders);
    }

    /**
     * 新建订单order
     * @param orders
     * @return
     */
    public ReturnObject<Object> createOrder(Orders orders) {
        int flag = ordersMapper.insertNewOrder(orders.getOrdersPo());
        // FIELD_NOTVALID(503, "字段不合法"),
        if (flag == 0)
            return new ReturnObject<>(ResponseCode.FIELD_NOTVALID,"失败");

        List<OrderItem> ordersItemList = orders.getOrdersItemList();
        if (ordersItemList != null)
            for (OrderItem orderItem : ordersItemList) {
                flag = ordersMapper.insertNewOrderItem(orderItem.getOrderItemPo());
                if (flag == 0)
                    return new ReturnObject<>(ResponseCode.FIELD_NOTVALID, "失败");
            }

        return new ReturnObject<>(ResponseCode.OK);
    }
}
