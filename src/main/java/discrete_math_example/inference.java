package discrete_math_example;

import java.util.function.*;

public class inference extends logical_equivalence {
    static BiConsumer<Boolean, Boolean> addition = (p, q) ->{
        if(implication.test(p, or.test(p, q)))
            System.out.println(or.test(p, q));
    };

    static BiConsumer<Boolean, Boolean> simplification = (p, q) ->{
        if(implication.test(and.test(p,q), p))
            System.out.println(p);
    };

    static BiConsumer<Boolean, Boolean> conjunction = (p, q) ->{
        if(implication.test(and.test(p, q), and.test(p, q)))
            System.out.println(and.test(p, q));
    };

    static TriConsumer<Boolean, Boolean, Boolean> resolution = (p, q, r) ->{
        if (implication.test(and.test(or.test(p,q),
                or.test(negation.test(p), r)), or.test(q, r)))
            System.out.println(or.test(q, r));
    };

    static BiPredicate<Boolean, Boolean> modusPonens = (p, q) ->{
        Boolean tautology = true;
        if(implication.test(and.test(p, implication.test(p, q)), q) == tautology)
            System.out.println("q");
        return implication.test(and.test(p, implication.test(p, q)), q);
    };

    static BiPredicate<Boolean, Boolean> modusTonllens = (p, q) ->{
        if(implication.test(and.test(negation.test(q),
                implication.test(p, q)), negation.test(p)))
            System.out.println("~p: "+!(p));
        return implication.test(and.test(negation.test(q),
                implication.test(p, q)), negation.test(p));
    };

    static TriConsumer<Boolean, Boolean, Boolean> hypotheticalSyllogism = (p, q, r) ->{
        if(implication.test(and.test(implication.test(p, q),
                implication.test(q, r)), implication.test(p, r)))
            System.out.println(implication.test(p, r));
    };

    static TriConsumer<Boolean, Boolean, Boolean> disjunctiveSyllogism = (p, q, r) ->{
        if(implication.test(and.test(or.test(p,q),
                negation.test(p)), q))
            System.out.println(q);
    };
}
