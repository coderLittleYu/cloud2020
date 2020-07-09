package com.yu.springcloud.mapper;

import com.yu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PaymentMapper {

    @Select("select * from payment where id=#{id}")
    Payment getPaymentById(@Param("id") Long id);

    @Insert("insert into payment (serial) values(#{serial})")
    int insert(Payment payment);
}
