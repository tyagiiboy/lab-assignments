package test;

import concretes.CircularLinkedList;
import interfaces.LinkedList;

public class Tester {

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new CircularLinkedList<>();
		LinkedList<Integer> list2 = new CircularLinkedList<>();
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);
		list2.addLast(6);
		list2.addLast(7);
		list2.addLast(8);
		list2.addLast(9);
		list2.addLast(10);
		
		list1.append(list2);
//		System.out.println(list1);
//		System.out.println(list2);
		
//		LinkedList<Integer> list1 = new CircularLinkedList<>();
//		list1.addFirst(20);
//		list1.addFirst(30);
//		list1.addLast(40);
//		list1.addLast(50);
		
		System.out.println(list1 + "\n" + list2);
//		System.out.println(list1);
	}

}
