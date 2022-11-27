import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj25305 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer token = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(token.nextToken());
    int K = Integer.parseInt(token.nextToken());
    String[] arr = br.readLine().split(" ");
    Integer[] intarr = new Integer[N];
    for(int i=0;i<arr.length;i++){
      intarr[i] = Integer.parseInt(arr[i]);
    }
    Arrays.sort(intarr);
    System.out.println(intarr[intarr.length-K]);
    br.close();
    // Scanner s = new Scanner(System.in);
    // int N = s.nextInt();
    // int K = s.nextInt();
    // Integer[] arr = new Integer[N];
    // for(int i=0;i<arr.length;i++){
    //   arr[i] = s.nextInt();
    // }
    // Arrays.sort(arr, Collections.reverseOrder());
    // System.out.println(arr[K-1]);
    // s.close();
  }
}
