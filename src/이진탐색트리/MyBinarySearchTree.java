package 이진탐색트리;
/*
 * 파일명: MyBinarySearchTree.java
 * 작성일: 2018.11.18 (최종)
 * 작성자: 정기혁
* 설명: int형 키값 저장하는 이진탐색트리를 연결자료구조로 구현한 클래스
*/

import java.util.NoSuchElementException;

public class MyBinarySearchTree {
	// (1) 트리의 노드를 표현하는 private 클래스 Node - 필드(int형 key, leftChild, rightChild),
	// 생성자(key값을 매개변수로 받아 초기화)
	private class Node {
		int key;
		Node leftChild;
		Node rightChild;

		public Node(int key) {
			this.key = key;
		}

	}

	// (2) private 인스턴스 변수 트리의 루트 노드를 가킬 변수(root)를 선언하고 null로 초기화
	private Node root = null;

// 트리에 키값 key를 삽입하는 메소드
	public void insert(int key) {
		root = insertKey(root, key);
	}

// p를 루트로 하는 트리에 키값 key를 삽입하고, 삽입 후 루트를 리턴하는 메소드(재귀 알고리즘)
	private Node insertKey(Node p, int key) {
		if (p == null) {
			Node newNode = new Node(key);
			return newNode;
		} else if (key < p.key) {
			p.leftChild = insertKey(p.leftChild, key);
			return p; // 루트 불변
		} else if (key > p.key) {
			p.rightChild = insertKey(p.rightChild, key);
			return p; // 루트 불변
		} else { // key = p.key 인 경우 삽입 실패
			System.out.println("삽입 실패. 중복된 키값이 존재합니다: " + key);
			return p; // 루트 불변
		}
	}

// 트리를 중위순회하며 출력하는 메소드
	public void printInorder() {
		inorder(root);
		System.out.println();
	}

// (3) p를 루트로 하는 트리를 중위 순회하며 키값을 출력하는 메소드(재귀 알고리즘)
	private void inorder(Node p) {
		if (p != null) {
			
			inorder(p.leftChild);
			inorder(p.rightChild);
			System.out.print(p.key + " ");
		}

	}

//	 (4) 트리의 최대 키값을 리턴하는 메소드(반복 알고리즘) - 공백 트리인 경우 NoSuchElementException 예외 발생
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


	
	// 트리가 키값 key를 포함하는지 여부를 리턴하는 메소드
	public boolean contains(int key) {
		return search(root, key);
	}

	// (5) p를 루트로 하는 트리에 키값 key가 존재하는지 여부를 리턴하는 메소드(재귀 알고리즘)

	private boolean search(Node p, int key) {

		if (p == null) { // 공백 트리인 경우
			return false;
		}

		else { // 그외
			if (p.key == key) { // root의 값과 검색하려는 key의 값이 일치하는 경우
				return true;
			} else if (p.key > key) {
				return search(p.leftChild, key);
			} else // p.key <key 인 경우
				return search(p.rightChild, key);
		}

	}

	// (6) 트리에 키값 key를 삽입하는 메소드(반복 알고리즘) - 삽입 성공여부(true/false)를 리턴
	public boolean add(int key) {

		Node t = new Node(key); // add할 노드 t를 생성
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

				else { // p.leftChild !=null 일 경우
					p = p.leftChild;
				}

			}

			else if (p.key < key) {
				if (p.rightChild == null) {
					p.rightChild = t;
					return true;
				}

				else { // p.rightChild !=null 일 경우
					p = p.rightChild;
				}
			}

			else { // 삽입에 성공하였거나, 이미 중복된 값이 있어 삽입이 불가능 할 경우
				return false;

			}

		}

	}

	public boolean remove(int item) {
		Node p = root;
		Node q = null;

		while (p != null) { // item의 위치를 탐색하는 while문
			if (p.key == item) {
				break; // item을 찾았으면 while문을 빠져나감
			}

			else if (p.key > item) {
				q = p;
				p = p.leftChild;
			} else { // p.key < item 인 경우
				q = p;
				p = p.rightChild;
			}
		}
		if (p == null) {// 0.비어있는 이진탐색트리를 삭제하려고 한 경우, false 리턴
			return false;
		}

		else if (p.leftChild == null && p.rightChild == null) { //// 1. 삭제하려는 Node가 단독 Node(무자식) 인 경우
			if (p == root) {
				root = null; // 1-(1) : root가 삭제하려는 값일때. 즉 root만 있는 이진탐색트리
			} else if (p == q.leftChild) {
				q.leftChild = null; // 1-(2) 삭제하려는 값이 q의 왼쪽자식인 경우
			} else { // 1-(3) p ==q.rightChild 인 경우
				q.rightChild = null;
			}
		}

		else if (p.leftChild == null || p.rightChild == null) { //// 2. 삭제하려는 Node가 자식이 1개만 있을 경우
			if (p.leftChild != null) { // 2-(1) 삭제하려는 대상이 왼쪽 자식을 가지고 있을 경우
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
			int data = temp.key; // data라는 변수를 선언하여 temp.key의 값을 저장해준다.(temp.key는 후계자의 key값)
			remove(temp.key); //후계자를 삭제
			p.key = data; // 삭제하려는 값에 후계자를 복사

		}

		return true;
	}
}