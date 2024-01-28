package ru.otus;

import java.util.LinkedHashMap;
import java.util.Map;


public class ATM implements IATM {
    private final Map<CashType, Long> cash;

    public ATM() {
        cash = new LinkedHashMap<>();
    }

    @Override
    public void giveCash(Map<CashType, Long> incomeCash) {
        for (CashType type : incomeCash.keySet()) {
            cash.put(type, incomeCash.get(type));
        }
    }

    @Override
    public Map<CashType, Long> takeCash(Long sum) {
        return null;
    }

    @Override
    public Long allCash() {
        return null;
    }
}
