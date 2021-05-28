package discrete_math_example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class logical_equivalence extends laws {

    static BiFunction<Boolean, Boolean,Boolean> biConditionalEq = (p, q) -> {
        Boolean biCondEq = biConditional.test(p, q);
        Boolean e1 = and.test(implication.test(p, q), implication.test(q, p));
        Boolean e2 = biConditional.test(negation.test(p), negation.test(p));
        Boolean e3 = or.test(and.test(p, q), and.test(negation.test(p), negation.test(p)));
        Boolean e4 = biConditional.test(p, negation.test(q));
        List<Boolean> equations = List.of(e1, e2, e3);
        if(e4 == !biCondEq)
            return e4;
        else if ( equations.get(0) == biCondEq)
            return biCondEq;
        else
            return false;
    };

    static BiConsumer<Boolean, Boolean> implicationEq = (p, q) -> {
        Boolean implicationEq = implication.test(p, q);
        Map<Boolean,Boolean> imEquivalence = new HashMap<>();
        imEquivalence.put(implicationEq, or.test(negation.test(p), q));
        imEquivalence.put(implicationEq, implication.test(negation.test(q), negation.test(p)));
        imEquivalence.put(!(implicationEq), and.test(p, negation.test(q)));
    };

    static BiConsumer<Boolean, Boolean> andOrEq = (p, q) -> {
        Map<Boolean,Boolean> andOrEquivalence = new HashMap<>();
        andOrEquivalence.put(and.test(p, q), negation.test(implication.test(p, negation.test(q))));
        andOrEquivalence.put(or.test(p, q), implication.test(negation.test(p), q));
    };

    static TriConsumer<Boolean, Boolean, Boolean> implicationAndOrEq = (p, q, r) -> {
        Map<Boolean,Boolean> impAndOrEquivalence = new HashMap<>();
        impAndOrEquivalence.put(implication.test(p, and.test(q, r)), and.test(implication.test(p, q), implication.test(p, r)));
        impAndOrEquivalence.put(implication.test(or.test(p,q), r), and.test(implication.test(p, r), implication.test(q, r)));
        impAndOrEquivalence.put(implication.test(p, or.test(q, r)), or.test(implication.test(p, q), implication.test(p, r)));
        impAndOrEquivalence.put(implication.test(and.test(p, q), r), or.test(implication.test(p, r), implication.test(q, r)));
    };

    public interface TriConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }
}













// if (biConditional.test(p, q) == biCondEq) ->
// biCondEq.equals(and.test(implication.test(p, q), implication.test(q, p)));