package homework;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import homework.Customer;

//@SuppressWarnings({"java:S1186", "java:S1135", "java:S1172"})
public class CustomerService {

    // todo: 3. надо реализовать методы этого класса
    // важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> data = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return data.firstEntry() == null ? null : new CustomerEntry(data.firstEntry().getKey(), data.firstEntry().getValue());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        Map.Entry<Customer, String> entry = data.higherEntry(customer);
        return entry == null ? null : new CustomerEntry(entry.getKey(), entry.getValue());
    }

    public void add(Customer customer, String data) {
        this.data.put(customer, data);
    }

    final class CustomerEntry implements Map.Entry<Customer, String> {

        private final Customer customer;
        private String data;

        public CustomerEntry(Customer customer, String data) {
            this.customer = new Customer(customer);
            this.data = data;
        }

        @Override
        public Customer getKey() {
            return customer;
        }

        @Override
        public String getValue() {
            return data;
        }

        @Override
        public String setValue(String value) {
            String old = this.data;
            this.data = value;
            return old;
        }
    }
}
