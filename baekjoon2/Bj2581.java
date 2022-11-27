import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2581 {
    public static void main(String[] args) throws IOException {
        // Scanner s = new Scanner(System.in);
        // int M = s.nextInt();
        // int N = s.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int tmp=Integer.MAX_VALUE;
        for(int i=M;i<=N;i++){
            boolean check = true;
            if(i==1) check = false;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    check = false;
                    break;
                }
            }
            if(check){
                sum += i;
                if(tmp>i){
                    tmp = i;
                }
            }
        }
        if(sum==0){
            tmp=-1;
            System.out.println(tmp);
        }else{
            System.out.println(sum);
            System.out.println(tmp);
        }
        br.close();
    }
}
