import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1978 {
    public static void main(String[] args) throws IOException {
        // Scanner s = new Scanner(System.in);
        // int N = s.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer token = new StringTokenizer(br.readLine());
        int result=0;
        for(int i=0 ; i<N;i++){
            int count=0;
            // int num = s.nextInt();
            int num = Integer.parseInt(token.nextToken());
            if(num==1) continue;
            else{
                for(int j=2;j<num;j++){
                    if(num%j==0) count++;
                }
                if(count==0) result++;
            }
        }
        System.out.println(result);
        br.close();
    }
}
