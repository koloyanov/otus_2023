package homework;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//@SuppressWarnings({"java:S1186", "java:S1135", "java:S1172"})
public class CustomerService {

    // todo: 3. надо реализовать методы этого класса
    // важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    private final Map<Customer, String> data = new LinkedHashMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        Map.Entry<Customer, String> entry = null;
        for (Map.Entry<Customer, String> e : data.entrySet()) {
            if (entry == null || e.getKey().getScores() < entry.getKey().getScores()) {
                entry  = e;
            }
        }
        return entry;
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {
        return null; // это "заглушка, чтобы скомилировать"
    }

    public void add(Customer customer, String data) {
        this.data.put(customer, data);
    }
}
