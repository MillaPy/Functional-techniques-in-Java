package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class main {
    public static void main(String[] args) {
        Optional.ofNullable("asdfg")
                .ifPresentOrElse(
                        email->System.out.println("Sending to "+ email),
                        ()->System.out.println("cannot send the email"));

    }
}

