import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[][] num = new int[N][2];
        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                num[i][j] = s.nextInt();
            }
        }
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2){
                return n1[1]!=n2[1]?n1[1]-n2[1]:n1[0]-n2[0];
            }
        });
        for(int i=0;i<N;i++){
            System.out.println(num[i][0]+" "+num[i][1]);
        }
        s.close();
    }
}
