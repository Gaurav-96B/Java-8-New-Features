import java.util.*;
import java.util.stream.Collectors;

public class StreamQuestionOnString {
    public static void main(String[] args){
        String str="hello";
        //Count the frequency of each character in a String
        Map<Character,Long>map=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        map.forEach((k,v)->System.out.println(k+" "+v));

        //Find the first non repeating character in string
        Character c1=str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(v->v.getValue()==1).
                map(k->k.getKey()).findFirst().orElse(null);
        System.out.println(c1);
        //Find the first repeating character in string
        Character c2=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(v->v.getValue()>1).map(k->k.getKey()).findFirst().orElse(null);
        System.out.println(c2);

        //Remove duplicate characters (keep order)
   // Importnat
        String result=str.chars().mapToObj(c->(char)c).distinct().map(c->String.valueOf(c)).collect(Collectors.joining());
        System.out.println(result);
        //Check angaram

        //Check pallindrom

        //Reverse each word in as tring
        String result1=Arrays.stream(str.split(" ")).map(word->new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(result1);
         String vowels="aeiou";
        //Count vowel
        long c0=str.chars().mapToObj(c->(char)c).filter(c-> vowels.indexOf(c) >= 0).count();
         System.out.println(c0);

         //Find the duplicate character
        List<Character>list=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().filter(v->v.getValue()>1).map(key->key.getKey()).collect(Collectors.toList());
        System.out.println(list);
        //Count word occurrence
        Map<String ,Long>map1=Arrays.stream(str.split(" ")).collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println(map);

        //Longest word in a stentence
        String s4="Java stream questions";
        String s=Arrays.stream(s4.split(" ")).max(Comparator.comparing(s1->s1.length())).orElse(null);
        System.out.println(s);

        //Sort character alphabaticly
       String list1= str.chars().sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining(" "));
       //System.out.print(list1);

       //Sort word by length
       String s6=Arrays.stream(s4.split(" ")).sorted(Comparator.comparing(s1->s1.length())).collect(Collectors.joining(" "));
       System.out.println(s6);

        //Concatenate list of strings
        List<String> list4 = Arrays.asList("Java", "Stream");
        String s1=list4.stream().collect(Collectors.joining(" "));
        System.out.println(s1);

        //Character with highest frequency
        String s7="success";
       Character c4= s7.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().max(Comparator.comparing(v->v.getValue())).map(k->k.getKey()).orElse(null);
       System.out.println(c4);
       //Count uppercase, lowercase, digits, special
        String s8="A1b@";
        long upper = s.chars().filter(Character::isUpperCase).count();
        long lower = s.chars().filter(Character::isLowerCase).count();
        long digit = s.chars().filter(Character::isDigit).count();
        long special = s.length() - upper - lower - digit;
        System.out.println("Upper=" + upper + ", Lower=" + lower +
                ", Digit=" + digit + ", Special=" + special);

        //Extract numeric characters
        String z = "ab12c3";

        String result10 =
                z.chars()
                        .filter(Character::isDigit)
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(result10);

        //Check if all characters are unique
        String s11 = "apple";

        boolean isUnique =
                s11.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.toSet())
                        .size() == s.length();

        System.out.println(isUnique); // false

        //Remove whitespaces
        String s00 = "a b c";

        String result13 =
                s00.chars()
                        .filter(c -> c != ' ')
                        .mapToObj(c -> String.valueOf((char)c))
                        .collect(Collectors.joining());

        System.out.println(result13); // abc


        //Find common characters between two strings
        String s16 = "abcdef";
        String s2 = "bdfhik";

        Set<Character> set2 =
                s2.chars().mapToObj(c -> (char)c).collect(Collectors.toSet());

        List<Character> common =
                s16.chars()
                        .mapToObj(c -> (char)c)
                        .filter(set2::contains)
                        .collect(Collectors.toList());

        System.out.println(common); // [b, d, f]
















        //       //Count frequency of each character in a string
//       Map<Character,Long> map=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
//       System.out.println(map);
//
//       //Find first non-repeated character
//        Character charSeq=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream()
//                .filter(v->v.getValue()==1).map(k->k.getKey()).findFirst().orElse(null);
//        System.out.println(charSeq);
//
//
//        //Find first repeated character in a string
//       // str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,new LinkedHashMap<>(),Collectors.counting())).
//
//
//        //Remove duplicate character
//        String result=str.chars().mapToObj(c->(char)c).distinct().map(c->String.valueOf(c)).collect(Collectors.joining());
//        System.out.println(result);
//
//        //Find the duplicate character in a string
//        Set<Character> set=str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting())).entrySet().stream().filter(v->v.getValue()>1).
//                map(k->k.getKey()).collect(Collectors.toSet());
//        System.out.println(set);
//
//
//
//        //Reverse each word in a string
//
//        String result1=Arrays.stream(str.split(" ")).map(word->new StringBuilder(word).reverse().toString()).collect(Collectors
//                .joining(" "));
//        System.out.println(result1);
//
//        //Sort a character in a string
//        String sortedString=str.chars().sorted().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
//        System.out.println(sortedString);
//          String str1=" Hello Worldo";
//        //Find a longest word in a sentence
//        String string= Arrays.stream(str1.split(" ")).max(Comparator.comparing(s->s.length())).orElse(" ");
//        System.out.println(string);
//        //Find a First letter of a word in sentence
//       String s1=Arrays.stream(str1.split(" ")).filter(s->!s.isEmpty()).map(s->s.charAt(0)).map(c->String.valueOf(c)).collect(Collectors.joining());
//       System.out.println(s1);
//
//       //Count the number of vowels in a String
//        String vowels="aeiou";
//       long count=str.chars().mapToObj(c->(char)c).filter(c->vowels.indexOf(c)>=0).count();
//       System.out.println(count);
//
//       //
//
//        //Check if String is pallindrom
//
//
//
//        //there are two string find the uncommon string from the both
//        String s2="";
//        String s4="";
//




    }



}

