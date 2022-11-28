package algorithm;


public class SelectionSort {
    public static void main(String[] args) {
        int[] a= {2,5,3,0,2,3,0,3};
        // selectionSort(a, a.length-1);
        // bubblesort(a, a.length);
        // insertsort(a, a.length);
        // merge(a, 0, a.length/2 , a.length-1);
        // quicksort(a,0,a.length-1);
        // heapsort(a);
        // max_heap_insert(a, 5);
        countingsort(a, 6);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
    public static void selectionSort(int a[],int n) {
        while(n>0){
            int max = 0;
            int idx = 0;
            for(int i=n;i>=0;i--){
                if(a[i]>max){
                    max = a[i];
                    idx = i;
                }
            }
            int tmp = a[n];
            a[n] = max;
            a[idx] = tmp;
            n--;
        }
    }
    public static void bubblesort(int[] a, int n) {
        while(n>=0){
            for(int i=0;i<n-1;i++){
                if(a[i]>a[i+1]){
                    int tmp = a[i];
                a[i] = a[i+1];
                a[i+1] = tmp;
                }
            }
        n--;
        }
    }
    public static void insertsort(int[] a, int n) {
        for(int i=1;i<n;i++){
            int temp = a[i];
            int j=i-1;
            while(j>=0 && temp<a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
    //p-시작, q-중간, r-끝(length-1)
    public static void merge(int[] a, int p, int q, int r) {
        int i=p, j=q+1,k=p;
        int[] tmp = new int[a.length];
        while(i<=q && j<=r){
            if(a[i]<=a[j]){
                tmp[k++] = a[i++];
            }else {
                tmp[k++] = a[j++];
            }
        } 
        // 앞배열에 남은 값이 있다면 복사
        while(i<=q){
            tmp[k++] = a[i++];
        }
        //뒷배열에 남은 값이 있다면
        while(j<=r){
            tmp[k++] = a[j++];
        }
        for(i=p;i<=r;i++){
            a[i] = tmp[i];
        }
    }
    //p-시작, r-끝
    public static void quicksort(int[] a, int p,int r) {
        if(p<r){
            int q = partition(a, p, r); //pivot의 위치
            quicksort(a,p,q-1); //왼쪽 배열 정렬
            quicksort(a, q+1, r); //오른쪽 배열 정렬
        }
    }
    public static int partition(int[] a, int p, int r) {
        int i=p-1;
        int pivot = a[r];
        for(int j=p;j<r;j++){
            if(a[j]<=pivot){
                i++;
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
        i++;
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        return i;
    }

    public static void heapify (int[] a, int s, int l) {
        int leftchild = 2*s+1; //0으로 시작해서 1 더해줌
        int rightchild = 2*s+2; //0으로 시작해서 2 더해줌
        int large = s; // 부모노드

        //왼자식노드 인덱스가 최대값보다 작고 부모노드가 더 작으면 
        if(leftchild < l && a[large]<a[leftchild]){
            large = leftchild;
        } //부, 자 인덱스 변경
        //오자식노드인덱스가 최대값보다 작고 부모노드가 더 작으면
        if(rightchild<l && a[large]<a[rightchild]){
            large = rightchild;
        }
        //매개변수의 부모노드값과 if문을 거친 부모도느 값이 달라졌다면 자리 교체
        if(large!=s){
            int tmp = a[s];
            a[s] = a[large];
            a[large] = tmp;
            heapify(a, large, l);
        }
        
    }
    public static void heapsort(int[] a) {
        int size = a.length-1;

        if(size<2){
            return;
        }
        //가장 마지막 노드의 부모 인덱스 번호
        int parent = (size-1)/2;

        //max heap 만들기
        for(int i=parent;i>=0;i--){
            heapify(a, i, size);
        }

        //정렬
        for(int i=size;i>0;i--){
            //0번째와 i번째 인덱스 값을 교환해 max heap을 만든다
            int tmp = a[0];
            a[0]=a[i];
            a[i]=tmp;
            heapify(a, 0, i-1); //교환한 마지막 값 제외 heap생성
        }
    }
    public static void  max_heap_insert(int[] a, int key) {
        size = a.length;
        a[size] = key;
        int i=size;
        int parent = (i-1)/2;
        while(i>1 && a[parent]<a[i]){
            int tmp = a[i];
            a[i] = a[parent];
            a[parent] = tmp;
            i=parent;
        }
    }
    public static void countingsort(int[] a,int k) {
        int[] c = new int[k];
        int[] result = new int[a.length];

        for(int i=0;i<a.length;i++){
            c[a[i]]++;
        }
        for(int i=1;i<c.length;i++){
            c[i] += c[i-1];
        }
        for(int i=a.length-1;i>=0;i--){
            int num = a[i];
            int idx = c[num]-1;
            result[idx] = num;
            c[num]--;
        }
        
        for(int i=0;i<result.length;i++){
            a[i] = result[i];
        }
    }
}
