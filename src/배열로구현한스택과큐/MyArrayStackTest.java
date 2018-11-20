package �迭�α����ѽ��ð�ť;

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
		itemArray = new int[i]; //ũ�Ⱑ 5�� �迭 ����
		StackSize = 0; //���û���� 0���� �ʱ�ȭ
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
			throw new Exception("�迭�� ���� �����ϴ�.");
		}

		else {
			itemArray[++top] = item;
			StackSize++;
		}

	}

	public int pop() throws Exception {

		if (isEmpty() == true) {
			throw new Exception("�迭�� ����ֽ��ϴ�.");
		}

		else {
			StackSize--;
			return itemArray[top--];
		}
	}

	public int peek() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("�迭�� ����ֽ��ϴ�.");
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
			System.out.println(" 1:���� 2:���� 3:��ȸ 4:�հ� 5:����");

			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("1:����");
				System.out.println("������ ���� �Է� :");
				int item = sc.nextInt();
				stack.push(item);
				break;
			case 2:
				System.out.println("2:����");
				System.out.println("������ �� :" + stack.pop());
				break;
			case 3:
				System.out.println("3:��ȸ");
				System.out.println("peek :" + stack.peek());
				break;
			case 4:
				System.out.println("4:�հ�");
				int sum = 0;
				while (!stack.isEmpty()) {
					sum += stack.pop();
				}
				System.out.println("sum =" + sum);
				break;
			case 5:
				System.out.println("5:����");
				System.out.println("�����մϴ�");
				break;

			}

		} while (menu != 5);

	}
}
