package com.aton.backend.entity;

import lombok.Getter;

@Getter
public enum Status {

    DEAL_CLOSED("Сделка закрыта"),
    REJECT("Отказ"),
    IN_WORK("В работе"),
    NOT_IN_WORK("Не в работе");

    private final String status;

    Status(String status) {
        this.status = status;
    }
}
