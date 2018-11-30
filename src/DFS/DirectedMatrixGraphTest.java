package DFS;

import java.util.Scanner;

class DirectedMatrixGraph {

	private int matrix[][];
	private int n; // ������
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
			System.out.println("�߸��� ����" +"<" + v1 + "," + v2 + ">");
		} else if (hasEdge(v1, v2)) {
			System.out.println("�̹� �����ϴ� ����" + "<" + v1 + "," + v2 + ">");
		} else { // ���� ����
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
			System.out.println("�߸��� �����Դϴ�.");
		}

		else {
			for (int i = 0; i < n; i++) {
				visited[i] = false; //visited[0] ~ visited[4]�� false�� �ʱ�ȭ
			}
			System.out.print("��������" + v + "�� ���� �켱 Ž��" + "=" + v + " ");
			DFS(v); //v�� 0���� n���� ������� �־��ش�. (Main�޼ҵ�)
		}
		
	}

	private void DFS(int v) {
		visited[v] = true;
		for (int i = 0; i < n; i++) {
			if (matrix[v][i] == 1 && visited[i] == false) { //������ �����ϰ�, ���� �湮���� �ʾҴٸ�
				System.out.print(i + " "); //���
				DFS(i);
			}
		}
	}
}

public class DirectedMatrixGraphTest {

	public static void main(String[] args) {
		System.out.println("hw10_1 : ������");

		// ���� �� n �Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �Է�: ");
		int n = scan.nextInt();

		// ���� ���� n�� ���� �׷����� ����
		DirectedMatrixGraph graph = new DirectedMatrixGraph(n);

		// ���� �� e �Է�
		System.out.print("���� �� �Է�: ");
		int e = scan.nextInt();

		// e���� ����(���� ��)�� �Է¹޾� �׷����� ����
		System.out.println(e + "���� ������ �Է��ϼ���(�� ������ ���� ��ȣ 2���� whitespace�� �����Ͽ� �Է�):");
		for (int i = 0; i < e; i++) {
			int v1 = scan.nextInt();
			int v2 = scan.nextInt();
			graph.addEdge(v1, v2);
		}

		// �� ������ ���� �������� ���
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.print("���� " + i + "�� ������ ���� = ");
			graph.printAdjacentVertices(i);
		}

		System.out.println();
		for (int i = 0; i < n; i++) {
			graph.depthFirstSearch(i);
			System.out.println();
		}
	}
}