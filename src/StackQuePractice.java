import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    
    // https://programmers.co.kr/learn/courses/30/lessons/42587
    // 프린터
    public int Question2(int[] priorities, int location) {
        int answer = 0;



        return answer;
    }
}
