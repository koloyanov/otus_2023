package ru.otus;

import java.util.Map;

public interface IATM {
    void addCash(Long userId, Map<CashType, Long> incomeCash);
    Map<CashType, Long> takeCash(Long clientId, Long sum);
    Long allClientCash(Long clientId);
    void addNewClient(Client client);
}
