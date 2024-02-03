package ru.otus;

import lombok.Getter;

public enum CashType {
    HUNDRED(100L),
    TWO_HUNDRED(200L),
    FIVE_HUNDRED(500L),
    THOUSAND(1000L),
    TWO_THOUSAND(2000L),
    FIVE_THOUSAND(5000L);

    @Getter
    private Long cash;

    CashType(Long cash) {
        this.cash = cash;
    }
}
