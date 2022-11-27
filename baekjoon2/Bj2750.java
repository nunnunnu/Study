import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2750{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    int[] arr = new int[T];
    for(int i=0;i<T;i++){
      arr[i] = Integer.parseInt(br.readLine());
    }
    // Arrays.sort(arr);
    // for(int i=0;i<arr.length;i++){
    //   System.out.println(arr[i]);
    // }
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        if(arr[i]>arr[j]){
          int tmp = 0;
          tmp = arr[i];
          arr[i]=arr[j];
          arr[j] = tmp;
        }
      }
      
    }
    for(int i=0;i<arr.length;i++){
      System.out.println(arr[i]);
    }
    
  }
}