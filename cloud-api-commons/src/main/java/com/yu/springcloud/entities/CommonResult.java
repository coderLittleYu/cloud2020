package com.yu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable
{
    private Integer code;
    private String  message;
    private T       data;

//测试githup11234
    public CommonResult(Integer code, String message)
    {
        this(code,message,null);
    }

}
