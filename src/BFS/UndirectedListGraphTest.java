package BFS;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

class UndirectedListGraph {
	private class Node {
		int vertex; // 정점 필드
		Node link; // 다음 노드

		Node(int vertex) {
			this.vertex = vertex;
		}
	}

	private Node[] list;
	private int n;
	private boolean[] visited;

	public UndirectedListGraph(int n) {
		this.n = n;
		list = new Node[n];
		visited = new boolean[n];
	}

	public boolean hasEdge(int v1, int v2) { // v1과 v2가 존재하는지 (중복검사)
		Node temp = list[v1];
		while (temp != null) {
			if (temp.vertex == v2) { // head.data 와 item 이 같으면
				return true;
			}
			temp = temp.link;
		}

		return false;
	}

	public void addEdge(int v1, int v2) {
		Node t = new Node(v2);
		Node t2 = new Node(v1);
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) { // v1,v2가 정점을 벗어난 숫자일 경우, 음수일 경우
			System.out.println("잘못된 정점 번호입니다.");
		} else if (hasEdge(v1, v2)) {
			System.out.println("이미 존재하는 간선입니다.");
		} else {
			// list[v1] 이 가르키는 단순연결리스트의 맨 앞에 v2 삽입
			// list[v2] 이 가르키는 단순 연결리스트의 맨 앞에 v1 삽입

			if (list[v1] == null && list[v2] == null) {
				list[v1] = t;
				list[v2] = t2;
			} else if (list[v1] != null) { // list[v1] !=null
				t.link = list[v1];
				list[v1] = t;

				t2.link = list[v2];
				list[v2] = t2;
			}
		}

	}

	public void breadthFirstSearch(int v) {
		if (v < 0 || v >= n) {
			System.out.println("잘못된 정점 번호 입니다.");
		} else {
			for (int i = 0; i < n; i++) {
				visited[i] = false;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(v); // enQueue(시작정점의 값)
			visited[v] = true; // 방문한 시작정점의 값을 true로 초기화
			System.out.print("시작정점 " + v + "의 너비 우선탐색 = " + v + "");

			while (!q.isEmpty()) {
				v = q.remove();

				{
					Node temp = list[v];
					while (temp != null) {
						if (visited[temp.vertex] == false) {
							visited[temp.vertex] = true;
							System.out.print(" " + temp.vertex);
							q.offer(temp.vertex);
						} else
							temp = temp.link;
					}
				}
			}
			System.out.println();
		}
	}

	public void printAdjacentVertices(int v) {

		if (v < 0 || v >= n) {
			System.out.println("잘못된 정점 입니다.");
		} else {
			Node tmp = list[v];
			while (tmp != null) {
				System.out.print(tmp.vertex + " ");
				tmp = tmp.link;
			}
			System.out.println();
		}

	}

}

public class UndirectedListGraphTest {
	public static void main(String[] args) {
		System.out.println("hw10_2 : 정기혁");

		// 정점 수 n 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정점 수 입력: ");
		int n = scan.nextInt();

		// 정점 수가 n인 무방향 그래프를 생성
		UndirectedListGraph graph = new UndirectedListGraph(n);

		// 간선 수 e 입력
		System.out.print("간선 수 입력: ");
		int e = scan.nextInt();

		// e개의 간선(정점 쌍)을 입력받아 그래프에 삽입
		System.out.println(e + "개의 간선을 입력하세요(각 간선은 정점 번호 2개를 whitespace로 구분하여 입력):");
		for (int i = 0; i < e; i++) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			graph.addEdge(v1, v2);
		}

		// 각 정점의 인접 정점들을 출력
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("정점 " + i + "에 인접한 정점 = ");
			graph.printAdjacentVertices(i);
		}

		System.out.println();
		for (int i = 0; i < n; i++)
			graph.breadthFirstSearch(i);

	}
}
