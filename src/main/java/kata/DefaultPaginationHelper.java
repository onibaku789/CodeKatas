package kata;

import java.util.List;

public class DefaultPaginationHelper<I> implements PaginationHelper<I> {
  private final List<I> pages;
  private final int itemsPerPage;

  public DefaultPaginationHelper(List<I> collection, int itemsPerPage) {
    this.pages = collection;
    this.itemsPerPage = itemsPerPage;
  }

  @Override
  public int itemCount() {
    return pages.size();
  }

  @Override
  public int pageCount() {
    return (int) Math.ceil(itemCount() / (double) itemsPerPage);
  }

  @Override
  public int pageItemCount(int pageIndex) {
    if (pageIndex + 1 < pageCount()) {
      return itemsPerPage;
    } else if (pageIndex + 1 == pageCount()) {
      return pages.size() % itemsPerPage;
    }
    return -1;
  }

  @Override
  public int pageIndex(int itemIndex) {
    if (itemIndex < 0 || itemIndex >= itemCount()) {
      return -1;
    }
    return itemIndex / itemsPerPage;
  }
}
