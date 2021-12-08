import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    void 전화번호_목록() {
        String[] phonebook1 = {"119", "97674223", "1195524421"};
        String[] phonebook2 = {"123","456","789"};
        String[] phonebook3 = {"12","123","1235","567","88"};

        assertEquals(false, hashPractice.Question2(phonebook1));
        assertEquals(true , hashPractice.Question2(phonebook2));
        assertEquals(false, hashPractice.Question2(phonebook3));
    }

    @Test
    void 위장() {
        String[][] clothe1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothe2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        assertEquals(5, hashPractice.Question3(clothe1));
        assertEquals(3, hashPractice.Question3(clothe2));
    }
}