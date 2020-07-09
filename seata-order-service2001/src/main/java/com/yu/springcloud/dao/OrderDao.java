package com.yu.springcloud.dao;

import com.yu.springcloud.domain.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderDao {

    @Insert("insert into t_order(user_id,product_id,count,money,status)values(#{userId}," +
            "#{productId},#{count},#{money},#{status})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int insert(Order order);

    @Update("update t_order set status=#{status} where id=#{id}")
    void updateStatus(@Param("id") Long id,@Param("status") int status);

}
