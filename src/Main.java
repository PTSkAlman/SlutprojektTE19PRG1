/**
 * Created 2021-04-27
 *
 * @author
 */
public class Main {
    public static void main(String[] args) {
        Object object = new Object(60, 0.5f);
        System.out.println(object.potentialEnergy(5) + "N");
        System.out.println(object.density() + "kg/m^3");
        System.out.println();
    }
}
