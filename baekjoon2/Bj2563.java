import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[][]= new int[100][100];
        StringTokenizer token = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(token.nextToken());
        int count=0;
        for(int i=0;i<t;i++){
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    if(arr[x+j][y+k]==0){
                        arr[x+j][y+k] = 1;
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
