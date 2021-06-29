package kata;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class MergeIterator<E> implements Iterator<E> {
  private final LinkedList<Iterator<E>> iterators;

  @SafeVarargs
  public MergeIterator(Iterator<E>... iterator) {
    this.iterators = new LinkedList<>();
    Arrays.asList(iterator).forEach(iterators::addLast);
  }

  @SafeVarargs
  public MergeIterator(Iterable<E>... iterable) {
    this.iterators = new LinkedList<>();
    Arrays.stream(iterable)
      .map(Iterable::iterator)
      .forEach(iterators::addLast);
  }

  @Override
  public boolean hasNext() {
    return iterators.stream()
      .anyMatch(Iterator::hasNext);
  }

  @Override
  public E next() {
    Iterator<E> result = iterators.stream()
      .filter(Iterator::hasNext)
      .findFirst()
      .orElseThrow();
    return result.next();
  }
}
