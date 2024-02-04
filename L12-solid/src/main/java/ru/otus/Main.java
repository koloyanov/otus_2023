package ru.otus;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        Client client1 = new Client(111L, 1700L);
        atm.addNewClient(client1);
        Client client2 = new Client(112L, 53200L);
        atm.addNewClient(client2);
        Client client3 = new Client(113L, 33000L);
        atm.addNewClient(client3);

        System.out.println(atm.allClientCash(client1.getClientID()));
        System.out.println(atm.takeCash(client1.getClientID(), 1000L));
        System.out.println(atm.allClientCash(client1.getClientID()));

        System.out.println(atm.takeCash(client1.getClientID(), 300L));
        System.out.println(atm.allClientCash(client1.getClientID()));
    }
}