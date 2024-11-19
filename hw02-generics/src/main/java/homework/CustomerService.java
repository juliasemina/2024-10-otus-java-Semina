package homework;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class CustomerService {

    private final NavigableMap<Customer, String> customerSortedByScoresMap =
            new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {

        Entry<Customer, String> smallestEntry = customerSortedByScoresMap.firstEntry();

        return copyCustomerEntry(smallestEntry);
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        Entry<Customer, String> nextEntry = customerSortedByScoresMap.higherEntry(customer);

        return copyCustomerEntry(nextEntry);
    }

    public void add(Customer customer, String data) {

        customerSortedByScoresMap.put(customer, data);
    }

    private Map.Entry<Customer, String> copyCustomerEntry(Map.Entry<Customer, String> copiedEntry) {
        if (Objects.nonNull(copiedEntry)) {

            Customer currentCustomer = copiedEntry.getKey();
            Customer copiedCustomer = new Customer(currentCustomer);

            return Map.entry(copiedCustomer, copiedEntry.getValue());
        }
        return null;
    }
}
