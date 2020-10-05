public class Cuboid {
    public static void main(String[] args) {
        double a, b, c, surface, volume;
        a = 200;
        b = 300;
        c = 400;
        surface = 2*((a*b)+(b*c)+(a*c));
        volume = a*b*c;

        System.out.println("Surface is: " + (int)surface);
        System.out.println("Volume is: " + (int)volume);


    }
}
