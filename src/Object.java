public class Object {
    public final float GRAVITY = 9.82f;
    public int mass;
    public Object(int mass) {
        this.mass = mass;
    }

    public int potentialEnergy(int height) {
        int F;
        F = (int) (mass * height * GRAVITY);
        return F;
    }
}
