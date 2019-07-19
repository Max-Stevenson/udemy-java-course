package LambdaChallenge;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaChallengeApp {
    public static String everySecondChar(String source) {
        StringBuilder returnValue = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                returnValue.append(source.charAt(i));
            }
        }
        return returnValue.toString();
    }

    public static String everySeconChar(Function<String, String> function, String arg) {
        return function.apply(arg);
    }

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };

        runnable.run();

        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnValue = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnValue.append(s.charAt(i));
                }
            }
            return returnValue.toString();
        };

        String r = lambdaFunction.apply("1234567890");
        System.out.println(r);
        String result = everySeconChar(lambdaFunction, "1234567890");
        System.out.println(result);

        Supplier<String>  iLoveJava = () -> "I love Java";

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted()
                .forEach(System.out::println);

        System.out.println(topNames2015.stream()
                .filter(s -> s.matches("(?i)^a.*"))
                .count());

        topNames2015.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .peek(System.out::println)
                .sorted()
                .count();
    }
}
