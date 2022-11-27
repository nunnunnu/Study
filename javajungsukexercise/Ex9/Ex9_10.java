import java.util.Arrays;

public class Ex9_10 {
    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str,7,0));
        System.out.println(format(str,70,1));
        System.out.println(format(str,7,2));
        
    }
    public static String format(String str, int length, int alignment){
        if(length<str.length()){
            return str.substring(0, length);
        }else{
            char[] c = new char[length];
            Arrays.fill(c, '.');
            char[] sarr = str.toCharArray();
            String result="";
            if(alignment==0){
                System.arraycopy(sarr, 0, c, 0, sarr.length);
                for(int i=0;i<length;i++){
                    result+=c[i];
                }
            }else if(alignment==1){
                System.arraycopy(sarr, 0, c, (c.length-str.length())/2, sarr.length);
                for(int i=0;i<length;i++){
                    result+=c[i];
                }
            }else if(alignment==2){
                System.arraycopy(sarr, 0, c, c.length-str.length(), sarr.length);
                for(int i=0;i<length;i++){
                    result+=c[i];
                }
            }else{
                System.out.println("번호를 잘못입력하셨습니다");
            }
            return result;
        }
    }
}
