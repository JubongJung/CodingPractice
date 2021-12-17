import java.util.*;

public class StackQuePractice {

    public class Q1Model{

        private int progress;
        private int speed;

        public int getProgress() {
            return progress;
        }

        public void setProgress(int progress) {
            this.progress = progress;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }
    // https://programmers.co.kr/learn/courses/30/lessons/42586
    // 기능개발
    public int[] Question1(int[] progresses, int[] speeds) {
        List<Integer> returnVal = new ArrayList<>();

        Stack<Q1Model> models = new Stack<>();
        for (int i = 0; i < progresses.length; i++) {
            Q1Model model = new Q1Model();
            model.setProgress(progresses[progresses.length - i - 1]);
            model.setSpeed(speeds[progresses.length - i - 1]);
            models.push(model);
        }

        while (!models.empty()) {
            int modelsCount = 0;

            for (int i = 0; i < models.size(); i++) {
                Q1Model model = models.get(i);

                System.out.println("index : " + i + " progress : " + model.getProgress() + " speed : " + model.getSpeed());

                model.setProgress(model.getProgress() + model.getSpeed());
            }

            while (!models.empty() && models.peek().getProgress() >= 100) {
                models.pop();
                modelsCount += 1;
            }

            if (modelsCount > 0) {
                returnVal.add(modelsCount);
            }
        }

        int[] answer = new int[returnVal.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = returnVal.get(i);
        }

        return answer;
    }

    class Q2Model {
        int loc;
        int pri;

        public int getLoc() {
            return loc;
        }

        public void setLoc(int loc) {
            this.loc = loc;
        }

        public int getPri() {
            return pri;
        }

        public void setPri(int pri) {
            this.pri = pri;
        }
    }

    // https://programmers.co.kr/learn/courses/30/lessons/42587
    // 프린터
    public int Question2(int[] priorities, int location) {
        int answer = 0;

        Queue<Q2Model> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            Q2Model q2Model = new Q2Model();
            q2Model.setLoc(i);
            q2Model.setPri(priorities[i]);
            queue.add(q2Model);
        }

        loop:
        while (queue.size() >= 1) {
            Q2Model poll = queue.poll();

            int queueSize = queue.size();

            for (Q2Model q2Model : queue) {
                if (poll.getPri() < q2Model.getPri()) {
                    queue.add(poll);
                    break;
                }
            }

            if (queueSize == queue.size()) {
                answer += 1;
                if (poll.getLoc() == location) {
                    break loop;
                }
            }
        }

        return answer;
    }

    class Q3Model{
        int location;
        int weight;

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

//    https://programmers.co.kr/learn/courses/30/lessons/42583
//    다리를 지나는 트럭
    public int Question3(int bridge_length, int weight, int[] truck_weight) {
        int answer = 0;

        Queue<Q3Model> trucks = new LinkedList<>();
        Queue<Q3Model> bridge_trucks = new LinkedList<>();

        //parameter 초기화
        for (int i : truck_weight) {
            Q3Model model = new Q3Model();
            model.setLocation(0);
            model.setWeight(i);
            trucks.add(model);
        }

        // 다리에 있는 트럭 무게
        int bridge_weight = 0;

        while (!trucks.isEmpty() || !bridge_trucks.isEmpty()) {
            for (Q3Model model : bridge_trucks) {
                model.setLocation(model.getLocation() + 1);
            }

            // 다리에 트럭이 있는 경우
            if (!bridge_trucks.isEmpty()) {
                // 맨 앞 트럭의 위치가 다리 끝을 초과할 경우 빼준다.
                if (bridge_trucks.peek().getLocation() > bridge_length) {
                    Q3Model model = bridge_trucks.poll();
                    bridge_weight -= model.getWeight();
                }
            }

            if (!trucks.isEmpty()) {
                // 다리에 트럭이 들어갈수있는지 확인
                // 1. 무게 확인
                // 2. 다리에 있는 트럭 수 확인
                if (bridge_weight + trucks.peek().getWeight() <= weight
                        && bridge_trucks.size() < bridge_length) {
                    // 대기 -> 트럭으로보내기
                    Q3Model model = trucks.poll();
                    model.setLocation(1);
                    bridge_trucks.add(model);
                    // 다리에 있는 트럭 무게 추가
                    bridge_weight += model.getWeight();
                }
            }
            answer += 1;
        }

        return answer;
    }
//    https://programmers.co.kr/learn/courses/30/lessons/42584
//    주식가격
    public int[] Question4(int[] prices) {
        List<Integer> returnVal = new ArrayList<>();

        Queue<Integer> queuePrices = new LinkedList<>();
        for (int i : prices) {
            queuePrices.add(i);
        }

        while (!queuePrices.isEmpty()) {
            int price = queuePrices.poll();
            int times = 0;

            for (int i : queuePrices) {
                if (price <= i) {
                    times += 1;
                }else{
                    times += 1;
                    break;
                }
            }

            returnVal.add(times);
        }

        int[] answer = new int[returnVal.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = returnVal.get(i);
        }

        System.out.println(returnVal);

        return answer;
    }
}
