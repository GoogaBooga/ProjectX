package com.intellias.px.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {

    private int id;
    private int userId;
    private Date date;
    private String comment;
    private Status status;


}
