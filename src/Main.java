
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customers = new Customer();
        Customer customers1 = new Customer("edfff", "dfvd", LocalDate.of(2000, 11, 11), "efddv");
        Customer customers2 = new Customer("edfff", "dfvd", LocalDate.of(2000, 11, 11), "efddv");
        Customer[] customers3 = {customers1, customers2};

        customers.addCustomer(customers1);
        customers.addCustomer(customers2);

        System.out.println("customers.getByidCustomer(2) = " + customers.getByidCustomer(2));

        customers.updateCustomer(1);

        customers.deleteCustomer(2);


    }
}

