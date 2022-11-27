package algorithm;

public class recursion3 {
	
	public static int Fsearch(int data[], int begin, int end, int target) { //처음부터 찾기
		if(begin>end) return -1;
		else if(target==data[begin]) return begin;
		else return Fsearch(data, begin,end-1,target);
	}
	public static int Esearch(int data[], int begin, int end, int target) {//끝부터 찾기
		if(begin>end) return -1;
		else {
			int middle = (begin+end)/2;
			if(data[middle] == target) return middle;
			int index=Esearch(data,begin,middle-1,target);
			if(index!=-1) return index; //찾았을경우
			else return Esearch(data,middle+1,end,target);
		}
	}
	
	//최대값 찾기(처음부터)
	public static int Ffindmax(int data[], int begin, int end) {
		if(begin==end) return data[begin];
		else return Math.max(data[begin], Ffindmax(data,begin+1,end));
	}
	//최대값 반 잘라서 찾기
	public static int Mfindmax(int data[], int begin, int end) {
		if(begin==end) 
			return data[begin];
		else {
			int middle = (begin+end)/2;
			int max1=Mfindmax(data,begin,middle);
			int max2=Mfindmax(data,middle+1,end);
			return Math.max(max1, max2);
		}
	}
	//이진검색
	public static int binarySearch(String items[], String target, int begin, int end) {
		if(begin>end) return -1;
		else {
			int middle = (begin+end)/2;
			int compResult = target.compareTo(items[middle]); //맨 중간값을 비교
			if(compResult==0) return middle; 
			else if(compResult<0) return binarySearch(items, target,begin,middle-1); //중간 값이 target보다 작을 경우, 앞쪽에서 찾기
			else return binarySearch(items, target,middle+1,end);//중간값이 target보다 클 경우, 뒤쪽에서 찾기
		}
	}

	public static void main(String[] args) {
		int data[] = {1,2,3,4,5};
		System.out.println(Fsearch(data,1,4,2));
		System.out.println(Esearch(data,1,4,2));
		int data2[] = {1,6,4,5,7};
		System.out.println(Ffindmax(data2,0,4));
		System.out.println(Mfindmax(data2,0,4));
		String data3[] = {"aaa","bbb","ccc","ddd","eee"};
		System.out.println(binarySearch(data3,"ccc",0,data3.length));

	}

}
