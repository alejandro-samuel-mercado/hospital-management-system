package hospital.estructuras;

//
// Creado por Julio Tentor <jtentor@fi.unju.edu.ar>
//

// de https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/LinkedList.html
public interface ILinkedList<ELEMENT> extends Iterable<ELEMENT> {

 // Devuelve el número de elementos en esta lista.
 public int size();

 // Inserta el elemento especificado al principio de esta lista.
 public void addFirst(ELEMENT item);
 
 // Agrega el elemento especificado al final de esta lista.
 public void addLast(ELEMENT item);
 
 // Elimina y devuelve el primer elemento de esta lista.
 public ELEMENT removeFirst();
 
 // Elimina y devuelve el último elemento de esta lista.
 public ELEMENT removeLast();
}
