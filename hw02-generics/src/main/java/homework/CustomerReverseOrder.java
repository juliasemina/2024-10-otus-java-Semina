package homework;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomerReverseOrder {

    private final Deque<Customer> arrayDeque = new ArrayDeque<>();

    public void add(Customer customer) {
        arrayDeque.addFirst(customer);
    }

    public Customer take() {
        return arrayDeque.poll();
    }
}
