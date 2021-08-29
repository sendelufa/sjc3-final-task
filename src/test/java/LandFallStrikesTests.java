import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Mix Strikes Simple Tests")
public class LandFallStrikesTests {

    private static Stream<Arguments> provideMixStrikes() {
        return Stream.of(
            Arguments.of(3, TestUtils.generateBombingOrder("1L>1B"),
                """
                    ◯◯◯
                    ●◯●
                    ●◯●"""
            ),
            Arguments.of(4, TestUtils.generateBombingOrder("0L>0L>0L>0B>3L>3L>3B"),
                """
                    ◯◯◯◯
                    ◯●●◯
                    ◯●●◯
                    ◯●●◯"""
            ),
            Arguments.of(5, TestUtils.generateBombingOrder("0B>0B>3L>3B"),
                """
                    ◯◯◯◯◯
                    ◯◯●◯●
                    ◯●●◯●
                    ◯●●●●
                    ●●●●●"""
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
