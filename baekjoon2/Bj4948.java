import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj4948 {
  static boolean[] check = new boolean[246913];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    get();
    while(true){
      int N = Integer.parseInt(br.readLine());
      if(N==0) break;
      int count=0;
      for(int i=N+1;i<=2*N;i++){
        if(!check[i]){
          count++;
        }
      }
      System.out.println(count);
    }
  }
  public static void get() {
    
    check[0] = check[1] = true;
    
    for(int i=2;i<=Math.sqrt(check.length);i++){
      if(check[i]) continue;
      for(int j=i*i;j<check.length;j+=i){
        check[j]=true;
      }
      
    }
  }
}