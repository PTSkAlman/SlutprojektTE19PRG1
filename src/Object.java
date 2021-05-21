public class Object {

    private static final float GRAVITY = 9.82f;
    private int mass;
    private float radius;
    private int height;

    public int getHeight() {
        return height;
    }
    
    public int getMass() {
        return mass;
    }

    public float getRadius() {
        return radius;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setHeight(int height) {
        this.height = height;
    }



    public Object(int mass, float radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double volume() {
        return (4*Math.PI*radius*radius*radius)/3;
    }

    private double frontalArea() {
        return (Math.PI*radius*radius);
    }

    public double forceDown() {
        double F;
        return F = (mass*GRAVITY);
    }

    public int density() {
        double rho = mass/volume();
        return (int) Math.round(rho);
    }

    public int potentialEnergy(int height) {
        int F;
        return F = (int) (mass * height * GRAVITY);
    }

    public int terminalVelocity() {
        return 0;
    }

}
