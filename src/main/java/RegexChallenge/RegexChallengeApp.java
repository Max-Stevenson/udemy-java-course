package RegexChallenge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexChallengeApp {
    public static void main(String[] args) {
        String challengeStringOne = "I want a bike.";
        String challengeStringTwo = "I want a ball.";
        String challlengeStringThree = "Replace all blanks with underscores";
        String challengeStringFour = "aaabccccccccdddefffg";
        String challengeStringFive = "abcd.135";
        String challengeStringSix = "abcd.135uvqz.7tzik.999";
        String challengeStringSeven = "abcd.135\tuvqz.7\ttzik.999\n";
        String challengeStringEight = "{4,5}, {3,5}, {8,2}, {1,6}, {7,7}, {8,0}";
        String challengeStringNine = "11111";
        String challengeStringTen = "11111-1111";



        Pattern patternSolution = Pattern.compile("I want a bike.");
        Matcher matcher = patternSolution.matcher(challengeStringOne);
        System.out.println(matcher.find());
        System.out.println(challengeStringOne.matches(patternSolution.toString()));


        patternSolution = Pattern.compile("I want a (bike|ball).");
        matcher = patternSolution.matcher(challengeStringOne);
        System.out.println(matcher.find());
        matcher = patternSolution.matcher(challengeStringTwo);
        System.out.println(matcher.find());

        patternSolution = Pattern.compile("\\s");
        matcher = patternSolution.matcher(challlengeStringThree);
        System.out.println(matcher.replaceAll("_"));

        patternSolution = Pattern.compile("[a-g]+");
        matcher = patternSolution.matcher(challengeStringFour);
        System.out.println(matcher.find());
        System.out.println(challengeStringFour.matches(patternSolution.toString()));

        patternSolution = Pattern.compile("^a{3}bc{8}d{3}ef{3}g$");
        matcher = patternSolution.matcher(challengeStringFour);
        System.out.println(matcher.find());

        patternSolution = Pattern.compile("^[a-zA-Z]+\\.\\d+$");
        matcher = patternSolution.matcher(challengeStringFive);
        System.out.println(matcher.find());

        patternSolution = Pattern.compile("[a-zA-z]+\\.(\\d+)");
        matcher = patternSolution.matcher(challengeStringSix);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        patternSolution = Pattern.compile("[a-zA-z]+\\.(\\d+)\\s");
        matcher = patternSolution.matcher(challengeStringSeven);
        while (matcher.find()) {
            System.out.println(matcher.start(1) + ", " +  (matcher.end(1)-1));
        }

        patternSolution = Pattern.compile("\\{(\\d+,\\d+)\\}");
        matcher = patternSolution.matcher(challengeStringEight);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }

        patternSolution = Pattern.compile("^\\d{5}$");
        matcher = patternSolution.matcher(challengeStringNine);
        System.out.println(matcher.find());

        patternSolution = Pattern.compile("^\\d{5}-\\d{4}$");
        matcher = patternSolution.matcher(challengeStringTen);
        System.out.println(matcher.find());

        patternSolution = Pattern.compile("^(\\d{5})(-\\d{4})?");
        matcher = patternSolution.matcher(challengeStringTen);
        System.out.println(matcher.find());
        matcher = patternSolution.matcher(challengeStringNine);
        System.out.println(matcher.find());


    }

}
