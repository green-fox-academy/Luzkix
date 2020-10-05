public class VariableMutation {
    public static void main(String[] args) {
        int a = 3;
        a += 10;
        System.out.println(a);

        int b = 100;
        b -= 7;
        System.out.println(b);

        int c = 44;
        c = c*2;
        System.out.println(c);

        int d = 125;
        d = d/5;
        System.out.println(d);

        int e = 8;
        e = e*e;
        System.out.println(e);

        int f1 = 123;
        int f2 = 345;
        boolean boo1 = (f1 > f2);
        System.out.println(boo1);

        int g1 = 350;
        int g2 = 200;
        boolean boo2 = ((g2*2) > g1);
        System.out.println(boo2);

        int h = 135798745;
        boolean boo3 = ((h % 11)==0);
        System.out.println(boo3);

        int i1 = 10;
        int i2 = 3;
        boolean boo4 = ((i1 > (i2*i2)) && (i1 < (i2*i2*i2)));
        System.out.println(boo4);

        int j = 1521;
        boolean boo5 = ((j % 3 == 0) | (j % 5 == 0));
        System.out.println(boo5);

    }
}
