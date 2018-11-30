package DFS;

import java.util.Scanner;

class DirectedMatrixGraph {

	private int matrix[][];
	private int n; // 정점수
	private boolean visited[];

	public DirectedMatrixGraph(int n) {
		this.n = n;
		matrix = new int[n][n];
		visited = new boolean[n];

	}

	public boolean hasEdge(int v1, int v2) {
		if (matrix[v1][v2] == 1) {
			return true;
		}
		return false;
	}

	public void addEdge(int v1, int v2) {
		if (v1 < 0 || v1 > n - 1 || v2 < 0 || v2 > n - 1) {
			System.out.println("잘못된 정점" +"<" + v1 + "," + v2 + ">");
		} else if (hasEdge(v1, v2)) {
			System.out.println("이미 존재하는 간선" + "<" + v1 + "," + v2 + ">");
		} else { // 삽입 가능
			matrix[v1][v2] = 1;
		}
	}

	public void printAdjacentVertices(int v) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[v][i] == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	public void depthFirstSearch(int v) {
		if (v < 0 || v >= n) {
			System.out.println("잘못된 정점입니다.");
		}

		else {
			for (int i = 0; i < n; i++) {
				visited[i] = false; //visited[0] ~ visited[4]를 false로 초기화
			}
			System.out.print("시작정점" + v + "의 깊이 우선 탐색" + "=" + v + " ");
			DFS(v); //v에 0부터 n까지 순서대로 넣어준다. (Main메소드)
		}
		
	}

	private void DFS(int v) {
		visited[v] = true;
		for (int i = 0; i < n; i++) {
			if (matrix[v][i] == 1 && visited[i] == false) { //간선이 존재하고, 아직 방문하지 않았다면
				System.out.print(i + " "); //출력
				DFS(i);
			}
		}
	}
}

public class DirectedMatrixGraphTest {

	public static void main(String[] args) {
		System.out.println("hw10_1 : 정기혁");

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

		System.out.println();
		for (int i = 0; i < n; i++) {
			graph.depthFirstSearch(i);
			System.out.println();
		}
	}
}