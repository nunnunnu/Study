public class Line {
    public static void main(String[] args) {
        int[][] lines={{0, 5}, {3, 9}, {1, 10}};
        System.out.println(b(lines));
    }

    public static int b(int[][] lines) {
        int answer=0;
        int[] list = new int[201];
        for(int i=0;i<lines.length;i++){
            for(int j=lines[i][0];j<lines[i][1];j++){
                list[j+100]++;
            }
        }
        for(int i=0;i<list.length;i++){
            if(list[i]>=2){
                answer++;
            }
        }


        return answer;
    }
}
