
class UnsupportedFunctionException extends RuntimeException {
    final private int ERR_CODE;
    UnsupportedFunctionException(String msg, int errCode){
        super(msg); //조상의 생성자 RuntimeException(String msg)호출
        ERR_CODE=errCode;
    }
    UnsupportedFunctionException(String msg){
        this(msg,100);
    }
    public int getErrorCode(){
        return ERR_CODE;
    }
    public String getMessage(){ //Exception의 getMessage를 오버라이딩
        return "[" + getErrorCode()+"]"+super.getMessage(); 
    }
}

public class Ex8_9 {
    public static void main(String[] args) {
        throw new UnsupportedFunctionException("지원하지 않는 기능입니다.",100);
    }    
}
