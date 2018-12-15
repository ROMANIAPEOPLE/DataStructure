package 이진검색알고릐즘;

//재귀사용
//실행안됨(오류)

class Binary {
	
	public static int Search(int [] a, int low, int high, int key) {
		if(low > high) {
			return -1;   //탐색 실패
		}
		else {
			int middle = (low+high)/2;
			if(key == a[middle]) {
				return middle;
			}
			
			else if(key <a[middle]) {
				return Search(a,low,middle,key);
			}
			else
				return Search(a,middle+1,high,key);
		}
		
	}
}

public class BinarySearch {

	
	
	
	
	public static void main(String[] args) {

		int [] a =  {2 , 4 , 1 , 3, 5, 7 , 6 ,9 ,8,10};
		
		Binary.Search(a, 0, a.length-1, 7);
		
		
		
		
	}

}
