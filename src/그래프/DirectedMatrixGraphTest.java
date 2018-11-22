package 그래프;

import java.util.Scanner;

/*
 * 파일명: DirectedListGraphTest.java
 * 작성일: 2018.11.22
 * 작성자: 정기혁
* 설명: 방향 그래프를 생성하고 이용하는 프로그램
*/
class DirectedMatrixGraph {
	public class Node {
		int vertex;
		Node link;

		public Node(int vertex) {
			this.vertex = vertex;
		}
	}

	private Node[] list;
	private int n;

	public DirectedMatrixGraph(int n) {
		this.n = n;
		list = new Node[n];
	}

	public boolean hasEdge(int v1, int v2) {
		Node temp = list[v1];
		while (temp != null) {
			if (temp.vertex == v2) {
				return true;
			} else
				temp = temp.link;
		}

		return false;
	}

	public void addEdge(int v1, int v2) {
		if (hasEdge(v1, v2)) {
			System.out.println("간선 삽입 오류 - 이미 존재하는 간선입니다" + "<" + v1 + ',' + v2 + ">");
		} else if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
			System.out.println("간선 삽입 오류 - 잘못된 정점 번호입니다." + "<" + v1 + ',' + v2 + ">");
		} else {

			Node t = new Node(v2);
			if (list[v1] == null) {
				list[v1] = t;
			} else {
//**방향을 가지는 그래프는 addLast를 이용해야함.
				list[v1].link = t;
			}
		}
	}

	public void printAdjacentVertices(int v) {
		Node tmp = list[v];
		while (tmp != null) {
			System.out.print(tmp.vertex + " ");
			tmp = tmp.link;
		}
		System.out.println();
	}
}

public class DirectedMatrixGraphTest {
	public static void main(String[] args) {
		System.out.println("lab10_1 : 정기혁");

		// 정점 수 n 입력
		Scanner scan = new Scanner(System.in);
		System.out.print("정점 수 입력: ");
		int n = scan.nextInt();

		// 정점 수가 n인 방향 그래프를 생성
		DirectedMatrixGraph graph = new DirectedMatrixGraph(n);

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
	}
}
