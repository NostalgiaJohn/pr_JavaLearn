package com.fs.d_util;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
	
	/**
	 * 有效元素个数
	 */
	private int size = 0;
	
	/**
	 * 第一个Node节点首地址
	 */
	private Node<E> first;
	
	/**
	 * 最后一个Node节点首地址
	 */
	private Node<E> last;
	
	/**
	 * 私有化静态成员内部类
	 * 
	 * @author fStardust
	 *
	 * @param <E> 和MyListedList一致的泛型
	 */
	private static class Node<E> {
		/**
		 * 在LinkedList中保存的Node节点内元素内存
		 */
		E item;
		
		/**
		 * 下一个Node节点引用，保存下一个节点空间首地址
		 */
		Node<E> next;
		
		/**
		 * 上一个Node节点的保存上一个节点空间首地址
		 */
		Node<E> prev;
		
		/**
		 * Node<E>没有无参数构造方法，
		 * 创建对应Node对象，在当前Node节点中，同时需要包装需要存储的数据，需要保存前后节点位置，
		 * 
		 * @param prev 前节点位置
		 * @param element 存储元素
		 * @param next 后节点位置
		 */
		public Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			
		}
	}

	/**
	 * 空MyLinkedList集合，只是准备了一个所谓的链表头
	 */
	public MyLinkedList() {}
	
	/*
	add(E e);
	addFirst(E e);
	addLast(E e);
	E getFirst();
	E getLast():
	E get(int index);
	removeFirst();
	removeLast();	
	remove(int index);
	remove(Object obj);
    E set(int index, E);
    size();
	 */
	
	/**
	 * 添加一个符合当前MyLinkedList泛型约束数据类型一致的元素到集合中
	 * 
	 * @param e 符合MyLinkedList要求的元素
	 * @return 添加成功返回true
	 */
	public boolean add(E e) {
		// 最后一个节点位置，当前元素包装成Node
		Node<E> l = last;
		
		// 创建得到一个新的Node节点
		Node<E> newNode = new Node<>(l, e, null);
		
		// 因为当前元素需要保存到LinkedList结尾，last一定要被赋值newNode
		last = newNode;
		
		// 第一个有效节点时，first同时指向当前节点
		if (null == first) {
			first = newNode;
		} else {
			
			// 原本最后一个节点next指向新的newNode
			l.next = newNode;
		}
		
		// 有效元素+1
		size += 1;
		
		return true;
	}
	
	/**
	 * 同是尾插法操作
	 * 
	 * @param e 符合泛型约束的具体数据类型
	 */
	public void addLast(E e) {
		add(e);
	}
	
	/**
	 * 在LinkedList链表头添加一个元素
	 * 
	 * @param e 符合泛型约束的具体数据类型
	 */
	public void addFirst(E e) {
		/*
		 * 三个地址：
		 * 	1. LinkedList链表头 first ==> newNode
		 * 	2. newNode.next --> old FirstNode
		 * 	3. old FirstNode.prev --> newNode
		 */
		// 原始的first节点
		Node<E> f = first;
		
		// 创建新节点
		Node<E> newNode = new Node<>(null, e, f);
		
		// LinkedList链表头内first一定执行newNode
		first = newNode;
		
		if (null == first) {
			last = newNode;
		} else {
			// 原始的first节点，prev赋值为newNode
			f.prev = newNode;
		}
		
		size += 1;
	}
	
	/**
	 * 获取第一个节点元素
	 * 
	 * @return 第一个Node保存元素
	 */
	public E getFirst() {
		Node<E> f = first;
		
		if (null == f) {
			throw new NoSuchElementException();
		}
		
		return f.item;
	}
	
	/**
	 * 获取最后一个节点元素
	 * 
	 * @return 最后一个Node保存元素
	 */
	public E getLast() {
		Node<E> l = last;
		
		if (null == l) {
			throw new NoSuchElementException();
		}
		
		return l.item;
	}
	
	/**
	 * 获取指定下标（指定计数，第几个节点内存储的元素）
	 * 
	 * @param index 指定的下标位置，计数
	 * @return 对应的元素内容
	 */
	public E get(int index) {
		if (index < 0 || index >= size)  {
			throw new IndexOutOfBoundsException();
		}
		
		if (index < (size >> 1)) {
			Node<E> n = first;
			for (int i = 0; i < index; i++) {
				n = n.next;
			}
			
			return n.item;
		} else {
			Node<E> n = last;
			for (int i = size - 1; i > index; i--) {
				n = n.prev;
			}
			
			return n .item;
		}
	}
	
	/**
	 * 删除最后一个元素
	 * 
	 * @return 返回值是保存的元素内容
	 */
	public E removeLast() {
		// 最后一个节点
		Node<E> l = last;
		// 倒数第二个节点
		Node<E> prev = last.prev;
		if (null == l) {
			throw new NoSuchElementException();
		}
		
		// 链表头内部的last指向原本最后一个元素的前一个元素
		last = l.prev;
		
		// 如果链表中就一个元素
		if (null == last) {
			first = null;
		}
		
		// 原最后一个节点的前节点空间地址赋值为null
		l.prev = null;
		
		// last指向原本的最后一个节点的前节点
		last = prev;
		// 前节点为null
		if (null == prev) {
			first = null; 
		} else {
			prev.next = null;
		}
		
		// 取出节点中保存的数据内存
		E e = l.item;
		
		// 原节点内所有数据全部为null，方便GC机制回收
		l.item = null;
		
		size -= 1;
		return e;
	}
	
}














