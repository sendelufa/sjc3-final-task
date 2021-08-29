public class Strike {

    private final int coordinateX;
    private final ImpactForce impactForce;

    public Strike(int coordinateX, ImpactForce impactForce) {
        this.coordinateX = coordinateX;
        this.impactForce = impactForce;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public ImpactForce getImpactForce() {
        return impactForce;
    }

    @Override
    public String toString() {
        return "" + coordinateX + impactForce.toString().charAt(0);
    }
}
