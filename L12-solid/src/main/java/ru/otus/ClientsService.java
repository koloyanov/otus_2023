package ru.otus;

import java.util.*;

public class ClientsService implements IClientsService{
    private final ArrayList <Client> clients;

    ClientsService() {
        clients = new ArrayList<>();
    }

    @Override
    public void addClient(Client client) {
        if (!clients.contains(client)) {
            clients.add(client);
        } else {
            throw new RuntimeException("This client is persist!");
        }

    }

    @Override
    public Long getCashBalance(Long clientId) {
        return getClientByID(clientId).getCashSum();
    }

    @Override
    public void addCash(Long clientId, Long cash) {
        getClientByID(clientId).addCash(cash);
    }

    @Override
    public void removeCash(Long clientId, Long sum) {
        getClientByID(clientId).removeCash(sum);
    }

    @Override
    public void checkCash(Long clientId, Long sum) {
        if (getClientByID(clientId).getCashSum() < sum) throw new RuntimeException("Client doesn't have so much money!");
    }

    private Client getClientByID(Long clientId) {
        Optional<Client> optClient = clients.stream().filter(cl -> Objects.equals(cl.getClientID(), clientId)).findFirst();
        if (optClient.isPresent()) {
            return optClient.get();
        } else {
            throw new RuntimeException("Client not found");
        }
    }
}
