package com.advance.rabbitmq.tx.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Message<T> implements Serializable {

    private Integer code;

    private T data;

    private LocalDateTime dateTime;

}
