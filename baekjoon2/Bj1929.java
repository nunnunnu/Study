import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1929{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine()," ");
        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        boolean[] check = new boolean[N+1];
        check[0] = check[1] = true;

        for(int i=2;i<=Math.sqrt(check.length);i++){
            if(check[i]) continue;
            for(int j=i*i;j<check.length;j+=i){
                check[j]=true;
            }

        }
        for(int i=M;i<=N;i++){
            if(!check[i]) System.out.println(i);
        }
    }
}