package ru.otus;

import lombok.Getter;

public enum CashType {
    FIVE_THOUSAND(5000L),
    TWO_THOUSAND(2000L),
    THOUSAND(1000L),
    FIVE_HUNDRED(500L),
    TWO_HUNDRED(200L),
    HUNDRED(100L);

    private Long cash;

    public Long getCash() {
        return cash;
    }

    CashType(Long cash) {
        this.cash = cash;
    }
}
