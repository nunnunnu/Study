import java.util.Scanner;

public class Bj2566{
    public static void main(String[] args) {
        int arr[][] = new int[9][9];
        int max = -1;
        int index=0,index2=0;
        Scanner s = new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j] = s.nextInt();
                if(max<arr[i][j]) {
                    max = arr[i][j];
                    index = i+1;
                    index2= j+1;
                } 
            }
        }
        System.out.println(max);
        System.out.println(index+" "+index2);
        s.close();
    }
}    