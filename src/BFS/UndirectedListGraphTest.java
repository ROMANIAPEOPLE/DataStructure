package BFS;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

class UndirectedListGraph {
	private class Node {
		int vertex; // ���� �ʵ�
		Node link; // ���� ���

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

	public boolean hasEdge(int v1, int v2) { // v1�� v2�� �����ϴ��� (�ߺ��˻�)
		Node temp = list[v1];
		while (temp != null) {
			if (temp.vertex == v2) { // head.data �� item �� ������
				return true;
			}
			temp = temp.link;
		}

		return false;
	}

	public void addEdge(int v1, int v2) {
		Node t = new Node(v2);
		Node t2 = new Node(v1);
		if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) { // v1,v2�� ������ ��� ������ ���, ������ ���
			System.out.println("�߸��� ���� ��ȣ�Դϴ�.");
		} else if (hasEdge(v1, v2)) {
			System.out.println("�̹� �����ϴ� �����Դϴ�.");
		} else {
			// list[v1] �� ����Ű�� �ܼ����Ḯ��Ʈ�� �� �տ� v2 ����
			// list[v2] �� ����Ű�� �ܼ� ���Ḯ��Ʈ�� �� �տ� v1 ����

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
			System.out.println("�߸��� ���� ��ȣ �Դϴ�.");
		} else {
			for (int i = 0; i < n; i++) {
				visited[i] = false;
			}

			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(v); // enQueue(���������� ��)
			visited[v] = true; // �湮�� ���������� ���� true�� �ʱ�ȭ
			System.out.print("�������� " + v + "�� �ʺ� �켱Ž�� = " + v + "");

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
			System.out.println("�߸��� ���� �Դϴ�.");
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
		System.out.println("hw10_2 : ������");

		// ���� �� n �Է�
		Scanner scan = new Scanner(System.in);
		System.out.print("���� �� �Է�: ");
		int n = scan.nextInt();

		// ���� ���� n�� ������ �׷����� ����
		UndirectedListGraph graph = new UndirectedListGraph(n);

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
		for (int i = 0; i < n; i++)
			graph.breadthFirstSearch(i);

	}
}
