package �迭�α����ѽ��ð�ť;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

//***count(����Ǿ��ִ� ��)�� �̿��Ͽ� ������ Queue
class MyCircularQueue {
	private int front; // ����Ʈ : ù��° ������ �ٷ� �� �ε����� ����Ŵ
	private int rear; // ������ ���Ҹ� ����Ŵ
	private int capacity; // ť�� �뷮
	private int[] array;
	private int count; // ���� ť�� ����� ������ ���� ��Ÿ���� ����

	public MyCircularQueue(int queueSize) {
		front = 0;
		count = 0;
		rear = 0;
		capacity = queueSize; // ť�� �뷮 = �迭�� ũ��
		array = new int[queueSize];
	}

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return (count == capacity);
	}

	public void enQueue(int item) {
		if (isFull()) {
			System.out.println("�迭�� ���������ϴ�.");
		}

		else {
			rear = ((rear + 1) % capacity);
			array[rear] = item;
			count++;
		}
	}

	public int deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("ť�� ����ֽ��ϴ�. (���� �Ұ���)");
		}

		front = ((front + 1) % capacity);
		count--;
		return array[front]; // ������ ���� ����
	}

	public int peek() {
		if (isEmpty())
			throw new NoSuchElementException();
		return array[(front + 1) % capacity];
	}
	
	public int size() {
		return count;
	}

//	@Override
//	public String toString() {
//		return Arrays.toString(array);
//
//	}
}

public class MyCircularQueueTest {

	public static void main(String[] args) throws Exception {
		System.out.println("hw8_1:������");
		MyCircularQueue q = new MyCircularQueue(5);
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