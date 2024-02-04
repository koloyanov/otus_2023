package ru.otus;

import java.util.*;

public class CashService implements ICashService {
    private final Map<CashType, Long> cashBank;

    CashService() {
        cashBank = new LinkedHashMap<>();
        for (CashType type : CashType.values()) {
            cashBank.put(type, 10L);
        }
    }

    @Override
    public void putCash(Map<CashType, Long> cash) {
        for (CashType type : cash.keySet()) {
            cashBank.replace(type, cashBank.get(type) + cash.get(type));
        }
    }

    @Override
    public Map<CashType, Long> getCash(Long sum) {
        Map<CashType, Long> result = new HashMap<>();

        for (CashType cashType : cashBank.keySet()) {
            Long cashTypeCounter = sum / cashType.getCash();

            if (cashTypeCounter > 0) {
                if (cashBank.get(cashType) < cashTypeCounter) {
                    cashTypeCounter = cashBank.get(cashType);
                }
                result.put(cashType, cashTypeCounter);
                sum -= cashType.getCash() * cashTypeCounter;
            }

            if (sum == 0) {
                return result;
            }
        }

        throw  new RuntimeException("Cash not found!");
    }
}
