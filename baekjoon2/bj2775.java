
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2775 {

    static int check (int floor, int room){
        if(floor<0 || room<=0){
            return 0;
        }else if(floor==0) return room;
        else {
        return check(floor,room-1)+check(floor-1,room);
        }
    }
    public static void main(String[] args) throws IOException {
        
        // s = new Scanner(System.in);
        // int t= s.nextInt();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());

		for(int i=0;i<T;i++) {
            // int floor = s.nextInt();
            // int room=s.nextInt();
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());

            System.out.println(check(floor,room));
        }
    }
    
}
