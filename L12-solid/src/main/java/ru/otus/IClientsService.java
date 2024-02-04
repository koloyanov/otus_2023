package ru.otus;

public interface IClientsService {
    Long getCashBalance(Long clientId);
    void addCash(Long clientId, Long cash);
    void removeCash(Long clientId, Long sum);
    void addClient(Client client);
    void checkCash(Long clientId, Long sum);
}
