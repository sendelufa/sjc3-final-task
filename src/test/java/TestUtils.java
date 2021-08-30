import java.util.Arrays;

public class TestUtils {

    public static Strike[] generateBombingOrder(String order) {
        return Arrays.stream(order.split(">"))
            .map(o ->
                new Strike(Integer.parseInt(o.substring(0, o.length() - 1)),
                    decodeImpactForce(o.charAt(o.length() - 1))))
            .toArray(Strike[]::new);
    }

    public static ImpactForce decodeImpactForce(char c) {
        switch (c) {
            case 'L': return ImpactForce.LITTLE;
            case 'B': return ImpactForce.BIG;
            case 'H': return ImpactForce.HUGE;
            default: throw new IllegalArgumentException();
        }
    }
}
