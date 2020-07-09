package com.yu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDto {

    @Update("update t_storage set used=used+#{count},residue=residue - #{count}" +
            " where product_id=#{productId}")
    void decrease(@Param("productId")Long productId,@Param("count") int count);
}
