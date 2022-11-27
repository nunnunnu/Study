public class babbling {
    public static void main(String[] args) {
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
        System.out.println(a(babbling));
    }
    public static int a(String[] babbling) {
        int answer=0;
        String[] list = {"aya", "ye", "woo", "ma"};
        for(int i=0;i<babbling.length;i++){
            for(int j=0;j<list.length;j++){
                if(babbling[i].contains(list[j])){
                    babbling[i] = babbling[i].replaceAll(list[j], ".");
                }
            }
            babbling[i]= babbling[i].replace(".","");
            if(babbling[i]==""){
                answer++;
            }

        }
        return answer;
    }
}
