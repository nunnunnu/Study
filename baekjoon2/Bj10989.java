import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10989 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int[] counting = new int[10001];
    
    int N = Integer.parseInt(br.readLine());
    for(int i=0;i<N;i++){
      counting[Integer.parseInt(br.readLine())]++;
    }

    StringBuilder sb = new StringBuilder();
    for(int i=1;i<10001;i++){
      while(counting[i]>0){
        sb.append(i).append('\n');
        counting[i]--;
      }
    }
    System.out.println(sb);
  }
}
