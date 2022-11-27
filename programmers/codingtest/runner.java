public class runner {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant,completion));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        for(int i=0;i<participant.length;i++){
            boolean check=true;
            for(int j=0;j<completion.length;j++){
                if(participant[i].equals(completion[j])){
                    check=false;
                    completion[j]="";
                }
            }
            if(check){
                answer = participant[i];
            }
        }
        return answer;
    }
}

