
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex8_8{
    public static void main(String[] args) {
        //1~100사이의 임의의 값을 얻어서 answer에 저장한다
        int answer = (int)(Math.random()*100)+1;
        int input=0;
        int count=0;
        Scanner s = new Scanner(System.in);
        do{
            try{
                System.out.println("1과 100사이의 값을 입력하세요 : >");
                input = s.nextInt();
            } catch(InputMismatchException e){
                System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
                continue;
            }
            count++;
                if(answer>input) System.out.println("더 큰수를 입력하세요.");
            else if(answer <input) System.out.println("더 작은 수를 입력하세요.");
            else {
                System.out.println("맞췄습니다.");
                System.out.println("시도횟수는 "+count+"번 입니다.");
                s.close();
                break;
            }
        }while(true);
    }
}