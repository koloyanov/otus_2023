package ru.otus;

import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;


public class ATM implements IATM {
    @Setter
    private Client client;

    @Setter
    private CashService cashService;

    @Override
    public void addCash(Long userId, Map<CashType, Long> incomeCash) {
        client.addCash(userId, incomeCash);
        cashService.putCash(incomeCash);
    }

    @Override
    public Map<CashType, Long> takeCash(Long clientId, Long sum) {

        Map<CashType, Long> result = cashService.getCash()
    }

    @Override
    public Long allCash(Long clientId) {
        return null;
    }
}
