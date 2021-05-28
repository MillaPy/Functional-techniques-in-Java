package discrete_math_example;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class operators {

    static BiPredicate<Boolean, Boolean> and = (a, b) -> a && b;

    static BiPredicate<Boolean, Boolean> or = (a, b) -> a || b;

    static BiPredicate<Boolean, Boolean> implication = (a, b) -> a.equals(true) && b.equals(false) ? false : true;

    static Predicate<Boolean> negation = a -> !(a);

    static BiPredicate<Boolean, Boolean> Xor = (a, b) -> a ^ b;

    static BiPredicate<Boolean, Boolean> biConditional = (a, b) -> !(a ^ b);

}