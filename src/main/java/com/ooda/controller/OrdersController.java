package com.ooda.controller;


import com.ooda.controller.vo.OrdersVo;
import com.ooda.controller.vo.VoObject;
import com.ooda.service.OrdersService;
import com.ooda.util.ResponseCode;
import com.ooda.util.ResponseUtil;
import com.ooda.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author TianAqiang
 * @since 2022-10-10
 */
@RestController
@RequestMapping(value = "/orders", produces = "application/json;charset=UTF-8")
public class OrdersController {

    private OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /**
     * 根据id查找订单
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Object findOrderById(@PathVariable("id") Long id) {
        ReturnObject<VoObject> returnObject = ordersService.findOrderById(id);
        ResponseCode responseCode = returnObject.getCode();
        switch (responseCode) {
            case OK:
                return ResponseUtil.ok(returnObject.getData().createVo());
            case RESOURCE_ID_NOTEXIST:
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
            default:
                return ResponseUtil.fail(returnObject.getCode());
        }
    }

    @PostMapping
    public Object insertOrder(@RequestBody OrdersVo ordersVo) {
        ReturnObject<VoObject> returnObject = ordersService.insertOrder(ordersVo);
        ResponseCode responseCode = returnObject.getCode();
        switch (responseCode) {
            case OK:
                if (returnObject.getData() != null) {
                    return ResponseUtil.ok(returnObject.getData());
                } else {
                    return ResponseUtil.ok();
                }
            default:
                return ResponseUtil.fail(returnObject.getCode(), returnObject.getErrmsg());
        }
    }
}

