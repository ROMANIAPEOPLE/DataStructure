package 배열로구현한스택과큐;

import java.util.NoSuchElementException;

//MyArrayQueue 클래스를 테스트하는 클래스
public class MyArrayQueueTest {
	public static void main(String[] args) {
		System.out.println("course7: 정기혁");

// MyArrayQueue 객체를 생성하고, 삽입, 삭제 연산을 수행
		MyArrayQueue queue = new MyArrayQueue();

		queue.enQueue(1);
		queue.enQueue(2);

		System.out.println(queue.deQueue()); // 출력: 1
		System.out.println(queue.deQueue()); // 출력: 2

		queue.enQueue(3);
		queue.enQueue(4);

		System.out.println(queue.deQueue()); // 출력: 3
		System.out.println(queue.deQueue()); // 출력: 4

		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.enQueue(8);
		queue.enQueue(9); // 삽입 실패하여 오류 메시지 출력할 것임
		queue.enQueue(10); // 삽입 실패하여 오류 메시지 출력할 것임

		while (!queue.isEmpty())
			System.out.print(queue.deQueue() + " "); // 출력: 5 6 7 8
		System.out.println();

		System.out.println(queue.deQueue()); // 삭제 실패하여 예외발생할 것임

		System.out.println("실행하지 않을 문장임");
	}
}

//크기가 5인 배열로 원형 큐를 구현한 클래스 - 최대 4개의 원소를 저장할 수 있음
class MyArrayQueue {
// (1) private 인스턴스 변수 선언: 배열(array), 배열 크기(arraySize), front, rear
	private int arraySize;
	private int [] array = new int[5];
	private int front;
	private int rear;
	

// (2) 생성자 : 크기가 5인 배열로 큐를 구현하도록 인스턴스 변수들을 초기화
	public MyArrayQueue() {
		this.arraySize=5;
		this.front=-1;
		this.rear=-1;
	}

// 큐가 비어있는지를 검사
	public boolean isEmpty() {
		return rear == front;
	}

// 큐가 가득찼는지를 검사
	public boolean isFull() {
		return (rear + 1) % arraySize == front;
	}

// (3) 큐에 data를 삽입
	public void enQueue(int data) {
		if (isFull())
			System.out.println("큐가 가득차서 삽입 실패: "
					+ "" + data);
		else {

			rear= (rear+1) % arraySize;
			array[rear]=data;
			
		}
	}

// (4) 큐에서 원소를 하나 삭제하여 리턴
	public int deQueue() {
		if (isEmpty())
			throw new NoSuchElementException();

		else {
			front= (front+1) % arraySize;
			int item = array[front];
			return item;
			
		}
	}
}
