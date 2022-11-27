import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9020 {
  static boolean[] check = new boolean[10001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    get();
    for(int i=0;i<T;i++){
      int n = Integer.parseInt(br.readLine());
      int idx=n/2, idx2=n/2;
      while(true){
        if(!check[idx] && !check[idx2]){
          if(idx+idx2==n){
            System.out.println(idx+" "+idx2);
            break;
          }
        }else{
          idx--;
          idx2++;
        }
      }
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
