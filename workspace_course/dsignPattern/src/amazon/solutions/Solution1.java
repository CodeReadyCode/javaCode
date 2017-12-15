package amazon.solutions;
import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution1
{        
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    // RETURN AN EMPTY LIST IF NO ANAGRAM FOUND
    public List<Integer> getAnagramIndices(String haystack, String needle)
    {
        
        if(haystack.length() < needle.length()){
            return null;
        }
        
       needle = sortByAbcd(needle);
       List<Integer> indexesOfSubStrings = new ArrayList<>();
       for (int i = 0 ; i<haystack.length() - needle.length(); i++){
           String part = haystack.substring(i, needle.length() +i );
           String sortedPartStr = sortByAbcd(part);
           if(sortedPartStr.equalsIgnoreCase(needle)){
               indexesOfSubStrings.add(i);
           }
       }
       
       return indexesOfSubStrings;
    }
    
    private String sortByAbcd(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        return sortedStr;
    }
}