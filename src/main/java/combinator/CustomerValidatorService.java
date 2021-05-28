package combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {


    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isphonenumberlValid(String phonenum){
        return phonenum.startsWith("+0");
    }

    private boolean isAdult(LocalDate dob){
        return Period.between(dob, LocalDate.now()).getYears() >16;
    }

    public boolean isValid(Customer c){
        return isEmailValid(c.getEmail())
                && isphonenumberlValid(c.getPhonenum())
                && isAdult(c.getDob());
    }



}
