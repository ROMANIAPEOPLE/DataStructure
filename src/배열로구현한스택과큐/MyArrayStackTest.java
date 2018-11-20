package 배열로구현한스택과큐;

import java.util.Scanner;

class MyArrayStack {
	private int top=-1;
	private int[] itemArray;
	private int StackSize;

	public MyArrayStack() {
		itemArray = new int[5];
		StackSize = 0;
	}

	public MyArrayStack(int i) {
		itemArray = new int[i]; //크기가 5인 배열 생성
		StackSize = 0; //스택사이즈를 0으로 초기화
	}

	public boolean isEmpty() {
		if (StackSize <= 0) {
			return true;
		}

		return false;
	}

	public boolean isFull() {
		if (StackSize == itemArray.length) {
			return true;
		}

		return false;
	}

	public void push(int item) throws Exception {
		if (isFull()== true) {
			throw new Exception("배열이 가득 찻습니다.");
		}

		else {
			itemArray[++top] = item;
			StackSize++;
		}

	}

	public int pop() throws Exception {

		if (isEmpty() == true) {
			throw new Exception("배열이 비어있습니다.");
		}

		else {
			StackSize--;
			return itemArray[top--];
		}
	}

	public int peek() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("배열이 비어있습니다.");
		}

		else {
			return itemArray[top];
		}
	}
}

public class MyArrayStackTest {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		MyArrayStack stack = new MyArrayStack(5);

		int menu = 0;
		do {
			System.out.println(" 1:삽입 2:삭제 3:조회 4:합계 5:종료");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1:삽입");
				System.out.println("삽입할 정수 입력 :");
				int item = sc.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println("2:삭제");
				System.out.println("삭제된 값 :" + stack.pop());
				break;
			case 3:
				System.out.println("3:조회");
				System.out.println("peek :" + stack.peek());
				break;
			case 4:
				System.out.println("4:합계");
				int sum = 0;
				while (!stack.isEmpty()) {
					sum += stack.pop();
				}
				System.out.println("sum =" + sum);
				break;
			case 5:
				System.out.println("5:종료");
				System.out.println("종료합니다");
				break;

			}

		} while (menu != 5);

	}
}
