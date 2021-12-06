import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashPracticeTest {

    HashPractice hashPractice = new HashPractice();

    @Test
    void 완주하지_못한_선수() {
        String[] part1 = {"leo", "kiki", "eden"};
        String[] comp1 = {"eden", "kiki"};
        String result1 = "leo";

        String[] part2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] comp2 = {"josipa", "filipa", "marina", "nikola"};
        String result2 = "vinko";

        String[] part3 = {"mislav", "stanko", "mislav", "ana"};
        String[] comp3 = {"stanko", "ana", "mislav"};
        String result3 = "mislav";

        assertEquals(result1, hashPractice.Question1(part1, comp1));
        assertEquals(result2, hashPractice.Question1(part2, comp2));
        assertEquals(result3, hashPractice.Question1(part3, comp3));
    }
}