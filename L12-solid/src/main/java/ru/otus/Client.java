package ru.otus;

import java.util.Objects;

public class Client {
    private final Long clientID;
    private Long cashSum;

    public Client(Long clientID, Long cashSum) {
        this.clientID = clientID;
        this.cashSum = cashSum;
    }

    public Long getClientID() {
        return clientID;
    }

    public Long getCashSum() {
        return cashSum;
    }

    public void addCash(Long cashSum) {
        this.cashSum += cashSum;
    }

    public void removeCash(Long cashSum) {
        this.cashSum -= cashSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        return Objects.equals(clientID, client.clientID);
    }

    @Override
    public int hashCode() {
        int result = clientID != null ? clientID.hashCode() : 0;
        result = 31 * result + (cashSum != null ? cashSum.hashCode() : 0);
        return result;
    }
}