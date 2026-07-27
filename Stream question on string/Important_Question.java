   //Reverse each word
       String str="java spring kafka java";
       String s[]=str.split("\\s+");
       String result=Arrays.stream(s).map(word->new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
       System.out.println(result);
       
      //Reverse word
      String s1="java";
      String result1=new StringBuilder(s1).reverse().toString();
      System.out.println(result1);
       
       
       //Find common characters between two strings
       String s1 = "java";
       String s2 = "javascript";
       Set<Character> set = s1.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.toSet());
        
       List<Character> common = s2.chars()
        .mapToObj(c -> (char) c)
        .filter(ch -> set.contains(ch))
        .distinct()
        .collect(Collectors.toList());
         System.out.println(common);
         
        //Count vowels 
        String s4="Java";
        long count=s4.chars().mapToObj(c->(char)c).filter(c->"aeiouAEIOU".contains(String.valueOf(c))).count();
       System.out.println(count);

      //Sort character
       String str = "java";
       String result = str.chars()
        .sorted()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
       System.out.println(result);

       //Sort word
      String str = "java spring kafka aws";
      String result = Arrays.stream(str.split("\\s+"))
        .sorted()
        .collect(Collectors.joining(" "));
      System.out.println(result);

      String result = Arrays.stream(str.split("\\s+"))
        .sorted(Comparator.reverseOrder())
        .collect(Collectors.joining(" "));
       
       //Check anagram
       String s1 = "listen";
       String s2 = "silent";

       String sorted1 = s1.chars()
        .sorted()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());

      String sorted2 = s2.chars()
        .sorted()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
       boolean isAnagram = sorted1.equals(sorted2);
       System.out.println(isAnagram);
       
       boolean isAnagram =
        Arrays.equals(
                s1.chars().sorted().toArray(),
                s2.chars().sorted().toArray()
        );
        System.out.println(isAnagram);
        
        
        String s1 = "listen";
        String s2 = "silent";
      if (s1.length() != s2.length()) {
       System.out.println(false);
       return;
       }
      int[] count = new int[26];
     for (char ch : s1.toCharArray()) {
     count[ch - 'a']++;
     }
    for (char ch : s2.toCharArray()) {
    count[ch - 'a']--;
    }
    for (int value : count) {
    if (value != 0) {
        System.out.println(false);
        return;
    }
    }
    System.out.println(true);
       
