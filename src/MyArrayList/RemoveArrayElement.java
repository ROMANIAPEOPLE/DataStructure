package MyArrayList;

import java.util.Scanner;

public class RemoveArrayElement {

	public static void main(String[] args) {
		System.out.println("course3 : ȫ�浿 ");

		// ũ�Ⱑ 15�� �迭 list�� ���̰� numberOfElements�� ���� ����Ʈ�� ������
		int[] list = { 3, -6, 11, -5, 22, 11, 0, 9, 7, 2, 0, 0, 0, 0, 0 };
		int numberOfElements = 10;

		// numberOfElements���� ���Ҹ� ���� ����Ʈ�� ���
		System.out.print("���� �� ����Ʈ = ");
		printList(list, numberOfElements);

		// ������ ��(element)�� �Է¹���
		Scanner input = new Scanner(System.in);
		System.out.print("������ �� �Է�: ");
		int element = input.nextInt();

		// (1) list���� element�� ����
		// �̶�, ������ ���� �������� �� ���� ���Ҹ� �����ϰ�, �������� �ʴ� ���� ��� ���� ����

		int index = 0;
		while (true) {
			if (index >= list.length) {
				System.out.println("�ʰ�");
				break;
			}

			else if (list[index] == element) {
				for (int i = index; i < numberOfElements - 1; i++) {
					list[i] = list[i + 1];
					index++;

				}
				System.out.println("���� �Ϸ�");

				numberOfElements--;
				break;
			}

			index++;
		}
		// ���� ����� numberOfElements���� ���Ҹ� ���� ����Ʈ�� ���
		System.out.print("���� �� ����Ʈ = ");
		printList(list, numberOfElements);
	}

	// �迭 array�� ����� numberOfElements ���� ���Ҹ� ���
	// �迭�� ���̿� ����� ���Ҽ��� ���� �ٸ� �� ����
	private static void printList(int[] array, int numberOfElements) {
		for (int i = 0; i < numberOfElements; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
