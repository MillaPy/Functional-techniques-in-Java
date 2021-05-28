package functionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // java function
        greetCustomer(new customer("Marti", "45678"));
        customer maria = new customer("Marti", "45678");
        greetCustomer(maria);

        //consumer functional interface
        greetCustomerConsumer.accept(maria);
        greetCustomerConsumerv2.accept(maria, false);
    }

    static BiConsumer<customer, Boolean> greetCustomerConsumerv2 =
            (customer, showphonenum) ->
            System.out.println("Hello "+customer.customerName+
                    ", thanks for registering phone numbner "
                    + (showphonenum ? customer.customerPhoneNumber : "**************"));

    static Consumer<customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+customer.customerName+
                    ", thanks for registering phone numbner "
                    + customer.customerPhoneNumber);

    static void greetCustomer(customer customer)
    {
        System.out.println("Hello "+customer.customerName+
                ", thanks for registering phone numbner "
                + customer.customerPhoneNumber);
    }

    static class customer{
        private final String customerName;
        private final String customerPhoneNumber;

        customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }}

