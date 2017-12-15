package a.solutions;
import java.util.*;

public class Solution1
{        

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