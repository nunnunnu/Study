import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bj2751 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<Integer>();
    for(int i=0;i<N;i++){
      list.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(list);
    
    StringBuilder sb = new StringBuilder();
    for(int num : list){
      sb.append(num).append("\n");
    }
    System.out.println(sb);
    
  }
}
