package Calculator;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void addExeptionTest() {
        try {
            stringCalculator.add("1,2,-2,6");
        } catch (IllegalArgumentExeption exeption) {
            Assertions.assertEquals(exeption.getMessage(), "negatives not allowed -2");
        }
    }

    private static Stream<Arguments> testMethodGenerator() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1", 1),
                Arguments.of("1,2", 3),
                Arguments.of("1, 2, 3", 6),
                Arguments.of("2,1001", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testMethodGenerator")
    void addTest(String numbers, int result) {
        org.assertj.core.api.Assertions.assertThat(stringCalculator.add(numbers))
                .isEqualTo(result)
                .isNotEqualTo(-1)
                .isLessThan(10)
                .isGreaterThan(-2)
                .isBetween(-100, 100)
                .isCloseTo(5, Percentage.withPercentage(100.0));
    }
}
