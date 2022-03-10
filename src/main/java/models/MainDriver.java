package models;

import repo.*;

public class MainDriver {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAOImpl();
        GroceryListDAO groceryListDAO = new GroceryListDAOImpl();
        GroceryItemDAO groceryItemDAO = new GrocereryItemDAOImpl();

        userDAO.createUser(new User("Matthew","pass123","m","s"));

        //System.out.println(userDAO.getUserGivenUsername("user1"));

        //groceryListDAO.createList(new GroceryList("Safeway",4));

        //groceryItemDAO.createItemforListWithoutAmount(new GeroceryItem("Banna",null,6));
    }
}
