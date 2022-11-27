package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class recursion2 {

	public static int length(String str) {//문자열 길이 계산
		if(str.equals("")) return 0;
		else return 1+length(str.substring(1));
	}
	public static void printChars(String str) { //문자열 출력하기
		if(str.length()==0) return ;
		else {
			System.out.print(str.charAt(0));
			printChars(str.substring(1));
		}
	}
	public static void printCharsReverse(String str) { //문자열 뒤집기
		if(str.length()==0) return ;
		else {
			printCharsReverse(str.substring(1));
			System.out.print(str.charAt(0));
		}
	}
	public static void printBinary(int n) { //2진수 변환
		if(n<2) System.out.print(n);
		else {
			printBinary(n/2); 
			System.out.print(n%2);
		}
	}
	//배열 합 구하기
	public static int sum(int n, int data[]) {
		if(n<=0) return 0;
		else return sum(n-1,data) + data[n-1];
	}
	//데이터파일로부터 n개의 정수 읽어오기
	public static void readFrom(int n, int data[], Scanner in) {
		if(n==0) return;
		else {
			readFrom(n-1,data,in);
			data[n-1]=in.nextInt();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(length("abc123"));
		printChars("asv");
		System.out.println();
		printCharsReverse("abcd");
		System.out.println();
		printBinary(10);
		System.out.println();
		int data[] = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(sum(10,data));
		int data2[] = new int[10];
		Scanner in  = new Scanner(System.in);
		readFrom(10,data2,in);
		System.out.println(Arrays.toString(data2));
	}

}
