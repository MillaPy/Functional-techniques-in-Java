package combinator;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phonenum;
    private final LocalDate dob;

    public Customer(String name, String email, String phonenum, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phonenum = phonenum;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phonenum='" + phonenum + '\'' +
                ", dob=" + dob +
                '}';
    }
}
