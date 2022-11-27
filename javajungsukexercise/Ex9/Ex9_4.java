public class Ex9_4 {
    public static void main(String[] args) {
        printGraph(new int[]{3,7,1,4}, '*');
    }

    public static void printGraph(int[] dateArr, char ch){
        for(int i=0;i<dateArr.length;i++){
            for(int j=0;j<dateArr[i];j++){
                System.out.print(ch);
            }
            System.out.print(dateArr[i]);
            System.out.println();
        }
    }
}
