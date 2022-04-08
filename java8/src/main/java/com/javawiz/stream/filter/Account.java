package com.javawiz.stream.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Account {
    private long id;
    private String message;
    private String operation;
    private AccountStatus status;
}