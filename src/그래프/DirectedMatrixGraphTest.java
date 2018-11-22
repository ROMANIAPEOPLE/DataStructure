package �׷���;

import java.util.Scanner;

/*
 * ���ϸ�: DirectedListGraphTest.java
 * �ۼ���: 2018.11.22
 * �ۼ���: ������
* ����: ���� �׷����� �����ϰ� �̿��ϴ� ���α׷�
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
			System.out.println("���� ���� ���� - �̹� �����ϴ� �����Դϴ�" + "<" + v1 + ',' + v2 + ">");
		} else if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
			System.out.println("���� ���� ���� - �߸��� ���� ��ȣ�Դϴ�." + "<" + v1 + ',' + v2 + ">");
		} else {

			Node t = new Node(v2);
			if (list[v1] == null) {
				list[v1] = t;
			} else {
//**������ ������ �׷����� addLast�� �̿��ؾ���.
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
		System.out.println("lab10_1 : ������");

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
	}
}
