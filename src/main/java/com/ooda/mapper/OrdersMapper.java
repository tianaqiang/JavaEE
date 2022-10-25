package com.ooda.mapper;

import com.ooda.mapper.po.OrderItemPo;
import com.ooda.mapper.po.OrdersPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author TianAqiang
 * @since 2022-10-10
 */
@Mapper
public interface OrdersMapper {
    @Select("select * from orders where id = #{id}")
    OrdersPo selectOrderById(Long id);

    @Select("select * from order_item where id = #{id}")
    List<OrderItemPo> selectOrderItemsByOrderId(Long orderId);

    @Insert("insert into orders values (#{id},#{customerId}, #{shopId}, #{orderSn}, #{pid}, #{consignee}, #{regionId},\n" +
            "        #{address}, #{mobile}, #{message}, #{orderType}, #{freightPrice}, #{couponId},\n" +
            "        #{couponActivityId}, #{discountPrice}, #{originPrice}, #{presaleId},\n" +
            "        #{grouponDiscount}, #{rebateNum}, #{confirmTime}, #{shipmentSn}, #{state},\n" +
            "        #{substate}, #{beDeleted}, #{gmtCreate}, #{gmtModified}, #{grouponId})")
    Integer insertNewOrder(OrdersPo order);

    @Insert("insert into order_item values (#{id},\n" +
            "        #{orderId},\n" +
            "        #{goodsSkuId},\n" +
            "        #{quantity},\n" +
            "        #{price},\n" +
            "        #{discount},\n" +
            "        #{name},\n" +
            "        #{couponActivityId},\n" +
            "        #{beShareId}," +
            "        #{gmtCreate}," +
            "        #{gmtModified})")
    Integer insertNewOrderItem(OrderItemPo orderItemPo);
}
