package test;

import concretes.DoublyLinkedList;
import interfaces.LinkedList;

public class Tester {

	public static void main(String[] args) {
		LinkedList<Integer> list = new DoublyLinkedList<>();
		list.addLast(4);
		list.addLast(3);
		list.addLast(2);
		list.addLast(1);
		System.out.println(list.toString());
//		list.deleteFront();
//		list.deleteFront();
//		list.deleteFront();
//		list.deleteFront();
//		list.deleteFront();
//		list.sort();
		list.reverse(false);
		System.out.println(list.toString());
//		list.deleteBack();
//		System.out.println(list.toString());
//		list.deleteFront();
//		System.out.println(list.toString());
	}

}
