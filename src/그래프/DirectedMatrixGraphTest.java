package �׷���;
//���� �׷����� �����ϰ� �̿��ϴ� ���α׷�

import java.util.Scanner;

class DirectedMatrixGraph {

	private int matrix[][];
	private int n; //������
	
	public DirectedMatrixGraph(int n) {
		this.n=n;
		matrix = new int[n][n];
	}
	
	public boolean hasEdge(int v1, int v2) {
		if(matrix[v1][v2] == 1) {
			return true;
		}
		return false;
	}
	
	public void addEdge(int v1 , int v2) {
		if(v1 <0 || v1>n-1 || v2<0 || v2>n-1) {
			System.out.println("�߸��� ����");
		}
		else if(hasEdge(v1,v2)) {
			System.out.println("�̹� �����ϴ� ����");
		}
		else { //���� ����
			matrix[v1][v2] = 1;
		}
	}
	
	public void printAdjacentVertices(int v) {
		for(int i=0; i<matrix.length; i++) {
			if(matrix[v][i]==1) {
				System.out.print(i + " ");
			}
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
