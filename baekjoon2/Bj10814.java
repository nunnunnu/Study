import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class member{
    int age;
    String name;

    public member(int age, String name){
        this.age = age;
        this.name = name;
    }
}

public class Bj10814 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        member[] m = new member[n];
        
        for(int i=0;i<n;i++){
            int age= Integer.parseInt(s.next());
            String name = s.next();
            m[i] = new member(age, name);
        }
        Arrays.sort(m, new Comparator<member>() {
            @Override
            public int compare(member m1, member m2){
                return m1.age-m2.age;
            }
        });
        for(member mem : m){
            System.out.println(mem.age+" "+mem.name);
        }
    }
    
}
