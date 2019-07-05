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
    }
}
