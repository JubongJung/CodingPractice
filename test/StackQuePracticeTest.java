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
}
