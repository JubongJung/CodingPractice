import javax.swing.text.html.parser.Entity;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Map.Entry;


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

    //    베스트앨범
    //    https://programmers.co.kr/learn/courses/30/lessons/42579
    public int[] Question4(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> allSongs = new HashMap<>();
        HashMap<String, Integer> genreStat = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if(allSongs.containsKey(genres[i])){
                allSongs.get(genres[i]).put(i, plays[i]);
            }else{
                HashMap<Integer, Integer> tmpHashMap = new HashMap<>();
                tmpHashMap.put(i, plays[i]);
                allSongs.put(genres[i], tmpHashMap);
            }

            if (genreStat.containsKey(genres[i])) {
                genreStat.put(genres[i], genreStat.get(genres[i]) + plays[i]);

            }else{
                genreStat.put(genres[i], plays[i]);
            }
        }

        List<Map.Entry<String, Integer>> genreRank = new LinkedList<>(genreStat.entrySet());
        genreRank.sort(Map.Entry.comparingByValue((x,y)->y - x));

        ArrayList<Integer> returnList = new ArrayList<>();

        loop:
        for (int i = 0; i < genreRank.size(); i++) {
            String genre = genreRank.get(i).getKey();

            List<Map.Entry<Integer, Integer>> genreSongs = new LinkedList<>(allSongs.get(genre).entrySet());
            genreSongs.sort(Map.Entry.comparingByValue((x,y)->y - x));

            for(int j = 0; j < 2 && j < genreSongs.size(); j++) {
                returnList.add(genreSongs.get(j).getKey());
            }

        }

        // 결과값 반환을 위한 형변환
        int[] answer = new int[returnList.size()];

        for(int i = 0; i < returnList.size(); i++) {
            answer[i] = returnList.get(i);
        }

        return answer;
    }
}


