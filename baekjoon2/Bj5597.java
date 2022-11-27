import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj5597 {
    public static void main(String[] args) throws IOException{
        // Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[30];
        boolean num[] = new boolean[30];
        for(int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        for(int i=0;i<28;i++){
            // int n = s.nextInt();
            int n=Integer.parseInt(br.readLine());
            num[n-1] = true;
        }
        for(int i=0;i<num.length;i++){
            if(num[i]==false) System.out.println(i+1);
        }
    }
}
