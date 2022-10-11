package com.ooda.service;

import com.ooda.dao.OrdersDao;
import com.ooda.entity.Orders;
import com.ooda.entity.OrdersVo;
import com.ooda.entity.VoObject;
import com.ooda.util.ResponseCode;
import com.ooda.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author TianAqiang
 * @since 2022-10-10
 */
@Service
public class OrdersService{
    private OrdersDao ordersDao;

    @Autowired
    public OrdersService(OrdersDao ordersDao) {
        this.ordersDao = ordersDao;
    }

    /**
     * 根据id查询订单orders
     * @param id
     * @return
     */
    public ReturnObject<VoObject> findOrderById(Long id) {
        ReturnObject<Orders> returnOrder = ordersDao.findOrderById(id);

        ReturnObject<VoObject> returnVoObject = null;
        if (returnOrder.getCode().equals(ResponseCode.OK)) {
            if (returnOrder.getData().getOrdersPo() != null)
                returnVoObject = new ReturnObject<>(returnOrder.getData()); // code默认是ok
            else
                // RESOURCE_ID_NOTEXIST(504, "操作的资源id不存在"),
                returnVoObject = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST, "资源不存在");
        } else
            returnVoObject = new ReturnObject<>(returnOrder.getCode(), returnOrder.getErrmsg());

        return returnVoObject;
    }


    public ReturnObject<VoObject> insertOrder(OrdersVo ordersVo) {
        ReturnObject<Object> returnOrder = ordersDao.createOrder(ordersVo.createOrders());
        ReturnObject<VoObject> returnVoObject = null;

        if (returnOrder.getCode().equals(ResponseCode.OK))
            returnVoObject = new ReturnObject<>(ResponseCode.OK);
        else
            returnVoObject = new ReturnObject<>(returnOrder.getCode(), returnOrder.getErrmsg());

        return returnVoObject;

    }

}
