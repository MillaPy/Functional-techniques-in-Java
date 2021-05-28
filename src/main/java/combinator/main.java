package combinator;

import java.time.LocalDate;

import static combinator.CustomerRegistrationValidator.*;

public class main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
                "alice@gmail.com",
                "+067890987654",
                LocalDate.of(2015, 1, 2));

       // CustomerValidatorService validation = new CustomerValidatorService();
        //validation.isValid(customer);

        ///System.out.println( new CustomerValidatorService().isValid(customer));

        //if valid can store customer in db

        //using combinatotr pattern
        CustomerRegistrationValidator result = isemailvalid()
                .and(isPhonenumvalid())
                .and(isAdultvalid());

        result.apply(customer);

//        System.out.println(result);
//
//        if( result != ValidationResult.SUCCESS){
//            throw new IllegalStateException(result.name());
//        }



    }
}
