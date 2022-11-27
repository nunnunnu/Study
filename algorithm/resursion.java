package algorithm;

public class resursion {
	
	public static int func(int n) { //n~0까지의 합
		if(n<=0)
			return 0;
		else 
			return n+func(n-1);
	}
	public static int factorial(int n) { //팩토리얼
		if(n==0)
			return 1; //0!은 1이기 때문
		else 
			return n*factorial(n-1);
	}
	public static double power(double x,int n) {//x의 n승
		if(n==0)
			return 1; 
		else 
			return x*power(x,n-1);
	}
	public static double fibonacci(int n) { //피보나치
		if(n<2)
			return 1; 
		else 
			return fibonacci(n-1) + fibonacci(n-2);
	}
	public static int gcd(int p, int q) { //최대공약수
		if(q==0)
			return p;
		else return gcd(q,p%q);
	}

	public static void main(String[] args) {
		System.out.println(func(4)); 
		System.out.println(factorial(4));
		System.out.println(power(4,3));
		System.out.println(fibonacci(4));
		System.out.println(gcd(30,20));
	}

}
