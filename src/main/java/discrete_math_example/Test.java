package discrete_math_example;

import java.util.Scanner;

public class Test extends inference {

        public static void main(String[] args) {
            int m = 1; // n is for how many variables
            int x, count;
            boolean p = true, T = false, q, r; // T is result of p and q
            int row = (int) Math.pow(2, m); // how many rows in the table

            System.out.println("Discrete math\n");

            System.out.println("Negation operator");
            for (x = 0; x < row; x++) {
                T = p;
                System.out.printf("%s\t%s%n", showValue(p), !(T));
                p = negation.test(p); // negate P
            }

            System.out.println("\n\nLaws for one input:");
            for (x = 0; x < row; x++) {
                //T = identityLaw.test(p, false);
                //T = domination.test(p, false);
                //T = idempotent.apply(p);
                //T = DoubleNegation.apply(p);
                //T = negationLawAnd.apply(p);
                T = negationLawOr.apply(p);
                System.out.printf("%s\t%s%n", showValue(p), T);
                p = negation.test(p);
            }

            System.out.println("\n\nTruth table\nLaws, Logical equivalence, Rules of inference for several inputs");
            System.out.println("Enter the number:\n");
            Scanner scanner = new Scanner(System.in);
            int n  = scanner.nextInt();
            int rows = (int)Math.pow(2, n);
            int columns = n;
            boolean[][] matrix = new boolean[rows][columns];
            int cnt = rows / 2;
            for (int i = 0; i < columns; ++i) {
                boolean val = true;
                for (int j = 0; j < rows; ++j) {
                    matrix[j][i] = val;
                    if ((j + 1) % cnt == 0) {
                        val = !val;
                    }
                }
                cnt /= 2;
            }

            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < columns; ++j) {
                    // T = implication.test(matrix[i][0], matrix[i][1]);
                    T = absorptionOr.apply(matrix[i][0], matrix[i][1]);
                    //T = biConditionalEq.apply(matrix[i][0], matrix[i][1]);
                    //T = modusPonens.test(matrix[i][0], matrix[i][1]);
                    //T = associativeAnd.apply(matrix[i][0], matrix[i][1], matrix[i][2]);
                    System.out.print((matrix[i][j] ? "T" : "F") + " ");

                }
                System.out.println(T);
            }
        }


    private static char showValue(boolean v) {
        // Indicates if the variables are T or F
        if (v == false) {
            return 'F';
        } else {
            return 'T';
        }
    }
}

