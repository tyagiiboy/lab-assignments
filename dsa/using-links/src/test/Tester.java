package test;

import concretes.DoublyLinkedList;
import interfaces.LinkedList;

public class Tester {

	public static void main(String[] args) {
		LinkedList<Integer> list = new DoublyLinkedList<>();
		list.insertBack(1);
		list.insertFront(2);
		list.insertBack(3);
		list.insertFront(4);
		System.out.println(list.toString());
		list.deleteBack();
		System.out.println(list.toString());
		list.deleteFront();
		System.out.println(list.toString());
	}

}
