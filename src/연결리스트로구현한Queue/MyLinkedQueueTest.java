package ���Ḯ��Ʈ�α�����Queue;

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

		System.out.println("hw8_2: ������");
		MyLinkedQueue q = new MyLinkedQueue();
		Scanner input = new Scanner(System.in);

		System.out.println("�޴� ��ȣ�� �Է��ϼ���.");
		int menu = 0;
		int item = 0;
		int index = 0;

		// ���Ḧ ������ ������ �ݺ��Ͽ� �޴��� �����ϰ� �׿� �´� �۾��� ����
		do {
			System.out.print("1:���� 2:���� 3:��ȸ 4:ũ�� 5:��ü���� 6:����--->");
			menu = input.nextInt();

			switch (menu) {
			case 1:
				System.out.print("���� �Է� : ");
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
				while (!q.isEmpty()) // ť�� ����ִ� �����϶����� deQueue�� �Ѵ�.
					System.out.println(q.deQueue());
				break;
			case 6:
				System.out.println("�����մϴ�.");

			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while (menu != 6);

	}
}