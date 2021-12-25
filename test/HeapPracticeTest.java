import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapPracticeTest {

    private HeapPractice heapPractice = new HeapPractice();

    @Test
    void 더_맵게() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = 2;

        Assertions.assertEquals(result, heapPractice.Q1(scoville, K));
    }

    @Test
    void 디스크_컨트롤러() {
        //int[][] jobs ={{0, 3},{1, 9},{2, 6}};
        int[][] jobs =	{{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        int result = 72;

        Assertions.assertEquals(result, heapPractice.Q2(jobs));
    }

    @Test
    void 이중_우선순위_큐() {
        String[] operations1 = {"I 16","D 1"};
        //String[] operations1 = {"I 16","I 16","I 14","I 15","D 1"};
        String[] operations2 = {"I 7","I 5","I -5","D -1"};
        String[] operations3 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] result1 = {0, 0};
        int[] result2 = {7, 5};
        int[] result3 = {333, -45};

        Assertions.assertArrayEquals(result2, heapPractice.Q3(operations2));
        Assertions.assertArrayEquals(result1, heapPractice.Q3(operations1));
        Assertions.assertArrayEquals(result3, heapPractice.Q3(operations3));

    }
}