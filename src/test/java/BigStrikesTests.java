import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Big Strikes Simple Tests")
public class BigStrikesTests {

    private static Stream<Arguments> provideSimpleBigStrikes() {
        return Stream.of(
            Arguments.of(6, TestUtils.generateBombingOrder("0B"),
                """
                    ··████
                    ·█████
                    ██████
                    ██████
                    ██████
                    ██████"""
            ),
            Arguments.of(6, TestUtils.generateBombingOrder("3B>3B>3B"),
                """
                    ██···█
                    ███·██
                    ██···█
                    ███·██
                    ██···█
                    ███·██"""
            ),
            Arguments.of(6, TestUtils.generateBombingOrder("2B>3B>2B>5B"),
                """
                    █·····
                    ██··█·
                    █···██
                    ██·███
                    ██████
                    ██████"""
            )
        );
    }


    @ParameterizedTest
    @DisplayName("littleStrikes")
    @MethodSource("provideSimpleBigStrikes")
    void testSimpleStrikes(int fieldSize, Strike[] strikes, String expected) {
        assertEquals("\n" + expected, "\n" + SpaceCannon.fire(fieldSize, strikes));
    }
}
