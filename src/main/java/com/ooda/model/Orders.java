package com.ooda.model;

import com.ooda.controller.vo.VoObject;
import com.ooda.mapper.po.OrdersPo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Desc
 * @Author 田阿强
 * @create 2022/10/10 21:34
 */
@Data
public class Orders implements VoObject {

    private OrdersPo ordersPo;

    private List<OrderItem> orderItems;

    public Orders() {
        this.ordersPo = new OrdersPo();
    }

    public Orders(OrdersPo ordersPo) {
        this.ordersPo = ordersPo;
    }

    public OrdersPo getOrdersPo() {
        return ordersPo;
    }

    public List<OrderItem> getOrdersItemList() {
        return orderItems;
    }

    public void setOrderItemList(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderssPo(OrdersPo ordersPo) {
        this.ordersPo = ordersPo;
    }

    public Long getId() {
        return ordersPo.getId();
    }

    public void setId(Long id) {
        ordersPo.setId(id);
    }

    public Long getCustomerId() {
        return ordersPo.getCustomerId();
    }

    public void setCustomerId(Long customerId) {
        ordersPo.setCustomerId(customerId);
    }

    public Long getShopId() {
        return ordersPo.getShopId();
    }

    public void setShopId(Long shopId) {
        ordersPo.setShopId(shopId);
    }

    public String getOrderSn() {
        return ordersPo.getOrderSn();
    }

    public void setOrderSn(String orderSn) {
        ordersPo.setOrderSn(orderSn);
    }

    public Long getPid() {
        return ordersPo.getPid();
    }

    public void setPid(Long pid) {
        ordersPo.setPid(pid);
    }

    public String getConsignee() {
        return ordersPo.getConsignee();
    }

    public void setConsignee(String consignee) {
        ordersPo.setConsignee(consignee);
    }

    public Long getRegionId() {
        return ordersPo.getRegionId();
    }

    public void setRegionId(Long regionId) {
        ordersPo.setRegionId(regionId);
    }

    public String getAddress() {
        return ordersPo.getAddress();
    }

    public void setAddress(String address) {
        ordersPo.setAddress(address);
    }

    public String getMobile() {
        return ordersPo.getMobile();
    }

    public void setMobile(String mobile) {
        ordersPo.setMobile(mobile);
    }

    public String getMessage() {
        return ordersPo.getMessage();
    }

    public void setMessage(String message) {
        ordersPo.setMessage(message);
    }

    public Integer getOrdersType() {
        return ordersPo.getOrderType();
    }

    public void setOrderType(int orderType) {
        ordersPo.setOrderType(orderType);
    }

    public Long getFreightPrice() {
        return ordersPo.getFreightPrice();
    }

    public void setFreightPrice(Long freightPrice) {
        ordersPo.setFreightPrice(freightPrice);
    }

    public Long getCouponId() {
        return ordersPo.getCouponId();
    }

    public void setCouponId(Long couponId) {
        ordersPo.setCouponId(couponId);
    }

    public Long getCouponActivityId() {
        return ordersPo.getCouponActivityId();
    }

    public void setCouponActivityId(Long couponActivityId) {
        ordersPo.setCouponActivityId(couponActivityId);
    }

    public Long getDiscountPrice() {
        return ordersPo.getDiscountPrice();
    }

    public void setDiscountPrice(Long discountPrice) {
        ordersPo.setDiscountPrice(discountPrice);
    }

    public Long getOriginPrice() {
        return ordersPo.getOriginPrice();
    }

    public void setOriginPrice(Long originPrice) {
        ordersPo.setOriginPrice(originPrice);
    }

    public Long getPresaleId() {
        return ordersPo.getPresaleId();
    }

    public void setPresaleId(Long presaleId) {
        ordersPo.setPresaleId(presaleId);
    }

    public Long getGrouponDiscount() {
        return ordersPo.getGrouponDiscount();
    }

    public void setGrouponDiscount(Long grouponDiscount) {
        ordersPo.setGrouponDiscount(grouponDiscount);
    }

    public Integer getRebateNum() {
        return ordersPo.getRebateNum();
    }

    public void setRebateNum(int rebateNum) {
        ordersPo.setRebateNum(rebateNum);
    }

    public LocalDateTime getConfirmTime() {
        return ordersPo.getConfirmTime();
    }

    public void setConfirmTime(LocalDateTime confirmTime) {
        ordersPo.setConfirmTime(confirmTime);
    }

    public String getShipmentSn() {
        return ordersPo.getShipmentSn();
    }

    public void setShipmentSn(String shipmentSn) {
        ordersPo.setShipmentSn(shipmentSn);
    }

    public Integer getState() {
        return ordersPo.getState();
    }

    public void setState(int state) {
        ordersPo.setState(state);
    }

    public Integer getSubstate() {
        return ordersPo.getSubstate();
    }

    public void setSubstate(int substate) {
        ordersPo.setSubstate(substate);
    }

    public Integer getBeDeleted() {
        return ordersPo.getBeDeleted();
    }

    public void setBeDeleted(int beDeleted) {
        ordersPo.setBeDeleted(beDeleted);
    }

    public LocalDateTime getGmtCreate() {
        return ordersPo.getGmtCreate();
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        ordersPo.setGmtCreate(gmtCreate);
    }

    public LocalDateTime getGmtModified() {
        return ordersPo.getGmtModified();
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        ordersPo.setGmtModified(gmtModified);
    }

    public Long getGrouponId() {
        return ordersPo.getGrouponId();
    }

    public void setGrouponId(Long grouponId) {
        ordersPo.setGrouponId(grouponId);
    }

    /**
     * 创建Vo对象
     *
     * @return Vo对象
     */
    @Override
    public Object createVo() {
        ArrayList<HashMap<String, Object>> orderItemInfos = new ArrayList();
        for (OrderItem orderItem : this.orderItems)
            orderItemInfos.add(orderItem.createVo());

        HashMap<String, Object> retOrdersInfo = new HashMap<>();
        retOrdersInfo.put("id", ordersPo.getId());
        retOrdersInfo.put("orderSn", ordersPo.getOrderSn());
        retOrdersInfo.put("pid", ordersPo.getPid());
        retOrdersInfo.put("orderType", ordersPo.getOrderType());
        retOrdersInfo.put("state", ordersPo.getState());
        retOrdersInfo.put("subState", ordersPo.getSubstate());
        retOrdersInfo.put("gmtCreate", ordersPo.getGmtCreate());
        retOrdersInfo.put("gmtModified", ordersPo.getGmtModified());
        retOrdersInfo.put("confirmTime", ordersPo.getConfirmTime());
        retOrdersInfo.put("originPrice", ordersPo.getOriginPrice());
        retOrdersInfo.put("discountPrice", ordersPo.getDiscountPrice());
        retOrdersInfo.put("freightPrice", ordersPo.getFreightPrice());
        retOrdersInfo.put("rebateNum", ordersPo.getRebateNum());
        retOrdersInfo.put("message", ordersPo.getMessage());
        retOrdersInfo.put("regionId", ordersPo.getRegionId());
        retOrdersInfo.put("address", ordersPo.getAddress());
        retOrdersInfo.put("mobile", ordersPo.getMobile());
        retOrdersInfo.put("consignee", ordersPo.getConsignee());
        retOrdersInfo.put("couponId", ordersPo.getCouponId());
        retOrdersInfo.put("grouponId", ordersPo.getGrouponId());
        retOrdersInfo.put("presaleId", ordersPo.getPresaleId());
        retOrdersInfo.put("shipmentSn", ordersPo.getShipmentSn());
        retOrdersInfo.put("orderItems", orderItemInfos);

        return retOrdersInfo;
    }
}
