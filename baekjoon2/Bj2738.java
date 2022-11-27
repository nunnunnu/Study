import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2738 {
    public static void main(String[] args) throws IOException{
        // Scanner s = new Scanner(System.in);
        // int a = s.nextInt();
        // int b = s.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int arr[][] = new int[a][b];
        int arr2[][] = new int[a][b];
        int newarr[][] = new int[a][b];
        for(int i=0;i<arr.length;i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0;j<arr[i].length;j++){
                // arr[i][j] = s.nextInt();
                arr[i][j] = Integer.parseInt(token.nextToken());
                
            }
        }
        for(int i=0;i<arr2.length;i++){
            token = new StringTokenizer(br.readLine());
            for(int j=0;j<arr2[i].length;j++){
                // arr2[i][j] = s.nextInt();
                arr2[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                newarr[i][j] = arr[i][j] + arr2[i][j];
                System.out.print(newarr[i][j]+" ");
            }
            System.out.println();
        }
        br.close();

    }
}
