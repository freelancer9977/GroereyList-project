package repo;

import models.GroceryList;

import java.util.List;

public interface GroceryListDAO {
    List<GroceryList> getallListGiveUser(Integer userId);
    void createList(GroceryList groceryList);
    void deleteList(Integer listId);
}
