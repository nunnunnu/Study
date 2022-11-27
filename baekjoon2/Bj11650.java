import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bj11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();
        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<String>(set);

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2){
                int a = str1.length();
                int b = str2.length();
                return a>b?1:(a==b)?str1.compareTo(str2):-1;
            }
        });
        for(String str : list){
            System.out.println(str);
        }
    }
}
