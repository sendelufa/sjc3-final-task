import java.util.Arrays;

public class TestUtils {

    public static Strike[] generateBombingOrder(String order) {
        return Arrays.stream(order.split(">"))
            .map(o ->
                new Strike(Integer.parseInt(o.substring(0, o.length() - 1)),
                    o.charAt(o.length() - 1) == 'L' ? ImpactForce.LITTLE : ImpactForce.BIG))
            .toArray(Strike[]::new);
    }


}
