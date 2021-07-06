package kata;

public interface PaginationHelper<I> {

  /**
   * returns the number of items within the entire collection
   */
  int itemCount();

  /**
   * returns the number of pages
   */
  int pageCount();

  /**
   * returns the number of items on the current page. page_index is zero based.
   * this method should return -1 for pageIndex values that are out of range
   */
  int pageItemCount(int pageIndex);

  /**
   * determines what page an item is on. Zero based indexes
   * this method should return -1 for itemIndex values that are out of range
   */
  int pageIndex(int itemIndex);
}
