public class Ex9_9 {
    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)"+" -> "+delChar("1!2@3^4~5", "~!@#$%^&*()"));
        System.out.println("1 2    3    4\t5"+" -> "+delChar("1 2    3    4\t5", " \t"));
    }
    public static String delChar(String src, String delCh){
        StringBuffer sb = new StringBuffer(src.length());
        // String result="";
        for(int i=0;i<src.length();i++){
            char c = src.charAt(i);
            if(delCh.indexOf(c)==-1){
                sb.append(c);
                // result += c;
            }
        }
        return sb.toString();
    }
}
