import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Mix Strikes Simple Tests")
public class MixStrikesTests {

    private static Stream<Arguments> provideMixStrikes() {
        return Stream.of(
            Arguments.of(3, TestUtils.generateBombingOrder("0B>1L>1L"),
                """
                    ··█
                    ··█
                    █·█"""
            ),
            Arguments.of(4, TestUtils.generateBombingOrder("2B>3L>1L>2B"),
                """
                    █···
                    █···
                    █···
                    ██·█"""
            ),
            Arguments.of(5, TestUtils.generateBombingOrder("1B>0L>2B>4B"),
                """
                    ·····
                    ·····
                    ██·██
                    █████
                    █████"""
            )
        );
    }


    @ParameterizedTest
    @DisplayName("littleStrikes")
    @MethodSource("provideMixStrikes")
    void testSimpleStrikes(int fieldSize, Strike[] strikes, String expected) {
        assertEquals("\n" + expected, "\n" + SpaceCannon.fire(fieldSize, strikes));
    }
}
