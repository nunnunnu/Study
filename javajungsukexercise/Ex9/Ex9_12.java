import java.text.Normalizer.Form;

public class Ex9_12 {
    public static void main(String[] args) {
        for(int i=0;i<20;i++){
            System.out.print(getRand(1, -3)+",");
        }
        System.out.println();
        for(int i=0;i<20;i++){
            System.out.print(getRand(1, 10)+",");
        }
    }
    public static int getRand(int from, int to) {
        int r = (int)(Math.random()*(Math.abs(to)+1))+(Math.min(from, to));
        return r;
    }
}
