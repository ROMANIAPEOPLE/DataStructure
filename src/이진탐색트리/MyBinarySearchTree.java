package ����Ž��Ʈ��;
/*
 * ���ϸ�: MyBinarySearchTree.java
 * �ۼ���: 2018.11.18 (����)
 * �ۼ���: ������
* ����: int�� Ű�� �����ϴ� ����Ž��Ʈ���� �����ڷᱸ���� ������ Ŭ����
*/

import java.util.NoSuchElementException;

public class MyBinarySearchTree {
	// (1) Ʈ���� ��带 ǥ���ϴ� private Ŭ���� Node - �ʵ�(int�� key, leftChild, rightChild),
	// ������(key���� �Ű������� �޾� �ʱ�ȭ)
	private class Node {
		int key;
		Node leftChild;
		Node rightChild;

		public Node(int key) {
			this.key = key;
		}

	}

	// (2) private �ν��Ͻ� ���� Ʈ���� ��Ʈ ��带 ��ų ����(root)�� �����ϰ� null�� �ʱ�ȭ
	private Node root = null;

// Ʈ���� Ű�� key�� �����ϴ� �޼ҵ�
	public void insert(int key) {
		root = insertKey(root, key);
	}

// p�� ��Ʈ�� �ϴ� Ʈ���� Ű�� key�� �����ϰ�, ���� �� ��Ʈ�� �����ϴ� �޼ҵ�(��� �˰���)
	private Node insertKey(Node p, int key) {
		if (p == null) {
			Node newNode = new Node(key);
			return newNode;
		} else if (key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p; // ��Ʈ �Һ�
		} else if (key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p; // ��Ʈ �Һ�
		} else { // key = p.key �� ��� ���� ����
			System.out.println("���� ����. �ߺ��� Ű���� �����մϴ�: " + key);
			return p; // ��Ʈ �Һ�
		}
	}

// Ʈ���� ������ȸ�ϸ� ����ϴ� �޼ҵ�
	public void printInorder() {
		inorder(root);
		System.out.println();
	}

// (3) p�� ��Ʈ�� �ϴ� Ʈ���� ���� ��ȸ�ϸ� Ű���� ����ϴ� �޼ҵ�(��� �˰���)
	private void inorder(Node p) {
		if (p != null) {
			
			inorder(p.leftChild);
			inorder(p.rightChild);
			System.out.print(p.key + " ");
		}

	}

//	 (4) Ʈ���� �ִ� Ű���� �����ϴ� �޼ҵ�(�ݺ� �˰���) - ���� Ʈ���� ��� NoSuchElementException ���� �߻�
	public int max() {
		if (root == null) {
			throw new NoSuchElementException();
		}

		Node p = root;

		while (p.rightChild != null) {
			p = p.rightChild;
		}

		return p.key;

	}


	
	// Ʈ���� Ű�� key�� �����ϴ��� ���θ� �����ϴ� �޼ҵ�
	public boolean contains(int key) {
		return search(root, key);
	}

	// (5) p�� ��Ʈ�� �ϴ� Ʈ���� Ű�� key�� �����ϴ��� ���θ� �����ϴ� �޼ҵ�(��� �˰���)

	private boolean search(Node p, int key) {

		if (p == null) { // ���� Ʈ���� ���
			return false;
		}

		else { // �׿�
			if (p.key == key) { // root�� ���� �˻��Ϸ��� key�� ���� ��ġ�ϴ� ���
				return true;
			} else if (p.key > key) {
				return search(p.leftChild, key);
			} else // p.key <key �� ���
				return search(p.rightChild, key);
		}

	}

	// (6) Ʈ���� Ű�� key�� �����ϴ� �޼ҵ�(�ݺ� �˰���) - ���� ��������(true/false)�� ����
	public boolean add(int key) {

		Node t = new Node(key); // add�� ��� t�� ����
		Node p = root;

		while (true) {
			if (root == null) {
				root = t;
				return true;
			}

			else if (p.key > key) {
				if (p.leftChild == null) {
					p.leftChild = t;
					return true;
				}

				else { // p.leftChild !=null �� ���
					p = p.leftChild;
				}

			}

			else if (p.key < key) {
				if (p.rightChild == null) {
					p.rightChild = t;
					return true;
				}

				else { // p.rightChild !=null �� ���
					p = p.rightChild;
				}
			}

			else { // ���Կ� �����Ͽ��ų�, �̹� �ߺ��� ���� �־� ������ �Ұ��� �� ���
				return false;

			}

		}

	}

	public boolean remove(int item) {
		Node p = root;
		Node q = null;

		while (p != null) { // item�� ��ġ�� Ž���ϴ� while��
			if (p.key == item) {
				break; // item�� ã������ while���� ��������
			}

			else if (p.key > item) {
				q = p;
				p = p.leftChild;
			} else { // p.key < item �� ���
				q = p;
				p = p.rightChild;
			}
		}
		if (p == null) {// 0.����ִ� ����Ž��Ʈ���� �����Ϸ��� �� ���, false ����
			return false;
		}

		else if (p.leftChild == null && p.rightChild == null) { //// 1. �����Ϸ��� Node�� �ܵ� Node(���ڽ�) �� ���
			if (p == root) {
				root = null; // 1-(1) : root�� �����Ϸ��� ���϶�. �� root�� �ִ� ����Ž��Ʈ��
			} else if (p == q.leftChild) {
				q.leftChild = null; // 1-(2) �����Ϸ��� ���� q�� �����ڽ��� ���
			} else { // 1-(3) p ==q.rightChild �� ���
				q.rightChild = null;
			}
		}

		else if (p.leftChild == null || p.rightChild == null) { //// 2. �����Ϸ��� Node�� �ڽ��� 1���� ���� ���
			if (p.leftChild != null) { // 2-(1) �����Ϸ��� ����� ���� �ڽ��� ������ ���� ���
				if (p == root) {
					root = p.leftChild;
				}

				else if (p == q.leftChild) {
					q.leftChild = p.leftChild;
				}

				else { // p == q.rightChild
					q.rightChild = p.leftChild;
				}
			}

			else { // p.rightChild !=null{
				if (p == root) {
					root = p.rightChild;
				}

				else if (p == q.rightChild) {
					q.rightChild = p.rightChild;
				}

				else {
					q.leftChild = p.rightChild;
				}
			}

		} else {
			Node temp = p.leftChild;

			while (temp != null) { 
				if (temp.rightChild != null) {
					temp = temp.rightChild;
				} else
					break;
			}
			int data = temp.key; // data��� ������ �����Ͽ� temp.key�� ���� �������ش�.(temp.key�� �İ����� key��)
			remove(temp.key); //�İ��ڸ� ����
			p.key = data; // �����Ϸ��� ���� �İ��ڸ� ����

		}

		return true;
	}
}