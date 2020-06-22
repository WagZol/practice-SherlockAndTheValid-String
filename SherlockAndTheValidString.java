import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> charOccurency=new HashMap<>();
        Map<Integer, Integer> occurencyOccurencies=new HashMap<>();
        int characterOccurency=0;

        Character character='a';
        for(Character c: s.toCharArray()){
            character=c;
            characterOccurency=charOccurency.getOrDefault(c, 0);
            charOccurency.put(c, characterOccurency+1);
        }

        for (Map.Entry<Character, Integer> entry : charOccurency.entrySet()) {
            System.out.println(entry.getKey()+"-"+entry.getValue());
            occurencyOccurencies.put(entry.getValue(), occurencyOccurencies.getOrDefault(entry.getValue(),0)+1);

            if(occurencyOccurencies.size()>2)
                return "NO";
            if(occurencyOccurencies.size()==2){
                if(occurencyOccurencies.getOrDefault(entry.getValue()-1,0)!=1 &&
                occurencyOccurencies.getOrDefault(entry.getValue()+1,0)!=1 &&
                occurencyOccurencies.getOrDefault(entry.getValue(),0)!=1 &&
                occurencyOccurencies.getOrDefault(1,0)!=1)
                    return "NO";
            }    
        }

        return "YES";     
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
