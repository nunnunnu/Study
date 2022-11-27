package algorithm;

public class queens {
	static int n=8;
	static int cols[] = new int[n+1]; //전역변수(함수의 외부에서 선언된 변수). cols[1]=2 는 (1,2)을 뜻함. 
	
	static boolean queens(int level) {
		if(!promising(level)) return false; //꽝이면 밑까지 가볼필요없음
		else if(level==n) { //답일 경우
			for(int i=1;i<=n;i++) {
				System.out.println("("+i+", "+cols[i]+")");
			}
			return true;
		}
		//꽝도아니고 답도 아니라면 그 밑까지 가보고 답인지 판단함.
		for(int i=1;i<=n;i++) {
			cols[level+1]=i; //level+1번 말을 1~n번째 칸 중 어디에 놓을 것인지 결정.
			if(queens(level+1)) return true;
		}
		return false;
	}
	
	static boolean promising(int level) {
		for(int i=1;i<level;i++) {
			if(cols[i]==cols[level]) return false; //i행에 놓인 말과 level행에 놓인 말의 열이 같을 경우
			else if(level-i == Math.abs(cols[i]-cols[level])) return false; //i행에 놓은 말과 level행에 놓인 말이 같은 대각선상에 있을경우
		}
		return true;
	}

	public static void main(String[] args) {
		queens(0);

	}

}
