import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Huge Strikes Simple Tests")
public class HugeStrikesTests {

    private static Stream<Arguments> provideSimpleBigStrikes() {
        return Stream.of(
            Arguments.of(6, TestUtils.generateBombingOrder("1H"),
                """
                    ····██
                    ···███
                    █·████
                    ██████
                    ██████
                    ██████"""
            ),
            Arguments.of(7, TestUtils.generateBombingOrder("3H>3H"),
                """
                    █·····█
                    ██···██
                    ██···██
                    █·····█
                    ██···██
                    ███·███
                    ███████"""
            ),
            Arguments.of(7, TestUtils.generateBombingOrder("2H>5H>4H>3H"),
                """
                    ·······
                    █······
                    ██·····
                    ██····█
                    █·····█
                    ██···██
                    ███·███"""
            )
        );
    }


    @ParameterizedTest
    @DisplayName("hugeStrikes")
    @MethodSource("provideSimpleBigStrikes")
    void testSimpleStrikes(int fieldSize, Strike[] strikes, String expected) {
        assertEquals("\n" + expected, "\n" + SpaceCannon.fire(fieldSize, strikes));
    }
}
