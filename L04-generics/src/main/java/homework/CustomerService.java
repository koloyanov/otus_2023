package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

//@SuppressWarnings({"java:S1186", "java:S1135", "java:S1172"})
public class CustomerService {

    // todo: 3. надо реализовать методы этого класса
    // важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final TreeMap<Customer, String> data = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {
        return data.firstEntry();
    }

    public Map.Entry<Customer, String> getNext(final Customer customer) {
        return data.higherEntry(customer);
    }

    public void add(final Customer customer, final String data) {
        this.data.put(customer, data);
    }
}
