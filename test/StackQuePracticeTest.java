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
}
