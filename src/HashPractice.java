import java.util.HashMap;

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

        loop:
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(i == j) continue;

                if (phone_book[i].length() <= phone_book[j].length() &&
                        phone_book[i].equals(phone_book[j].substring(0,phone_book[i].length()))) {
                    answer = false;
                    break loop;
                }
            }
        }

        return answer;
    }
}
