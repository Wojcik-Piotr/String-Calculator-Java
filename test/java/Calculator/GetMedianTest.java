package Calculator;


import org.assertj.core.api.Assertions;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class GetMedianTest {
    private GetMedian getMedian;

    @BeforeEach
    void setUp() {
        getMedian = new GetMedian();
    }

    @ParameterizedTest
    @MethodSource("testMethodGenerator")
    void getNumberTest(int[] array, int result) {
        Assertions.assertThat(getMedian.getMedian(array))
                .isEqualTo(result)
                .isNotEqualTo(-2)
                .isLessThan(50)
                .isGreaterThan(-200)
                .isBetween(-100, 100)
                .isCloseTo(5, Percentage.withPercentage(200.0));
    }

    private static Stream<Arguments> testMethodGenerator() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 1, 4, 3}, 1),
                Arguments.of(new int[]{1, 2, 3, 4}, 2),
                Arguments.of(new int[]{}, -1),
                Arguments.of(new int[]{0, 5, 0}, 5)
        );
    }
}
