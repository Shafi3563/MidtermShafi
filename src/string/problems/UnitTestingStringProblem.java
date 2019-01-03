package string.problems;

import org.testng.Assert;

public class UnitTestingStringProblem {
    public static void main(String[] args) {
        //Apply Unit Test into all the methods in this package.


        Assert.assertEquals(true, Anagram.isAnagram("Shafi","Ifahs"));
        String testString = "I have a dream";
        Assert.assertEquals("5 dream", DetermineLargestWord.findTheLargestWord(testString));
        Assert.assertEquals(true, Palindrome.isPalindrome("DAD"));
        String st = "Java is a programming Language. Java is also an Island of Indonesia. Java is widely used language";
        //Assert.assertEquals("Java: 3, a: 1, Language.: 1, widely: 1, is: 3, also: 1, language: 1, used: 1, an: 1, Island: 1, Indonesia.: 1, programming: 1, of: 1",DuplicateWord.DuplicateWords(st));


        //last one is not working

    }
}
