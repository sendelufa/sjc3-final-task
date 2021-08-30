import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Little Strikes Simple Tests")
public class LittleStrikesTests {

    private static Stream<Arguments> provideSimpleLittleStrikes() {
        return Stream.of(
            Arguments.of(6, TestUtils.generateBombingOrder("0L"),
                """
                    ·█████
                    ██████
                    ██████
                    ██████
                    ██████
                    ██████"""
            ),
            Arguments.of(6, TestUtils.generateBombingOrder("3L>3L>4L"),
                """
                    ███··█
                    ███·██
                    ██████
                    ██████
                    ██████
                    ██████"""
            ),
            Arguments.of(6, TestUtils.generateBombingOrder("5L>5L>5L>5L>5L>5L>5L"),
                """
                    █████·
                    █████·
                    █████·
                    █████·
                    █████·
                    █████·"""
            )
        );
    }


    @ParameterizedTest
    @DisplayName("littleStrikes")
    @MethodSource("provideSimpleLittleStrikes")
    void testSimpleStrikes(int fieldSize, Strike[] strikes, String expected) {
        assertEquals("\n" + expected, "\n" + SpaceCannon.fire(fieldSize, strikes));
    }
}
