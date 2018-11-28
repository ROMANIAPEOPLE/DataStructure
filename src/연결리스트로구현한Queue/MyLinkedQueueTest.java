package 연결리스트로구현한Queue;

import java.util.NoSuchElementException;
import java.util.Scanner;

class MyLinkedQueue {

	private class Node {
		int data;
		Node link;
	}

	private Node front;
	private Node rear;
	private int count;

	public MyLinkedQueue() {
		front = null;
		rear = null;
		count = 0;
	}

	public boolean isEmpty() {
		return (front == null);
	}

	public void enQueue(int item) {
		Node t = new Node();
		t.data = item;

		if (isEmpty()) {
			front = t;
			rear = t;
		}

		else {
			rear.link = t;
			rear = t;
		}
		count++;
	}

	public int deQueue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		} else {
			int item = front.data;
			front = front.link;

			if (front == null) {
				rear = null;
			}
			count--;
			return item;
		}

	}

	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return front.data;
	}

	public int size() {
		return count;
	}

}

public class MyLinkedQueueTest {

	public static void main(String[] args) {

		System.out.println("hw8_2: 정기혁");
		MyLinkedQueue q = new MyLinkedQueue();
		Scanner input = new Scanner(System.in);

		System.out.println("메뉴 번호를 입력하세요.");
		int menu = 0;
		int item = 0;
		int index = 0;

		// 종료를 선택할 때까지 반복하여 메뉴를 제공하고 그에 맞는 작업을 수행
		do {
			System.out.print("1:삽입 2:삭제 3:조회 4:크기 5:전체삭제 6:종료--->");
			menu = input.nextInt();

			switch (menu) {
			case 1:
				System.out.print("정수 입력 : ");
				item = input.nextInt();
				q.enQueue(item);

				break;
			case 2:
				System.out.println(q.deQueue());
				break;
			case 3:
				System.out.println(q.peek());
				break;
			case 4:
				System.out.println(q.size());
				break;
			case 5:
				while (!q.isEmpty()) // 큐가 비어있는 상태일때까지 deQueue를 한다.
					System.out.println(q.deQueue());
				break;
			case 6:
				System.out.println("종료합니다.");

			default:
				System.out.println("메뉴 번호 오류: 메뉴를 다시 선택하세요.");
			}
		} while (menu != 6);

	}
}