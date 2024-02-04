package ru.otus;

import java.util.Map;


public class ATM implements IATM {
    private final ClientsService clientsService;
    private final CashService cashService;

    public ATM() {
        clientsService = new ClientsService();
        cashService = new CashService();
    }

    @Override
    public void addNewClient(Client client) {
        clientsService.addClient(client);
    }

    @Override
    public void addCash(Long userId, Map<CashType, Long> incomeCash) {
        long sum = 0L;
        for (CashType cashType : incomeCash.keySet()) {
            sum += cashType.getCash() * incomeCash.get(cashType);
        }

        clientsService.addCash(userId, sum);
        cashService.putCash(incomeCash);
    }

    @Override
    public Map<CashType, Long> takeCash(Long clientId, Long sum) {
        clientsService.checkCash(clientId, sum);
        Map<CashType, Long> cash = cashService.getCash(sum);
        clientsService.removeCash(clientId, sum);
        return cash;
    }

    @Override
    public Long allClientCash(Long clientId) {
        return clientsService.getCashBalance(clientId);
    }
}
