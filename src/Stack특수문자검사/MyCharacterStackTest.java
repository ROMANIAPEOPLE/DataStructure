package Stack특수문자검사;

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

		System.out.println("hw7_3 : 정기혁");
		MyCharacterStack s = new MyCharacterStack();
		Scanner sc = new Scanner(System.in);
		boolean result = false;
		System.out.print("수식입력");
		String c = sc.nextLine();
		int i;
		for (i = 0; i < c.length(); i++) {
			char ch = c.charAt(i); // charAt메소드를 이용하여 문자열을 하나씩 리턴함
			result = true;

			switch (ch) { // switch문을 사용하여 문자열을 검사
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
			System.out.println("올바른 괄호 수식 입니다.");
		} else {
			System.out.println("잘못된 괄호 수식 입니다.");
		}
	}

}
