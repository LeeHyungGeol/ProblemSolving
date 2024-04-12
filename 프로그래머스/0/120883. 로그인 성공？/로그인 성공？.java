class Solution {
    public String solution(String[] id_pw, String[][] db) {
        for (String[] row : db) {
            if (row[0].equals(id_pw[0]) && row[1].equals(id_pw[1])) return "login";
            else if (row[0].equals(id_pw[0])) return "wrong pw";
        }
        return "fail";
    }
}