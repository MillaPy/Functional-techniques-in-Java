package discrete_math_example;

import java.util.Objects;
import java.util.function.*;


public class laws extends operators {

    static BiPredicate<Boolean, Boolean> identityLaw = (p, q) -> q.equals(true) ? and.test(p, q) : or.test(p, q);

    static BiPredicate<Boolean, Boolean> domination = (p, q) -> q.equals(true) ? or.test(p, q) : and.test(p, q);

    static Function<Boolean, Boolean> idempotent = p -> p.equals(p) ? (and.test(p, p) || or.test(p, p)) : null;

    static Function<Boolean, Boolean> DoubleNegation = p -> !(!(p));

    static Function<Boolean, Boolean> negationLawAnd = p -> and.test(p, !(p));
    static Function<Boolean, Boolean> negationLawOr = p -> or.test(p, !(p));

    
    static BiFunction<Boolean, Boolean,  Boolean> commutativeAnd = (p, q) ->
    {
        Boolean A = and.test(p, q);
        if (A == and.test(q, p))
            return A;
        else
            return false;
    };

    static BiFunction<Boolean, Boolean,  Boolean> commutativeOr = (p, q) ->
    {
        Boolean T = or.test(p, q);
        if (T == or.test(q, p)) {
            return T;
        }
        else
            return false;
    };

    static BiFunction<Boolean, Boolean,  Boolean> absorptionAnd = (p, q) -> and.test(p, or.test(p, q));

    static BiFunction<Boolean, Boolean,  Boolean> absorptionOr = (p, q) -> or.test(p, and.test(p, q));

    static BiFunction<Boolean, Boolean,  Boolean> DeMorganAnd = (p, q) -> {
        Boolean T = negation.test(and.test(p, q));
        if (T = or.test(negation.test(p), negation.test(q)))
            return T;
        else
            return false;
    };

    static BiFunction<Boolean, Boolean,  Boolean> DeMorganOr = (p, q) ->{
        Boolean T = negation.test(or.test(p, q));
        if (T = and.test(negation.test(p), negation.test(q)))
            return T;
        else
            return false;
    };

    static TriFunction<Boolean, Boolean, Boolean,  Boolean> associativeAnd = (p, q, r) ->{
        Boolean T = and.test(and.test(p, q), r);
        if (T == and.test(p, and.test(q, r)))
            return T;
        else
            return false;
    };

    static TriFunction<Boolean, Boolean, Boolean,  Boolean> associativeOr = (p, q, r) -> {
        Boolean T =  or.test(or.test(p, q), r);
        if (T == or.test(p, or.test(q, r)))
            return T;
        else
            return false;
    };

    static TriFunction<Boolean, Boolean, Boolean, Boolean> distributiveOr = (p, q, r) ->
    {
        Boolean T = or.test(p, and.test(q, r));
        if (T == and.test(or.test(p, q), or.test(p, r)))
            return T;
        else
            return false;
    };

    static TriFunction<Boolean, Boolean, Boolean, Boolean> distributiveAnd = (p, q, r) ->
    {
        Boolean T = and.test(p, or.test(q, r));
        if (T == or.test(and.test(p, q), and.test(p, r)))
            return T;
        else
            return false;
    };


    interface TriFunction<A,B,C,R> {

        R apply(A a, B b, C c);

        default <V> TriFunction<A, B, C, V> andThen(
                Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (A a, B b, C c) -> after.apply(apply(a, b, c));
        }
    }


    }

