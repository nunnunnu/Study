import java.util.Scanner;

public class Ex9_11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start = s.nextInt();
        int end = s.nextInt();
        gugudan(start, end);
        
    }
    public static void gugudan(int start, int end){
        for(int i=start;i<=end;i++){
            for(int j=1;j<=9;j++){
                System.out.println(i+" x "+j+" = "+i*j);
            }
            System.out.println();
        }
    }
}
