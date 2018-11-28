package 배열로구현한스택과큐;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

//***count(저장되어있는 수)를 이용하여 구현한 Queue
class MyCircularQueue {
	private int front; // 프론트 : 첫번째 원소의 바로 앞 인덱스를 가르킴
	private int rear; // 마지막 원소를 가르킴
	private int capacity; // 큐의 용량
	private int[] array;
	private int count; // 현재 큐에 저장된 원소의 수를 나타내는 변수

	public MyCircularQueue(int queueSize) {
		front = 0;
		count = 0;
		rear = 0;
		capacity = queueSize; // 큐의 용량 = 배열의 크기
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
			System.out.println("배열이 가득찻습니다.");
		}

		else {
			rear = ((rear + 1) % capacity);
			array[rear] = item;
			count++;
		}
	}

	public int deQueue() throws Exception {
		if (isEmpty()) {
			throw new Exception("큐가 비어있습니다. (삭제 불가능)");
		}

		front = ((front + 1) % capacity);
		count--;
		return array[front]; // 삭제된 값을 리턴
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
		System.out.println("hw8_1:정기혁");
		MyCircularQueue q = new MyCircularQueue(5);
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