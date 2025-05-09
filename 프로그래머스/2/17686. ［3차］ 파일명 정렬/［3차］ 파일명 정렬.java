import java.util.*;

class Solution {    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        FileName[] fileNames = new FileName[files.length];
        
        for (int i = 0; i < files.length; ++i) {
            fileNames[i] = FileName.of(files[i]);
        }
        
        Arrays.sort(fileNames);
        
        for (int i = 0; i < files.length; ++i) {
            answer[i] = fileNames[i].original();
        }
        
        return answer;
    }
}

class FileName implements Comparable<FileName> {
    String head;
    int number;
    String original;
    
    private FileName() {}
    
    public static FileName of(String file) {
        FileName fileName = new FileName();
        int index = 0, fileLength = file.length();
        StringBuilder head = new StringBuilder();
        StringBuilder number = new StringBuilder();
        
        while(index < fileLength && !Character.isDigit(file.charAt(index))) {
            head.append(file.charAt(index));
            ++index;
        }
        
        while(index < fileLength && Character.isDigit(file.charAt(index))) {
            number.append(file.charAt(index));
            ++index;
        }
        
        if (number.toString().equals("")) {
            number.append("0");
        } 
        
        fileName.original = file;
        fileName.head = head.toString();
        fileName.number = Integer.parseInt(number.toString());
        
        return fileName;
    }
    
    public String original() {
        return this.original;
    }
    
    @Override
    public int compareTo(FileName other) {
//         if (this.head.compareToIgnoreCase(other.head) == 0) {
//             return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(other.number));
//         }
        
//         return this.head.compareToIgnoreCase(other.head);
        
        // HEAD 비교 (대소문자 구분 없이)
            int headComparison = this.head.compareToIgnoreCase(other.head);
            if (headComparison != 0) {
                return headComparison;
            }

            // NUMBER 비교
            return Integer.compare(this.number, other.number);
    }
}