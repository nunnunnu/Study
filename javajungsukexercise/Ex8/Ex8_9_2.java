class UnsupportedFunctionException extends RuntimeException {
    final private int ERR_CODE; 

    UnsupportedFunctionException(String msg, int errCode){
        super(msg);
        this.ERR_CODE=errCode;
    }
    UnsupportedFunctionException(String msg){
        this(msg,100);
    }
    public int getErrorCode(){
        return ERR_CODE;
    }
    public String getMessage(){
        return "["+ERR_CODE+"]"+super.getMessage();
    }

}

public class Ex8_9_2{
    public static void main(String[] args) {
        throw new UnsupportedFunctionException("지원하지않는 기능입니다.",100);
    }
}