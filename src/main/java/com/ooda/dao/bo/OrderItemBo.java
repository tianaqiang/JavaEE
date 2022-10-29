package com.ooda.dao.bo;

import com.ooda.controller.vo.VoObject;
import com.ooda.mapper.po.OrderItemPo;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * @Desc
 * @Author 田阿强
 * @create 2022/10/10 20:58
 */
@Data
public class OrderItemBo implements VoObject {

    private OrderItemPo orderItemPo;

    public OrderItemBo() {
        this.orderItemPo = new OrderItemPo();
    }

    public OrderItemBo(OrderItemPo orderItemPo) {
        this.orderItemPo = orderItemPo;
    }

    public OrderItemPo getOrderItemPo() {
        return orderItemPo;
    }

    public Long getId() {
        return orderItemPo.getId();
    }

    public void setId(Long id) {
        orderItemPo.setId(id);
    }

    public Long getOrderId() {
        return orderItemPo.getOrderId();
    }

    public void setOrderId(Long orderId) {
        orderItemPo.setOrderId(orderId);
    }

    public Long getGoodsSkuId() {
        return orderItemPo.getGoodsSkuId();
    }

    public void setGoodsSkuId(Long goodsSkuId) {
        orderItemPo.setGoodsSkuId(goodsSkuId);
    }

    public int getQuantity() {
        return orderItemPo.getQuantity();
    }

    public void setQuantity(int quantity) {
        orderItemPo.setQuantity(quantity);
    }

    public Long getPrice() {
        return orderItemPo.getPrice();
    }

    public void setPrice(Long price) {
        orderItemPo.setPrice(price);
    }

    public Long getDiscount() {
        return orderItemPo.getDiscount();
    }

    public void setDiscount(Long discount) {
        orderItemPo.setDiscount(discount);
    }

    public String getName() {
        return orderItemPo.getName();
    }

    public void setName(String name) {
        orderItemPo.setName(name);
    }

    public Long getCouponActivityId() {
        return orderItemPo.getCouponActivityId();
    }

    public void setCouponActivityId(Long couponActivityId) {
        orderItemPo.setCouponActivityId(couponActivityId);
    }

    public Long getBeSharedId() {
        return orderItemPo.getBeShareId();
    }

    public void setBeShareId(Long beShareId) {
        orderItemPo.setBeShareId(beShareId);
    }

    public LocalDateTime getGmtCreate() {
        return orderItemPo.getGmtCreate();
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        orderItemPo.setGmtCreate(gmtCreate);
    }

    public LocalDateTime getGmtModified() {
        return orderItemPo.getGmtModified();
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        orderItemPo.setGmtModified(gmtModified);
    }

    /**
     * 创建Vo对象
     * 和OrderItemPo一样的属性
     * @return Vo对象
     */
    @Override
    public HashMap<String, Object> createVo() {
        HashMap<String, Object> orderItemInfo = new HashMap<>();
        orderItemInfo.put("skuId", this.getGoodsSkuId());
        orderItemInfo.put("orderId", this.getOrderId());
        orderItemInfo.put("name", this.getName());
        orderItemInfo.put("quantity", this.getQuantity());
        orderItemInfo.put("price", this.getPrice());
        orderItemInfo.put("discount", this.getDiscount());
        orderItemInfo.put("couponActId", this.getCouponActivityId());
        orderItemInfo.put("beSharedId", this.getBeSharedId());

        return orderItemInfo;
    }
}
