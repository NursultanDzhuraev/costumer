

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    private int id;
    private String firstName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    public static int generateId = 0;

    public Customer() {

    }

    public Customer(String firstName, String email, LocalDate dateOfBirth, String phoneNumber) {
        this.id = ++generateId;
        this.firstName = firstName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    private Customer[] customers = new Customer[0];

    public void addCustomer(Customer newCustomer) {
        customers = Arrays.copyOf(customers, customers.length + 1);
        customers[customers.length - 1] = newCustomer;
        System.out.println("newCustomer = " + newCustomer);
    }

    public Customer[] getAllCustomers() {

        return customers;
    }

    public Customer getByidCustomer(long id) {
        for (Customer newCustomer : customers) {
            if (newCustomer.getId() == id) {
                return newCustomer;
            }
        }
        return null;
    }

    public void updateCustomer(long id) {
        Customer customer = getByidCustomer(id);
        if (customer != null) {
            customerInfo(customer);
            System.out.println("customer update = " + customer);
        } else {
            System.out.println("invalid id !!!");
        }


    }

    public void deleteCustomer(long id) {
        int index = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customers[i].getId() == id) {
                index = i;
                break;
            }

        }
        if (index != -1) {
            Customer[] newCustovers = new Customer[customers.length - 1];
            for (int i = 0, j = 0; i < customers.length; i++) {
                if (i != index) {
                    newCustovers[j++] = customers[i];
                }
            }
            customers = newCustovers;
            System.out.println("delete");
        } else {
            System.out.println("invalid id");
        }

    }

    public static Customer customerInfo(Customer customer) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("write the customer first name: ");
        customer.setFirstName(scanner.nextLine());

        System.out.println("write the  customer email ");
        customer.setEmail(scanner.nextLine());

        System.out.println("write the  customer date of birth(YYYY-MM-DD)");
        customer.setDateOfBirth(LocalDate.parse(scanner.nextLine()));


        System.out.println("write the  customer phone number");
        customer.setPhoneNumber(scanner.nextLine());

        return customer;
    }
}


