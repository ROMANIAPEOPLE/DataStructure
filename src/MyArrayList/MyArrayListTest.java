package MyArrayList;
/* �̸� : ������
 * �ۼ��� : 2018-09-18
 * �����ڵ� hw5_1
 */
import java.util.Arrays;
import java.util.Scanner;

class MyArrayList {

	private int[] array;
	private int number;

	public MyArrayList() {
		array = new int[10]; // ũ�Ⱑ 10�� �迭 array
		number = 0; // ���� �迭�� ����� �׸���� 0
	}

	public boolean add(int a) {// add�޼ҵ�
//** �ɼ�2: ���� ���� �迭�� ������ ��� false �����ϴ� ���, ���� �迭�� 2��� Ȯ���ϵ��� �� �� ��
		if (number == array.length) {
			System.out.println("**�迭�� ũ�Ⱑ 2��� �����߽��ϴ�.**");
			int[] copy = new int[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				copy[i] = array[i];
			}
			array = copy;
			array[number] = a;
			number++;
		} else {
			array[number] = a;
			number++;
		}
		return true;
	}

	// ** �ɼ�4: toString() ���� String ��� StringBuffer�� �̿��Ͽ� ������ �� ��
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("[");
		for (int i = 0; i < number; i++) {
			if (i > 0) {
				s.append(",");
			}
			s.append(array[i]);
		}
		s.append("]");
		return s.toString();

	}

	// get - �ε����� �Ű������� �޾� �迭�� �ش� �������� ���� O(1)

	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= number)
			throw new IndexOutOfBoundsException();
		return array[index];

	}

	// size - ����Ʈ�� ���̸� ����(�迭 ũ�Ⱑ �ƴ�) O(1)
	public int size() {
		return number;
	}

	// add - �ε����� �������� �Ű������� �޾� �迭�� �ش� ��ġ�� �������� ���� O(n)
	public int add(int index, int element) throws IndexOutOfBoundsException {
		if (index >= number) {
			throw new IndexOutOfBoundsException();
		}
		int y = number;
		for (int i = index; i < number; i++) {
			array[y] = array[y - 1];
			y--;
		}

		number++;
		return array[index] = element;
	}

	// remove - �ε����� �Ű������� �޾� �迭�� �ش� ��ġ �������� �����ϰ� �� ���� ���� O(n)
	public int remove(int index) throws IndexOutOfBoundsException {
		if (index >= number) {
			throw new IndexOutOfBoundsException();
		}
		int z = array[index];
		for (int i = index; i < number - 1; i++) {
			array[i] = array[i + 1];
			index++;
		}
		number--;
		return z;
	}
}

public class MyArrayListTest {

	public static void main(String[] args) throws Exception {

		System.out.println("hw5_1: ������");

		MyArrayList list = new MyArrayList();

		Scanner input = new Scanner(System.in);
		int menu = 0;
		int index = 0;
		int element = 0;

		do {
			System.out.print(" 1:�ε�����ȸ 2:��ü��ȸ 3:������ȸ 4:���� 5:�ε������� 6:�ε������� 7:���� ---> ");
			menu = input.nextInt();

			switch (menu) {
			case 1:
				System.out.println("�ε��� ��ġ�� ���Ұ��� ��ȸ�մϴ�.");
				System.out.print("�ε��� �Է�: ");
				index = input.nextInt();
				element = list.get(index); // �ϼ��ϼ���.
				System.out.println(element);
				break;
			case 2:
				System.out.println("����Ʈ ��ü�� ��ȸ�մϴ�.");
				System.out.println(list); // �ϼ��ϼ���.
				break;
			case 3:
				System.out.println("����Ʈ ���̸� ��ȸ�մϴ�.");
				int size = list.size(); // �ϼ��ϼ���.
				System.out.println(size);
				break;
			case 4:
				System.out.println("���Ҹ� ����Ʈ�� �� �ڿ� �����մϴ�.");
				System.out.print("������ �Է�: ");
				element = input.nextInt();
				list.add(element);

				break;
			case 5:
				System.out.println("�ε��� ��ġ�� ���Ҹ� �����մϴ�.");
				System.out.print("�ε��� �Է�: ");
				index = input.nextInt();
				System.out.print("������ �Է�: ");
				element = input.nextInt();

				list.add(index, element); // �ϼ��ϼ���
				break;
			case 6:
				System.out.println("�ε��� ��ġ�� ���Ҹ� �����մϴ�.");
				System.out.print("�ε��� �Է�: ");
				index = input.nextInt();
				element = list.remove(index); // �ϼ��ϼ���.
				System.out.println(element);
				break;
			case 7:
				System.out.println("�����մϴ�.");
				break;
			default:
				System.out.println("�޴� ���� ����: �ٽ� �����ϼ���.");
			}
		} while (menu != 7);
	}
}
