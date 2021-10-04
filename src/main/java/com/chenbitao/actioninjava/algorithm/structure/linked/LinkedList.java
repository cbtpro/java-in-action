package com.chenbitao.actioninjava.algorithm.structure.linked;

public class LinkedList<T> {
	Node<T> head;
	class Node<E> {
		E data;
		Node<E> next;
		Node(E data) { this.data = data; }
	}
}
