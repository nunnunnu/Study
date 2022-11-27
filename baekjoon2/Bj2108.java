import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bj2108 {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    for(int i=0;i<N;i++){
      arr[i] = Integer.parseInt(br.readLine());
      map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
    }
    Arrays.sort(arr);
    int sum=0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i=0;i<N;i++){
      sum += arr[i];
      if(arr[i]>max){
        max=arr[i];
      }
      if(arr[i]<min){
        min=arr[i];
      }
    }
    List<Integer> keyList = new ArrayList<Integer>(map.values());
    int m1 = 0;
    int m2 = 0;
    Map<Integer, Integer> sortmap = new TreeMap<>(map);
    for(Integer a : keyList){
      if(m1<a){
        m1 = a;
      }
    }
    int count=0;
    for(Integer key : sortmap.keySet()){
      if(sortmap.get(key)==m1){
        m2 = key;
        count++;
      }
      if(count==2){
        break;
      }
    }


    System.out.println((int)Math.round((double)sum/N));
    System.out.println(arr[N/2]);
    System.out.println(m2);
    System.out.println(max-min);
  }
}
