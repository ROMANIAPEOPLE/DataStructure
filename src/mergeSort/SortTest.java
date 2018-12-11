package mergeSort;

import java.util.Scanner;

class MyIntegerSort {

	public static void mergeSort(int[] a) {

		mergeSort(a, 0, a.length - 1);
	}

	public static void mergeSort(int[] a, int lb, int ub) {
		int mid;
		if (lb < ub) {
			mid = (lb + ub) / 2;
			mergeSort(a, lb, mid);
			mergeSort(a, mid + 1, ub);
			merge(a, lb, mid, ub);

		}
	}

	public static void merge(int[] a, int lb, int mid, int ub) {
		int l = lb;
		int m = mid + 1;
		int k = lb;
		int[] temp = new int[a.length];
		while (l <= mid || m <= ub) {
			if (l <= mid && m <= ub) {
				if (a[l] <= a[m]) {
					temp[k] = a[l++];
				} else {
					temp[k] = a[m++];
				}
			} else if (l <= mid && m > ub) {
				temp[k] = a[l++];
			} else {
				temp[k] = a[m++];
			}
			k++;
		}
		for (int i = lb; i < ub + 1; i++) {
			a[i] = temp[i];
		}
	}
}

public class SortTest {

	public static void main(String[] args) {
		
		System.out.println("hw11_1 : 정기혁");
		Scanner sc = new Scanner(System.in);

		System.out.print("정수 값 n개 입력 :");
		int n = sc.nextInt();
		int[] arr = new int[n];

		System.out.print(n + "개의 정수 입력 : ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.print("정렬 전 배열 = ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		MyIntegerSort.mergeSort(arr);
		
		System.out.println();
		System.out.print("정렬 후 배열 = ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
