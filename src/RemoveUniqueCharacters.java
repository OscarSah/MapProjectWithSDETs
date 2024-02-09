import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Only Duplicates
https://www.codewars.com/kata/5a1dc4baffe75f270200006b
Given a string, remove any characters that are unique from the string.

Example:

input: "abccdefee"

output: "cceee"

 */
public class RemoveUniqueCharacters {

    public static void main(String[] args) {

        System.out.println(removeUniqueCharacters2("a111bcc22defee"));


    }

    public static String removeUniqueCharacters(String input){
        // create a map to store character frequency
        Map<Character,Integer> charFrequency = new HashMap<>();

        for(char c : input.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                charFrequency.put(c, charFrequency.getOrDefault(c,0) + 1);
                // getOrDefault(c,0) : if c exists inside Map, it brings that key's value, if it does not exist, the value starts from zero
            }
        }

        StringBuilder result = new StringBuilder();

        for (char c : input.toLowerCase().toCharArray()){
            if(charFrequency.get(c) > 1){
                result.append(c);
            }
        }

        return result.toString();

    }

    public static String removeUniqueCharacters2(String input){
        // create a map to store character frequency
        Map<Character,Integer> charFrequency = new LinkedHashMap<>();

        for(char c : input.toLowerCase().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                charFrequency.put(c, charFrequency.getOrDefault(c,0) + 1);
                // getOrDefault(c,0) : if c exists inside Map, it brings that key's value, if it does not exist, the value starts from zero
            }
        }

       String result = "";

        for(Map.Entry<Character, Integer> eachOne : charFrequency.entrySet()){
            if(eachOne.getValue() > 1){
                for(int i = 0 ; i < eachOne.getValue(); i++){
                    result += eachOne.getKey();
                }
            }
        }


        return result;

    }

}

