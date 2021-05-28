package properitiesOfFuncProgramming;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        Integer number = null;
        int counter = 0;

        BiFunction<String, Integer, String> UpperCaseName = (name, age) ->
        {
            if(name.isBlank()) throw new IllegalArgumentException("");
            System.out.println(age);
            return name.toUpperCase();
    };
       String result = UpperCaseName.apply("Alex", 23);
        System.out.println(result);
    }

    class Service {
        Consumer<String> blah = s -> {};
    }
}

/*
Pure functional programming rules:
-- no state -> //lambdas package
           -- no depending on other variables or states
-- pure functions ->
           -- self-contained functions
           -- depend only what inside the body of the function
-- no side effects ->
           -- no outside effects from the body
-- high order functions -> //combinator package
           -- return another function as result
           -- functions can be taken as parameters in other function
*/

