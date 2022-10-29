package com.ooda.dao;

import com.ooda.dao.bo.OrderItemBo;
import com.ooda.mapper.po.OrderItemPo;
import com.ooda.dao.bo.OrdersBo;
import com.ooda.mapper.po.OrdersPo;
import com.ooda.mapper.OrdersMapper;
import com.ooda.util.ResponseCode;
import com.ooda.util.ReturnObject;
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
    public ReturnObject<OrdersBo> findOrderById(Long id) {

        // 获取不包含OrderItems的OrdersPo，并交由Order代理
        OrdersPo ordersPo = ordersMapper.selectOrderById(id);
        OrdersBo ordersBo = new OrdersBo(ordersPo);

        List<OrderItemBo> orderItemBoList = null;
        // 查询不为空
        if (ordersPo != null) {
            // 根据OrderId查找OrderItemPo，并交由OrderItem处理
            List<OrderItemPo> orderItemPoList = ordersMapper.selectOrderItemsByOrderId(ordersPo.getId());
            orderItemBoList = new ArrayList<>(orderItemPoList.size());
            for (OrderItemPo orderItemPo : orderItemPoList)
                orderItemBoList.add(new OrderItemBo(orderItemPo));
        }

        ordersBo.setOrderItemList(orderItemBoList);

        return new ReturnObject<OrdersBo>(ordersBo);
    }

    /**
     * 新建订单order
     * @param ordersBo
     * @return
     */
    public ReturnObject<Object> createOrder(OrdersBo ordersBo) {
        int flag = ordersMapper.insertNewOrder(ordersBo.getOrdersPo());
        // FIELD_NOTVALID(503, "字段不合法"),
        if (flag == 0)
            return new ReturnObject<>(ResponseCode.FIELD_NOTVALID,"失败");

        List<OrderItemBo> ordersItemList = ordersBo.getOrdersItemList();
        if (ordersItemList != null)
            for (OrderItemBo orderItemBo : ordersItemList) {
                flag = ordersMapper.insertNewOrderItem(orderItemBo.getOrderItemPo());
                if (flag == 0)
                    return new ReturnObject<>(ResponseCode.FIELD_NOTVALID, "失败");
            }

        return new ReturnObject<>(ResponseCode.OK);
    }
}
