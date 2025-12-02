import java.util.*;

public class CSLinkedList<E> extends AbstractList<E> {

  private static final class Node<E> {
    E data;
    Node<E> next;
    Node(E d, Node<E> n) { data = d; next = n; }
  }

  private final Node<E> head;
  private Node<E> tail;
  private int size;

  public CSLinkedList() {
    head = new Node<>(null, null);
    tail = null;
    size = 0;
  }

  @Override
  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }

  private void checkElementIndex(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private void checkPositionIndex(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException("index=" + index + ", size=" + size);
  }

  private Node<E> nodeAt(int index) {
    checkElementIndex(index);
    Node<E> cur = head.next;
    for (int i = 0; i < index; i++) cur = cur.next;
    return cur;
  }

  @Override
  public boolean add(E e) {
    Node<E> n = new Node<>(e, null);
    if (size == 0) {
      head.next = n;
      tail = n;
    } else {
      tail.next = n;
      tail = n;
    }
    size++;
    modCount++;
    return true;
  }

  @Override
  public void add(int index, E e) {
    checkPositionIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> n = new Node<>(e, prev.next);
    prev.next = n;
    if (index == size) tail = n;
    size++;
    modCount++;
  }

  @Override
  public E get(int index) {
    return nodeAt(index).data;
  }

  @Override
  public E set(int index, E e) {
    Node<E> n = nodeAt(index);
    E old = n.data;
    n.data = e;
    return old;
  }

  @Override
  public E remove(int index) {
    checkElementIndex(index);
    Node<E> prev = (index == 0) ? head : nodeAt(index - 1);
    Node<E> target = prev.next;
    prev.next = target.next;
    if (target == tail) {
      tail = (prev == head && prev.next == null) ? null : prev;
    }
    size--;
    modCount++;
    return target.data;
  }
  //LL3
  public boolean addIfAbsent(E item) {
      for (int i = 0; i < size(); i++) {
          if (get(i).equals(item)) {
              return false;
          }
      }
      add(item);
      return true;
  }
  //LL5
  public void moveToFront(E item) {
      if (item == null || size == 0) return;
      Node<E> prev = head;
      Node<E> current = head.next;
      while (current != null) {
          if (current.data.equals(item)) {
              prev.next = current.next;
              current.next = head.next;
              head.next = current;
              if (current.next == null) {
                  tail = current;
              }
              return;
          }
          prev = current;
          current = current.next;
      }
  }
//LL6
  public boolean addAfter(E target, E newItem) {
      for (Node<E> cur = head.next; cur != null; cur = cur.next) {
          if (cur.data.equals(target)) {
              Node<E> newNode = new Node<>(newItem, cur.next);
              cur.next = newNode;
              if (cur == tail) tail = newNode;
              size++;
              modCount++;
              return true;
          }
      }
      return false;
  }
//LL8
  public void addInOrder(E item, Comparator<E> timeCmp) {
      if (isEmpty()) {
          add(item);
          return;
      }
      Node<E> prev = head;
      Node<E> current = head.next;
      while (current != null && timeCmp.compare(current.data, item) <= 0) {
          prev = current;
          current = current.next;
      }
      Node<E> newNode = new Node<>(item, current);
      prev.next = newNode;
      if (current == null) {
          tail = newNode;
      }
      size++;
      modCount++;
  }
//LL9
  public boolean removeFirstOccurrence(E item) {
      if (isEmpty()) return false;
      Node<E> prev = head;
      Node<E> current = head.next;
      while (current != null) {
          if (current.data.equals(item)) {
              prev.next = current.next;
              if (current == tail) tail = prev == head && prev.next == null ? null : prev;
              size--;
              modCount++;
              return true;
          }
          prev = current;
          current = current.next;
      }
      return false;
  }
  //LL10
  public CSLinkedList<E> copy() {
      CSLinkedList<E> newList = new CSLinkedList<>();
      for (E item : this) {
          newList.add(item);
      }
      return newList;
  }

    @Override
  public int indexOf(Object o) {
    int i = 0;
    for (Node<E> cur = head.next; cur != null; cur = cur.next, i++) {
      if (o == null ? cur.data == null : o.equals(cur.data)) return i;
    }
    return -1;
  }

  @Override
  public void clear() {
    head.next = null;
    tail = null;
    size = 0;
    modCount++;
  }

  @Override
  public Iterator<E> iterator() {
    return new Itr();
  }

  private final class Itr implements Iterator<E> {
    private Node<E> prev = head;
    private Node<E> cursor = head.next;
    private Node<E> lastPrev = null;
    private Node<E> lastRet = null;
    private int expectedMod = modCount;

    @Override
    public boolean hasNext() { return cursor != null; }

    @Override
    public E next() {
      checkForComod();
      if (cursor == null) throw new NoSuchElementException();
      lastPrev = prev;
      lastRet = cursor;
      prev = cursor;
      cursor = cursor.next;
      return lastRet.data;
    }

    @Override
    public void remove() {
      checkForComod();
      if (lastRet == null) throw new IllegalStateException();
      lastPrev.next = lastRet.next;
      if (lastRet == tail) {
        tail = (lastPrev == head && lastPrev.next == null) ? null : lastPrev;
      }
      size--;
      modCount++;
      expectedMod++;
      lastRet = null;
    }

    private void checkForComod() {
      if (expectedMod != modCount) throw new ConcurrentModificationException();
    }
  }
}
