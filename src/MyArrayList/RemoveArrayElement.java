package MyArrayList;

import java.util.Scanner;

public class RemoveArrayElement {

	public static void main(String[] args) {
		System.out.println("course3 : 홍길동 ");

		// 크기가 15인 배열 list에 길이가 numberOfElements인 선형 리스트를 생성함
		int[] list = { 3, -6, 11, -5, 22, 11, 0, 9, 7, 2, 0, 0, 0, 0, 0 };
		int numberOfElements = 10;

		// numberOfElements개의 원소를 갖는 리스트를 출력
		System.out.print("삭제 전 리스트 = ");
		printList(list, numberOfElements);

		// 삭제할 값(element)을 입력받음
		Scanner input = new Scanner(System.in);
		System.out.print("삭제할 값 입력: ");
		int element = input.nextInt();

		// (1) list에서 element를 삭제
		// 이때, 동일한 값이 여러개면 맨 앞의 원소를 삭제하고, 존재하지 않는 값인 경우 삭제 실패

		int index = 0;
		while (true) {
			if (index >= list.length) {
				System.out.println("초과");
				break;
			}

			else if (list[index] == element) {
				for (int i = index; i < numberOfElements - 1; i++) {
					list[i] = list[i + 1];
					index++;

				}
				System.out.println("삭제 완료");

				numberOfElements--;
				break;
			}

			index++;
		}
		// 삭제 결과인 numberOfElements개의 원소를 갖는 리스트를 출력
		System.out.print("삭제 후 리스트 = ");
		printList(list, numberOfElements);
	}

	// 배열 array에 저장된 numberOfElements 개의 원소를 출력
	// 배열의 길이와 저장된 원소수는 서로 다를 수 있음
	private static void printList(int[] array, int numberOfElements) {
		for (int i = 0; i < numberOfElements; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
