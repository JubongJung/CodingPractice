import javax.swing.text.html.parser.Entity;
import java.util.*;

public class HeapPractice {

//    https://programmers.co.kr/learn/courses/30/lessons/42626
//    더맵게
    public int Q1(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> scovHeap = new PriorityQueue<>();

        for (int i : scoville) {
            scovHeap.add(i);
        }

        while (!scovHeap.isEmpty()) {
            int poll1 = scovHeap.poll();

            if (scovHeap.isEmpty()) {
                answer = -1;
                break;
            } else {
                int poll2 = scovHeap.poll();
                int mixed = poll1 + (poll2 * 2);
                scovHeap.add(mixed);
                answer++;

                if (scovHeap.peek() >= K) {
                    break;
                }
            }
        }

        return answer;
    }

//    https://programmers.co.kr/learn/courses/30/lessons/42627
//    디스크컨트롤러
    public int Q2(int[][] jobs) {
        int answer = 0;

        // 경과시간을 기준으로 작업목록을 지정한다.
        // 요청시간, 경과시간 목록
        Map<Integer, List<Integer>> entityMap = new HashMap<>();
        for (int[] i : jobs) {
            // 1. entity 추가 작업
            // key가 있을 경우 요청시간에 경과시간을 추가해준다.
            if (entityMap.containsKey(i[0])) {
                entityMap.get(i[0]).add(i[1]);
            } else {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(i[1]);
                entityMap.put(i[0],tmp);
            }
            answer -= i[0];
        }
        // 요청시간들을 모아 놓은 변수
        PriorityQueue<Integer> requestTimes = new PriorityQueue<>(entityMap.keySet());

        // 진행할수 있는 작업들의 경과시간
        PriorityQueue<Integer> todoList = new PriorityQueue<>();

        System.out.println(entityMap);
        //변수
        int currentTime = 0; //현재 시간 (해당 시간을 기준으로 요청시간이 값들을 추리기 위한 변수, 초기값:0)

        while (!requestTimes.isEmpty() || !todoList.isEmpty()) {
            if (!requestTimes.isEmpty() && todoList.isEmpty() && currentTime < requestTimes.peek()) {
                currentTime = requestTimes.peek();
            }
            // 현재 시간보다 작은 요청시간의 작업들을 todoList로 작업 넘겨주기
            while (!requestTimes.isEmpty() && currentTime >= requestTimes.peek()) {
                for (int i : entityMap.get(requestTimes.poll())) {
                    todoList.add(i);
                }
            }
            System.out.println(todoList.peek());
            // 작업 진행
            if (!todoList.isEmpty()) {
                currentTime += todoList.poll();
                answer += currentTime;
            }
            System.out.println("currentTime: " + currentTime + " answer : " + answer);
        }

        return answer / jobs.length;
    }

    //    https://programmers.co.kr/learn/courses/30/lessons/42628
    //    이중우선순위큐
    public int[] Q3(String[] operations) {
        int[] answer = new int[]{0, 0};

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int order = -1;

        for (String s : operations) {
            int check = GetIntValue(s);

            if (s.toLowerCase().charAt(0) == 'i' ) {
                queue.add(check);

            } else if (queue.isEmpty()) {

            } else {
                PriorityQueue<Integer> tmpQueue = null;

                if (check == -1) { // 최소 (내림차순)
                    tmpQueue = new PriorityQueue<>();
                } else if (check == 1) { // 최대 (오름차순)
                    tmpQueue = new PriorityQueue<>(Collections.reverseOrder());
                }

                while (!queue.isEmpty()) {
                    tmpQueue.add(queue.poll());
                }
                order = check;
                tmpQueue.poll();
                queue = tmpQueue;
            }
        }

        if (!queue.isEmpty()) {
            PriorityQueue<Integer> tmpQueue = null;

            if (order == 1) {
                answer[1] = queue.peek();
                tmpQueue = new PriorityQueue<>();
                while (!queue.isEmpty()) {
                    tmpQueue.add(queue.poll());
                }

                answer[0] = tmpQueue.peek();
            } else if (order == -1) {
                answer[1] = queue.peek();
                tmpQueue = new PriorityQueue<>(Collections.reverseOrder());
                while (!queue.isEmpty()) {
                    tmpQueue.add(queue.poll());
                }
                answer[0] = tmpQueue.peek();
            }
        }




        return answer;
    }

    public int GetIntValue(String str) {
        return Integer.parseInt(str.substring(2, str.length()));
    }
}
