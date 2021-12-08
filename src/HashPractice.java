import java.util.*;

public class HashPractice {
    //    완주하지 못한 선수
    //    https://programmers.co.kr/learn/courses/30/lessons/42576
    public String Question1(String[] participant, String[] completion){
        String answer = "";

        HashMap<String, Integer> hashParticipant = new HashMap<>();

        for (String s : completion) {
            if (hashParticipant.containsKey(s)) {
                hashParticipant.put(s, hashParticipant.get(s) + 1);
            } else {
                hashParticipant.put(s, 0);
            }
        }
        for (String s : participant) {
            int result = hashParticipant.getOrDefault(s, -1);
            if (result == -1) {
                answer = s;
                break;
            } else if (result == 0) {
                hashParticipant.remove(s);
            } else {
                hashParticipant.put(s, hashParticipant.get(s) - 1);
            }
        }

        return answer;
    }

//    전화번호 목록
//    https://programmers.co.kr/learn/courses/30/lessons/42577
    public boolean Question2(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        boolean result = true;
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].contains(phone_book[i])) {
                result = false;
                break;
            }
        }

        return answer;
    }

//    위장
//    https://programmers.co.kr/learn/courses/30/lessons/42578
    public int Question3(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String[] s : clothes) {
            if (!hashMap.containsKey(s[1])) {
                hashMap.put(s[1], 1);
            } else {
                hashMap.put(s[1], hashMap.get(s[1]) + 1);
            }
        }

        String[] keys = hashMap.keySet().toArray(new String[hashMap.size()]);

        for (int i = 0; i < keys.length; i++) {
            answer = answer * (hashMap.get(keys[i]) + 1);
        }

        return answer - 1;
    }
}


