package ru.otus;

import java.util.Map;

public class Client implements IClient {
    @Override
    public Long getCashBalance(Long clientId) {
        return null;
    }

    @Override
    public void addCash(Long clientId, Map<CashType, Long> cash) {

    }

    @Override
    public void removeCash(Long clientId, Long sum) {

    }

}