package properitiesOfFuncProgramming;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("John",
                null,
                values -> {
                    System.out.println("The lastname is not provided for " + values);
        });

        hello2("John",
                null,
                () -> System.out.println("The lastname is not provided")
        );
    }

    static void hello(String firtsname, String lastname, Consumer<String> callback){
        System.out.println(firtsname);
        if (lastname != null) {
            System.out.println(lastname);
        } else{
          callback.accept(firtsname);
        }
    }

    static void hello2(String firtsname, String lastname, Runnable callback){
        System.out.println(firtsname);
        if (lastname != null) {
            System.out.println(lastname);
        } else{
            callback.run();
        }
    }
}
