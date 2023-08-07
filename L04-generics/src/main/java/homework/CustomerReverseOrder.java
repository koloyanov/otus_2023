package homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {

    // todo: 2. надо реализовать методы этого класса
    // надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    private final ArrayDeque<Customer> data = new ArrayDeque<>();

    public void add(Customer customer) {data.add(customer);}

    public Customer take() {
        return data.pollLast();
    }
}
