package ru.otus;

import java.util.Map;

public interface IClient {
    Long getCashBalance(Long clientId);
    void addCash(Long clientId, Map<CashType, Long> cash);
    void removeCash(Long clientId, Long sum);
}
