import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Bj1427 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int length =  (int)(Math.log10(num)+1);
        Integer[] arr = new Integer[length];
        for(int i=0;i<arr.length;i++){
            arr[i]=num%10;
            num/=10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
    }
}
