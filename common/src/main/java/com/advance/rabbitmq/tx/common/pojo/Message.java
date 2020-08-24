package com.advance.rabbitmq.tx.common.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message<T> implements Serializable {

    private Integer code;

    private T data;

}
