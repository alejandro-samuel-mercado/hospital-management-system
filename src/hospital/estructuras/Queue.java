//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//
 
/*
public interface Queue<E>
extends Collection<E>
 
Una colección diseñada para contener elementos antes de procesarlos.
Además de las operaciones básicas de Collection, las colas proporcionan operaciones adicionales
de inserción, extracción e inspección. Cada uno de estos métodos existe en dos formas: una lanza
una excepción si la operación falla, la otra devuelve un valor especial (ya sea null o false,
dependiendo de la operación).
 
La segunda forma de la operación de inserción está diseñada específicamente para su uso
con implementaciones de Queue con capacidad restringida; en la mayoría de implementaciones,
las operaciones de inserción no pueden fallar.
 
Típicamente, pero no necesariamente, las colas ordenan los elementos en un modo FIFO
(primero en entrar, primero en salir). Entre las excepciones se encuentran las colas de prioridad,
que ordenan los elementos de acuerdo con un comparador suministrado o el orden natural de los elementos,
y las colas LIFO (o pilas), que ordenan los elementos en modo LIFO (último en entrar, primero en salir).
Cualquiera que sea el orden utilizado, el "head" (cabeza) de la cola es el elemento que sería
removido por una llamada a remove() o poll(). En una cola FIFO, todos los elementos nuevos se insertan
al final de la cola. Otros tipos de colas pueden usar diferentes reglas de colocación.
Cada implementación de Queue debe especificar sus propiedades de ordenamiento.
 
El método offer inserta un elemento si es posible, de lo contrario devuelve false.
Esto difiere del método Collection.add, que solo puede fallar al agregar un elemento lanzando una excepción
no verificada. El método offer está diseñado para su uso cuando el fallo es una ocurrencia normal,
en lugar de excepcional, por ejemplo, en colas con capacidad fija (o "acotadas").
 
Los métodos remove() y poll() eliminan y devuelven el primer elemento de la cola.
Qué elemento se elimina exactamente depende de la política de ordenación de la cola,
que varía de una implementación a otra. Los métodos remove() y poll() difieren solo en su
comportamiento cuando la cola está vacía: el método remove() lanza una excepción,
mientras que el método poll() devuelve null.
 
Los métodos element() y peek() devuelven, pero no eliminan, el primer elemento de la cola.
 
La interfaz Queue no define los métodos de cola bloqueante, que son comunes en la programación concurrente.
Estos métodos, que esperan que aparezcan elementos o que haya espacio disponible, están definidos
en la interfaz BlockingQueue, que extiende esta interfaz.
 
Las implementaciones de Queue generalmente no permiten la inserción de elementos null,
aunque algunas implementaciones, como LinkedList, no prohíben la inserción de null.
Incluso en las implementaciones que lo permiten, no se debe insertar null en una Queue,
ya que null también se utiliza como un valor de retorno especial por el método poll
para indicar que la cola no contiene elementos.
 
Las implementaciones de Queue generalmente no definen versiones basadas en elementos de los métodos
equals y hashCode, sino que heredan las versiones basadas en identidad de la clase Object,
porque la igualdad basada en elementos no siempre está bien definida para colas
con los mismos elementos pero diferentes propiedades de ordenamiento.
 
Esta interfaz es miembro del Java Collections Framework.
 
// Fuente de documentación: https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/Queue.html
// Fuente de documentación: https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/util/Queue.html
// Fuente de documentación: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Queue.html
*/
package hospital.estructuras;

public class Queue<ELEMENT> {

    //region Constantes

    private final static Integer defaulDimension = 10;

    //endregion

    //region Atributos

    private ELEMENT[] data;
    private int head;
    private int tail;
    private int count;

    //endregion

    //region Constructores

    public Queue() {
        this(Queue.defaulDimension);
    }

    @SuppressWarnings("unchecked")
	public Queue(int dimension) {
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    //endregion

    //region Métodos Internos de la Cola
    private int next(int pos) {
        if (++pos >= this.data.length) {
            pos = 0;
        }
        return pos;
    }
    
    public boolean isEmpty() {
        return this.count <= 0;
    }
    
    public boolean isFull() {
    	return this.count >= data.length;
    }

 // Devuelve el número de elementos en la cola.
    public int size() {
        return this.count;
    }
    
//==========================================================================================
    //region Métodos de la Cola

    // Operación EnQueue en la teoría de Estructura de Datos
    //
    // Inserta el elemento especificado en esta cola si es posible hacerlo
    // inmediatamente sin violar las restricciones de capacidad, devolviendo true
    // en caso de éxito y lanzando IllegalStateException si no hay espacio disponible.
    public boolean add(ELEMENT element) {

        if (this.size() >= this.data.length) {
            throw new IllegalStateException("Cola llena ...");
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }
    // Operación EnQueue en la teoría de Estructura de Datos
    //
    // Inserta el elemento especificado en esta cola si es posible hacerlo
    // inmediatamente sin violar las restricciones de capacidad. Al usar una
    // cola con capacidad restringida, este método es generalmente preferible a add(E),
    // que puede fallar al insertar un elemento solo lanzando una excepción.
    
    public boolean offer(ELEMENT element) {

        if (this.size() >= this.data.length) {
            return false;
        }

        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }
  //==========================================================================================
    // Operación DeQueue en la teoría de Estructura de Datos
    //
    // Recupera y elimina la cabeza de esta cola. Este método difiere de poll()
    // solo en que lanza una excepción si esta cola está vacía.
    public ELEMENT remove() {
        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }
    
    // Operación DeQueue en la teoría de Estructura de Datos
    //
    // Recupera y elimina la cabeza de esta cola, o devuelve null si esta cola
    // está vacía.
    
    
    public ELEMENT pool() {
        if (this.size() <= 0) {
            return null;
        }

        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;

        return result;
    }

  //==========================================================================================
    // Operación peek en la teoría de Estructura de Datos
    //
    // Recupera, pero no elimina, la cabeza de esta cola. Este método difiere
    // de peek solo en que lanza una excepción si esta cola está vacía.
    public ELEMENT element() {

        if (this.size() <= 0) {
            throw new IllegalStateException("Cola vacía ...");
        }

        return this.data[this.head];
    }
    // Recupera, pero no elimina, la cabeza de esta cola, o devuelve null si
    // esta cola está vacía.
    public ELEMENT peek() {
        if (this.size() <= 0) {
            return null;
        }

        return this.data[this.head];
    }
  //==========================================================================================


    //region Métodos básicos de Object sobreescritos

    @Override
    public String toString() {

        if (this.size() <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());

        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }

        sb.append("]");
        return sb.toString();
    }



    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for (int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
    //endregion

    //region Métodos del Caso Ejemplo b)

    public static Queue<Object> union(Queue<?> stack1, Queue<?> stack2) {

        Queue<Object> result = new Queue<Object>(stack1.size() + stack2.size());

        for (int pos = stack1.head, cta = stack1.size(); cta > 0; pos = stack1.next(pos), --cta) {
            result.offer(stack1.data[pos]);
        }
        for (int pos = stack2.head, cta = stack2.size(); cta > 0; pos = stack2.next(pos), --cta) {
            result.offer(stack2.data[pos]);
        }

        return result;
    }

    public Queue<Object> union(Queue<?> stack2) {
        return Queue.union(this, stack2);
    }
    //endregion

}
