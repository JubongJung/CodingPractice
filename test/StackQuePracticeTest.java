import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StackQuePracticeTest {

    private final StackQuePractice stackQuePractice = new StackQuePractice();

    @Test
    void 기능개발() {
        int[] progresses1 = {93, 30, 55};
        int[] progresses2 = {95, 90, 99, 99, 80, 99};


        int[] speeds1 = {1, 30, 5};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};

        int[] result1 = {2, 1};
        int[] result2 = {1, 3, 2};

        Assertions.assertArrayEquals(result1, stackQuePractice.Question1(progresses1, speeds1));
        Assertions.assertArrayEquals(result2, stackQuePractice.Question1(progresses2, speeds2));
    }

    @Test
    void 프린터() {
        int[] priorities1 = {2,1,3,2};
        int location1 = 2;
        int returnVal1 = 1;

        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int returnVal2 = 5;

        Assertions.assertEquals(returnVal1, stackQuePractice.Question2(priorities1, location1));
        Assertions.assertEquals(returnVal2, stackQuePractice.Question2(priorities2, location2));
    }

    @Test
    void 다리를_지나는_트럭() {
        int bridge_length1 = 2;
        int bridge_length2 = 100;
        int bridge_length3 = 100;

        int weight1 = 10;
        int weight2 = 100;
        int weight3 = 100;

        int[] truck_weights1 = {7,4,5,6};
        int[] truck_weights2 = {10};
        int[] truck_weights3 = {10,10,10,10,10,10,10,10,10,10};

        int return1 = 8;
        int return2 = 101;
        int return3 = 110;

        Assertions.assertEquals(return1, stackQuePractice.Question3(bridge_length1, weight1, truck_weights1));
        Assertions.assertEquals(return2, stackQuePractice.Question3(bridge_length2, weight2, truck_weights2));
        Assertions.assertEquals(return3, stackQuePractice.Question3(bridge_length3, weight3, truck_weights3));
    }

    @Test
    void 주식가격() {
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = {4, 3, 1, 1, 0};

        Assertions.assertArrayEquals(result, stackQuePractice.Question4(prices));
    }
}
