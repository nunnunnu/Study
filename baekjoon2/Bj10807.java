import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(),"%n");
        int N = Integer.parseInt(token.nextToken());
        token= new StringTokenizer(br.readLine()," ");
        int count=0;
        int arr[] = new int[N];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(token.nextToken());
        }
        token= new StringTokenizer(br.readLine(),"%n");
        int V = Integer.parseInt(token.nextToken());
        for(int i=0;i<arr.length;i++){
            if(arr[i]==V) count++;
        }
        System.out.println(count);
    }
}