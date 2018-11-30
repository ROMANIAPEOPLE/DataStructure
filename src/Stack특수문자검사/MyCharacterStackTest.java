package StackƯ�����ڰ˻�;

import java.util.EmptyStackException;
import java.util.Scanner;

class MyCharacterStack {
	private class Node {
		char data;
		Node link;

		Node(char data) {
			this.data = data;
		}
	}

	private Node top;

	public boolean isEmpty() {
		return (top == null);
	}

	public void push(char item) {
		Node node = new Node(item);
		node.link = top;
		top = node;
	}

	public char pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}

	public char peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else
			return top.data;
	}
}

public class MyCharacterStackTest {

	public static void main(String[] args) {

		System.out.println("hw7_3 : ������");
		MyCharacterStack s = new MyCharacterStack();
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		System.out.print("�����Է�");
		String c = sc.nextLine();
		int i;
		for (i = 0; i < c.length(); i++) {
			char ch = c.charAt(i); // charAt�޼ҵ带 �̿��Ͽ� ���ڿ��� �ϳ��� ������
			result = true;

			switch (ch) { // switch���� ����Ͽ� ���ڿ��� �˻�
			case '(':
				s.push(ch);
				break;
			case '<':
				s.push(ch);
				break;
			case ')':
				if (s.isEmpty() || s.peek() != '(') {
					result = false;
					break;
				}

				else {
					s.pop();
					break;
				}
			case '>':
				if (s.isEmpty() || s.peek() != '<') {
					result = false;
					break;
				}

				else {
					s.pop();
					break;
				}
			}

		}

		if (s.isEmpty() && result == true) {
			System.out.println("�ùٸ� ��ȣ ���� �Դϴ�.");
		} else {
			System.out.println("�߸��� ��ȣ ���� �Դϴ�.");
		}
	}

}
