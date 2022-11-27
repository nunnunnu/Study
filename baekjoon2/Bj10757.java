import java.math.BigInteger;
import java.util.Scanner;

public class Bj10757 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BigInteger num1 = new BigInteger(s.next());
        BigInteger num2 = new BigInteger(s.next());

        System.out.println(num1.add(num2));
        s.close();
    }
}
