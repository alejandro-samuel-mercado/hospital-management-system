package hospital.estructuras;
//
// Creado por Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.util.Iterator;

public class SimpleLinkedList<ELEMENT> implements ILinkedList<ELEMENT> {

 // Región Clase Nodo
 // Clase interna que representa un nodo en la lista enlazada.
 @SuppressWarnings("hiding")
public class Node<ELEMENT> {
     public ELEMENT item;  // Elemento almacenado en el nodo.
     public Node<ELEMENT> next;  // Referencia al siguiente nodo en la lista.

     public Node() {
         this(null, null);
     }
     public Node(ELEMENT item) {
         this(item, null);
     }
     public Node(ELEMENT item, Node<ELEMENT> next) {
         this.item = item;
         this.next = next;
     }

     @Override
     public String toString() {
         return this.item.toString();
     }
 }
 // Fin Región Clase Nodo

 // Región Atributos
 // Cabeza (primer nodo), cola (último nodo) y contador de elementos en la lista.
 protected Node<ELEMENT> head;
 protected int count;
 protected Node<ELEMENT> tail;
 // Fin Región Atributos

 // Región Constructores
 // Constructor por defecto que inicializa una lista vacía.
 public SimpleLinkedList() {
     this.head = null;
     this.count = 0;
     this.tail = null;
 }
 // Fin Región Constructores

 // Región Métodos de la Lista Enlazada

 // Devuelve el número de elementos en esta lista.
 public int size() {
     return this.count;
 }
/*
 // Añade un elemento al principio de la lista (versión simple).
 public void addFirstRookieVersion(ELEMENT item) {
     if (this.count == 0) {
         this.head = this.tail = new Node<ELEMENT>(item, null);
         ++this.count;
     } else {
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
         temp.next = this.head;
         this.head = temp;
         ++this.count;
     }
 }
*/
 // Inserta el elemento especificado al principio de esta lista.
 public void addFirst(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, this.head);
     if (this.count == 0) {
         this.tail = temp;
     }
     this.head = temp;
     ++this.count;
 }
/*
 // Añade un elemento al final de la lista (versión simple).
 public void addLastRookieVersion(ELEMENT item) {
     if (this.count == 0) {
         this.head = this.tail = new Node<ELEMENT>(item, null);
         ++this.count;
     } else {
         Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
         this.tail.next = temp;
         this.tail = temp;
         ++this.count;
     }
 }
*/
 // Añade un elemento al final de la lista.
 public void addLast(ELEMENT item) {
     Node<ELEMENT> temp = new Node<ELEMENT>(item, null);
     if (this.count == 0) {
         this.head = temp;
     } else {
         this.tail.next = temp;
     }
     this.tail = temp;
     ++this.count;
 }

 // Elimina y devuelve el primer elemento de la lista.
 public ELEMENT removeFirst() {
     if (this.count == 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.head.item;
     this.head = this.head.next;
     if (this.head == null) {
         this.tail = null;
     }
     --this.count;
     return item;
 }

 // Elimina y devuelve el último elemento de la lista.
 public ELEMENT removeLast() {
     if (this.count == 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.tail.item;
     if (this.head.next == null) {
         this.head = this.tail = null;
     } else {
         Node<ELEMENT> skip = this.head;
         while (skip.next.next != null) {
             skip = skip.next;
         }
         this.tail = skip;
         this.tail.next = null;
     }
     --this.count;
     return item;
 }
 
 public ELEMENT encontrarELEMENTO () {
	 if (this.count == 0) {
         throw new RuntimeException("La lista está vacía...");
     }
     ELEMENT item = this.tail.item;
     if (this.head.next == null) {
         this.head = this.tail = null;
     } else {
         Node<ELEMENT> skip = this.head;
         while (skip.next.next != null) {
             skip = skip.next;
         }
         this.tail = skip;
         this.tail.next = null;
     }
     --this.count;
     return item;
 }
 // Fin Región Métodos de la Lista Enlazada

 // Región Métodos de Objeto

 // Devuelve una representación en forma de cadena de la lista enlazada.
 @Override
 public String toString() {

     if (this.size() <= 0) {
         return "";
     }

     // de https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
     StringBuilder sb = new StringBuilder();

     sb.append("[" + this.head.item.toString());
     for (Node<ELEMENT> skip = this.head.next; skip != null; skip = skip.next) {
         sb.append(", " + skip.item.toString());
     }
     sb.append("]");

     return sb.toString();
 }
 // Fin Región Métodos de Objeto

 // Región Métodos de Iterable

 // Retorna un iterador para la lista enlazada.
 @Override
 public Iterator<ELEMENT> iterator() {
     return new SimpleLinkedListIterator(this.head);
 }

 // Clase interna para iterar sobre los elementos de la lista enlazada.
 private class SimpleLinkedListIterator implements Iterator<ELEMENT> {
     private Node<ELEMENT> current;

     public SimpleLinkedListIterator(Node<ELEMENT> current) {
         this.current = current;
     }

     @Override
     public boolean hasNext() {
         return this.current != null;
     }

     @Override
     public ELEMENT next() {
         if (!this.hasNext()) {
             throw new RuntimeException("La lista está vacía...");
         }
         ELEMENT item = this.current.item;
         this.current = this.current.next;
         return item;
     }

 }
 // Fin Región Métodos de Iterable

}
