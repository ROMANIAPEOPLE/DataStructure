package Stack특수문자검사;
import java.util.Scanner;
import java.util.Stack;

public class MyCharacterStackTest_2 {

	public static void main(String[] args) {
		System.out.println("hw7_3 : 정기혁");
		Stack<Character> s = new Stack<Character>();
		Scanner sc = new Scanner(System.in);

		System.out.print("수식입력 :");
		String c = sc.nextLine();
		boolean result = false;
		int i;
		for (i = 0; i < c.length(); i++) {
			char ch = c.charAt(i); //charAt메소드를 이용하여 문자열을 하나씩 리턴함
			result = true;

			switch (ch) { //switch문을 사용하여 문자열을 검사
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

			default:  //문자열이 없는 문장을 true로 초기화하여 올바른 괄호 수식임을 증명함
				result = true;
				break;
			}

		}

		if (s.isEmpty() &&  result == true) {
			System.out.println("올바른 괄호 수식 입니다.");
		} else {
			System.out.println("잘못된 괄호 수식 입니다.");
		}
	}

}
