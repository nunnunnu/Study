import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11653{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // Scanner s = new Scanner(System.in);
        // int N = s.nextInt();
        int tmp = N;
        for(int i=2;i<=tmp;i++){
            if(tmp%i==0){
                System.out.println(i);
                tmp /= i;
                i=1;
            }
        }
        br.close();;
    }
}