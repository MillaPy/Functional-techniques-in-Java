package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);
        int incr2 = incrementByOnefunction.apply(1);
        System.out.println(incr2);

        int multiply = multipleBy10Function.apply(incr2);
        System.out.println(multiply);

        //function
       Function<Integer, Integer> incr3 =
               incrementByOnefunction.andThen(multipleBy10Function);
        System.out.println(incr3.apply(4));
        //System.out.println(incr3);

        //bifunction
       // BiFunction<Integer, Integer, Integer> res =
        System.out.println(
    incrementByOneAndMultiply(4,100)
        );

        System.out.println(
                incrementByOneAndMultiplyBifunc.apply( 4,100)
        );

    }

    static Function<Integer, Integer> incrementByOnefunction
            = number -> number+1;

    static Function<Integer, Integer> multipleBy10Function =
            number -> number*10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBifunc =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1)* numberToMultiplyBy;


    static int incrementByOne (int number){
        return number + 1;
    }

    static int incrementByOneAndMultiply (int number, int numtomultiplyby){
        return (number + 1)*numtomultiplyby;
    }

   // Function<Integer, Integer> incrementByOnefunction = number -> numbert++;
}
