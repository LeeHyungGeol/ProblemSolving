import java.util.*;

class Solution {
     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         Map<String, Integer> map = new HashMap<>();
        
//         for(String phone : phone_book) {
//             map.put(phone, 1);
//         }
        
//         for(int i = 0; i < phone_book.length; ++i) {
//             String temp = "";
//             for(int j = 0; j < phone_book[i].length(); ++j) {
//                 temp += phone_book[i].charAt(j);
//                 if(map.containsKey(temp) && !temp.equals(phone_book[i])) {
//                     return false;
//                 }
//             }
//         }
        
//         return true;
         
        Arrays.sort(phone_book);
        boolean result = true;
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) {
                result = false;
                break;
            }
        }
        return result;
     }
    
//     public static boolean solution2(String[] phoneBook) {
//         Arrays.sort(phoneBook);
//         for(int i=0; i<phoneBook.length-1;i++) {
//             if(phoneBook[i+1].startsWith(phoneBook[i])) {
//                 return false;
//             }
//         }
//         return true;
//     }
}