package algorithm;

public class powerSet {
	
	private static char data[] = {'a','b','c','d','e','f'};
	private static int n = data.length;
	private static boolean includ[] = new boolean[n]; //트리상 나의 위치
	
	public static void powerSet(int k) {
		if(k==n) { //내 위치가 리프노드(마지막 노드)라면?출력하지 않고 끝냄
			for(int i=0;i<n;i++) {
				if(includ[i]) //includ[i]가 true일 경우
					System.out.print(data[i]+", ");
			}
			System.out.println();
			return;
		}
		includ[k]=false; //data[k]를 포함하지 x = exclud. 상태공간트리에서 왼쪽으로
		powerSet(k+1);
		includ[k]=true; //data[k]를 포함 = includ. 상태공간트리에서 오른쪽으로
		powerSet(k+1);
	}

	public static void main(String[] args) {
//		6 4 8 16 32 64
		powerSet(0);

	}

}
