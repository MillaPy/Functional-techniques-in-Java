package functionalInterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
       // System.out.println(isphonenumvalid("07000000000"));
       // System.out.println(isphonenumvalid("070000vbn0"));
        //System.out.println(isphonenumvalid("09009000000"));

        System.out.println(isphonenumvalidPredicate.test("07000030000"));
        System.out.println(isphonenumvalidPredicate.test("070000vbn0"));
        System.out.println(isphonenumvalidPredicate.test("07009000000"));

        System.out.println(
        isphonenumvalidPredicate.and(containsNumber3).test("07000030000")
        );

        System.out.println(
                isphonenumvalidPredicate.or(containsNumber3).test("07009000000")
        );
    }

    // imperative approach
    static boolean isphonenumvalid (String phonenumber){
        return phonenumber.startsWith("07") && phonenumber.length() == 11;
    }

    //declarative
    static Predicate<String> isphonenumvalidPredicate = phonenum ->
        phonenum.startsWith("07") && phonenum.length() == 11;

    static Predicate<String> containsNumber3 = phonenum ->
            phonenum.contains("3");


}
