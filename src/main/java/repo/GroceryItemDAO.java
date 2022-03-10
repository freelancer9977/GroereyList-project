package repo;

import models.GeroceryItem;

import java.util.List;

public interface GroceryItemDAO {
    List<GeroceryItem> getAllItemsGivenListID(Integer listId);
    void markItemInCart(Integer ItemId);
    void createItemforListWithAmount(GeroceryItem item);
    void createItemforListWithoutAmount(GeroceryItem item);
    void deleteItemFromList(Integer ItemId);
}
