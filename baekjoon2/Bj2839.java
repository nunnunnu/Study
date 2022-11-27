import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2839{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int bag = 0;
        while(true){
            if(N%5==0) {
                bag+=N/5;
                break;
            }
            else {
                N-=3;
                bag++;
            }
            if(N<0) {
                bag=-1; 
                break;
            }
        }
            System.out.println(bag);
        
    }
}
