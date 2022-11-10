package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoGeneratorTest {
    private final int startNumber = 1;
    private final int endNumber = 45;
    private final int numberCount = 6;
    private LottoGenerator lottoGenerator;

    @DisplayName("로또 번호가 생성된다.")
    @Test
    void createLottoNumbers() {
        List<Integer> expected = List.of(3,4,5,6,7,8);
        int startNumberFromThree = 3;
        int endNumberInEight = 8;
        lottoGenerator = new LottoGenerator(startNumberFromThree, endNumberInEight, numberCount);

        List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
        assertTrue(lottoNumbers.containsAll(expected));
    }

    @DisplayName("로또 번호는 6개만 생성된다.")
    @Test
    void createLottoNumbersInSize() {
        int expected = 6;
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount);

        List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
        assertEquals(expected, lottoNumbers.size());
    }

    @DisplayName("로또 번호는 1부터 45까지의 숫자만 생성된다.")
    @Test
    void createLottoNumbersInRange() {
        boolean expected = true;
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount);

        List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
        for (Integer number : lottoNumbers) {
            boolean actual = (number >= startNumber && number <= endNumber);
            assertEquals(expected, actual);
        }
    }

    @DisplayName("로또 번호는 중복된 숫자 없이 생성된다.")
    @Test
    void createLottoNumbersWithoutDuplicateNumber() {
        int expected = 1;
        lottoGenerator = new LottoGenerator(startNumber, endNumber, numberCount);

        List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
        for(Integer number : lottoNumbers) {
            int actual = Collections.frequency(lottoNumbers, number);
            assertEquals(expected, actual);
        }
    }

    @DisplayName("로또 번호는 오름차순으로 정렬된다.")
    @Test
    void createLottoNumbersSortedByAscending() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);
        int endNumberInSix = 6;
        lottoGenerator = new LottoGenerator(startNumber, endNumberInSix, numberCount);

        List<Integer> lottoNumbers = lottoGenerator.getLottoNumbers();
        assertEquals(expected, lottoNumbers);
    }
}
