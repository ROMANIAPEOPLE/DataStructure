package StackƯ�����ڰ˻�;
import java.util.Scanner;
import java.util.Stack;

public class MyCharacterStackTest_2 {

	public static void main(String[] args) {
		System.out.println("hw7_3 : ������");
		Stack<Character> s = new Stack<Character>();
		Scanner sc = new Scanner(System.in);

		System.out.print("�����Է� :");
		String c = sc.nextLine();
		boolean result = false;
		int i;
		for (i = 0; i < c.length(); i++) {
			char ch = c.charAt(i); //charAt�޼ҵ带 �̿��Ͽ� ���ڿ��� �ϳ��� ������
			result = true;

			switch (ch) { //switch���� ����Ͽ� ���ڿ��� �˻�
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

			default:  //���ڿ��� ���� ������ true�� �ʱ�ȭ�Ͽ� �ùٸ� ��ȣ �������� ������
				result = true;
				break;
			}

		}

		if (s.isEmpty() &&  result == true) {
			System.out.println("�ùٸ� ��ȣ ���� �Դϴ�.");
		} else {
			System.out.println("�߸��� ��ȣ ���� �Դϴ�.");
		}
	}

}
