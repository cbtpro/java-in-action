package com.chenbitao.actioninjava;

public class LinkedList<T> {
	Node<T> node;
	class Node<E> {
		E data;
		Node<E> next;
		Node(E data) { this.data = data; }
	}
}
