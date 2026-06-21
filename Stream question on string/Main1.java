import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestionOnString {
    public static void main(String[] args){
        
//1. Count the frequency of each character
Map<Character, Long> freqMap = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()));

//2. Find first non-repeating character
Character firstNonRepeat = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() == 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

//3. Find first repeating character
Character firstRepeat = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .findFirst()
        .orElse(null);

//4. Remove duplicate characters (keep order)
String unique = str.chars()
        .distinct()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());

        OR
String result = str.chars()
                   .mapToObj(c -> (char)c)
                   .distinct()
                   .map(String::valueOf)
                   .collect(Collectors.joining());
System.out.println(result);

//5. Reverse each word in a String
String reversedWords = Arrays.stream(str.split(" "))
        .map(word -> new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));

//6. Reverse a String
String reverse = IntStream.range(0, str.length())
        .mapToObj(i -> String.valueOf(str.charAt(str.length() - 1 - i)))
        .collect(Collectors.joining());

//7. Find duplicate characters
Set<Character> duplicates = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()))
        .entrySet()
        .stream()
        .filter(e -> e.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());

//8. Count word occurrence
Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

        OR
Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
        .collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()));

//9. Sort string (words)
String sortedWords = Arrays.stream(sentence.split(" "))
        .sorted()
        .collect(Collectors.joining(" "));

//10. Sort characters alphabetically
String sortedChars = str.chars()
        .sorted()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());

OR
String sortedChars = str.chars()
                        .mapToObj(c -> (char)c)
                        .sorted()
                        .map(c -> String.valueOf(c))
                        .collect(Collectors.joining());
OR
String sortedChars = str.chars()
                        .mapToObj(c -> (char)c)
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.joining());

//11. Longest word in a sentence
String longestWord = Arrays.stream(sentence.split(" "))
        .max(Comparator.comparingInt(String::length))
        .orElse("");
OR
String longestWord = Arrays.stream(sentence.split(" "))
        .max(Comparator.comparingInt(s -> s.length()))
        .orElse("");

//12. Sort words by length
List<String> sortedByLength = Arrays.stream(sentence.split(" "))
        .sorted(Comparator.comparingInt(String::length))
        .collect(Collectors.toList());
OR
List<String> sortedByLength = Arrays.stream(sentence.split(" "))
        .sorted(Comparator.comparingInt(s -> s.length()))
        .collect(Collectors.toList());

//13. Check palindrome
boolean palindrome = str.equals(
        new StringBuilder(str).reverse().toString());

//14. Check anagram
boolean anagram =
        str1.chars().sorted().boxed().collect(Collectors.toList())
                .equals(
        str2.chars().sorted().boxed().collect(Collectors.toList()));
OR
Map<Character, Long> map1 = str1.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

Map<Character, Long> map2 = str2.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

boolean anagram = map1.equals(map2);

//15. Count vowels
long vowels = str.toLowerCase()
        .chars()
        .filter(c -> "aeiou".indexOf(c) != -1)
        .count();
OR
long count = str.toLowerCase()
        .chars()
        .filter(c ->
                "aeiou".contains(String.valueOf((char) c)))
        .count();

//16. Character with highest frequency
Character maxFreqChar = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()))
        .entrySet()
        .stream()
        .max(Map.Entry.comparingByValue())
        .map(Map.Entry::getKey)
        .orElse(null);
OR
Character maxFreqChar = str.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(
                c -> c,
                Collectors.counting()))
        .entrySet()
        .stream()
        .max(Comparator.comparing(value -> value.getValue()))
        .map(Map.Entry::getKey)
        .orElse(null);

//17. Find common characters between two strings
Set<Character> set1 = str1.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());

Set<Character> commonChars = str2.chars()
        .mapToObj(c -> (char) c)
        .filter(set1::contains)
        .collect(Collectors.toSet());
 OR
Set<Character> set1 = str1.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());

Set<Character> commonChars = str2.chars()
        .mapToObj(c -> (char) c)
        .filter(c -> set1.contains(c))
        .collect(Collectors.toSet());


      
    }
}
