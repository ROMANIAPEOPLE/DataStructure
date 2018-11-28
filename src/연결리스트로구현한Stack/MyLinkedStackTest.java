package ���Ḯ��Ʈ�α�����Stack;

import java.util.Scanner;

class MyLinkedStack {
	private class Node {
		int data;
		Node link;
	}

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}

	public int push(int item) {

		Node t = new Node();
		t.data = item;
		t.link = top;
		top = t;
		return item;
	}

	public int pop() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("������ ����ֽ��ϴ�.");
		} else {
			int item = top.data;
			top = top.link;
			return item;
		}
	}

	public int peek() throws Exception {
		if (isEmpty() == true) {
			throw new Exception("������ ����ֽ��ϴ�.");
		}

		else {
			return top.data;

		}
	}

}

public class MyLinkedStackTest {

	public static void main(String[] args) throws Exception {
		System.out.println("hw7_2 : ������");
		Scanner sc = new Scanner(System.in);

		MyLinkedStack stack = new MyLinkedStack();

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
				System.out.println(stack.pop());
				break;
			case 3:
				System.out.println("3:��ȸ");
				System.out.println(stack.peek());
				break;
			case 4:
				System.out.println("4:�հ�");
				int sum=0;
				while(!stack.isEmpty()) {
					sum+= stack.pop();
				}
				System.out.println("sum =" + sum );
				break;
			case 5:
				System.out.println("5:����");
				System.out.println("�����մϴ�");
				break;

			}

		} while (menu != 5);

	}
}
