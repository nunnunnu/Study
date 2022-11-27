public class EX8_9_33333333 {
    public static void main(String[] args){
        throw new UnsupportedFunctionException2("지원하지않는기능입니다.",100);
    }
    
}

class UnsupportedFunctionException2 extends RuntimeException{

    final private int ERR_CODE;  

    // public UnsupportedFunctionException2(){}
    public UnsupportedFunctionException2(String message, int err){
        super(message); //runtimeException에 관련 메소드 있음
        this.ERR_CODE = err;
    }

    public int getERR_CODE() {
        return ERR_CODE;
    }

    public String getMessage(){
        return "["+ERR_CODE+"]"+super.getMessage();
    }
}