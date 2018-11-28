package MyArrayList;
/* 이름 : 정기혁
 * 작성일 : 2018-09-18
 * 과제코드 hw5_1
 */
import java.util.Arrays;
import java.util.Scanner;

class MyArrayList {

	private int[] array;
	private int number;

	public MyArrayList() {
		array = new int[10]; // 크기가 10인 배열 array
		number = 0; // 현재 배열에 저장된 항목수는 0
	}

	public boolean add(int a) {// add메소드
//** 옵션2: 내부 정수 배열이 가득찬 경우 false 리턴하는 대신, 정수 배열을 2배로 확장하도록 해 볼 것
		if (number == array.length) {
			System.out.println("**배열의 크기가 2배로 증가했습니다.**");
			int[] copy = new int[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				copy[i] = array[i];
			}
			array = copy;
			array[number] = a;
			number++;
		} else {
			array[number] = a;
			number++;
		}
		return true;
	}

	// ** 옵션4: toString() 에서 String 대신 StringBuffer를 이용하여 구현해 볼 것
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("[");
		for (int i = 0; i < number; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append(array[i]);
		}
		s.append("]");
		return s.toString();

	}

	// get - 인덱스를 매개변수로 받아 배열의 해당 정수값을 리턴 O(1)

	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= number)
			throw new IndexOutOfBoundsException();
		return array[index];

	}

	// size - 리스트의 길이를 리턴(배열 크기가 아님) O(1)
	public int size() {
		return number;
	}

	// add - 인덱스와 정수값을 매개변수로 받아 배열의 해당 위치에 정수값을 삽입 O(n)
	public int add(int index, int element) throws IndexOutOfBoundsException {
		if (index >= number) {
			throw new IndexOutOfBoundsException();
		}
		int y = number;
		for (int i = index; i < number; i++) {
			array[y] = array[y - 1];
			y--;
		}

		number++;
		return array[index] = element;
	}

	// remove - 인덱스를 매개변수로 받아 배열의 해당 위치 정수값을 삭제하고 그 값을 리턴 O(n)
	public int remove(int index) throws IndexOutOfBoundsException {
		if (index >= number) {
			throw new IndexOutOfBoundsException();
		}
		int z = array[index];
		for (int i = index; i < number - 1; i++) {
			array[i] = array[i + 1];
			index++;
		}
		number--;
		return z;
	}
}

public class MyArrayListTest {

	public static void main(String[] args) throws Exception {

		System.out.println("hw5_1: 정기혁");

		MyArrayList list = new MyArrayList();

		Scanner input = new Scanner(System.in);
		int menu = 0;
		int index = 0;
		int element = 0;

		do {
			System.out.print(" 1:인덱스조회 2:전체조회 3:길이조회 4:삽입 5:인덱스삽입 6:인덱스삭제 7:종료 ---> ");
			menu = input.nextInt();

			switch (menu) {
			case 1:
				System.out.println("인덱스 위치의 원소값을 조회합니다.");
				System.out.print("인덱스 입력: ");
				index = input.nextInt();
				element = list.get(index); // 완성하세요.
				System.out.println(element);
				break;
			case 2:
				System.out.println("리스트 전체를 조회합니다.");
				System.out.println(list); // 완성하세요.
				break;
			case 3:
				System.out.println("리스트 길이를 조회합니다.");
				int size = list.size(); // 완성하세요.
				System.out.println(size);
				break;
			case 4:
				System.out.println("원소를 리스트의 맨 뒤에 삽입합니다.");
				System.out.print("정수값 입력: ");
				element = input.nextInt();
				list.add(element);

				break;
			case 5:
				System.out.println("인덱스 위치에 원소를 삽입합니다.");
				System.out.print("인덱스 입력: ");
				index = input.nextInt();
				System.out.print("정수값 입력: ");
				element = input.nextInt();

				list.add(index, element); // 완성하세요
				break;
			case 6:
				System.out.println("인덱스 위치의 원소를 삭제합니다.");
				System.out.print("인덱스 입력: ");
				index = input.nextInt();
				element = list.remove(index); // 완성하세요.
				System.out.println(element);
				break;
			case 7:
				System.out.println("종료합니다.");
				break;
			default:
				System.out.println("메뉴 선택 오류: 다시 선택하세요.");
			}
		} while (menu != 7);
	}
}
