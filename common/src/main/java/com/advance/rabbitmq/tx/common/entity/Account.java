package com.advance.rabbitmq.tx.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Account implements Serializable {

  private long id;
  private String name;
  private String nickName;
  private String sex;
  private long age;
  private String phone;
  private String email;
  private double money;
  private String address;
  private LocalDateTime operateTime;
  private LocalDateTime createTime;

}
