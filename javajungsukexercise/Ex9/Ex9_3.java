public class Ex9_3 {
    public static void main(String[] args) {
        String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
        String path="";
        String fileName = "";

        // path = fullPath.substring(0,14);
        // fileName=fullPath.substring(15);

        int pos = fullPath.lastIndexOf("\\");

        if(pos!=-1){
            path = fullPath.substring(0, pos);
            fileName = fullPath.substring(pos+1);
        }
        System.out.println(fullPath);
        System.out.println(path);
        System.out.println(fileName);
    }
}
