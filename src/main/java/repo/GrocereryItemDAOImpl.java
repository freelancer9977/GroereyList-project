package repo;

import models.GeroceryItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GrocereryItemDAOImpl implements GroceryItemDAO{
    String url = "";
    String username = "postgres";
    String passwaord = "";

    @Override
    public List<GeroceryItem> getAllItemsGivenListID(Integer listId) {
        List<GeroceryItem> item = new ArrayList<>();

        try{
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String sql = "select * from items where list_id_fk = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,listId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                item.add(new GeroceryItem(
                        rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getBoolean(4),rs.getInt(5)));
            }


        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return item;
    }

    @Override
    public void markItemInCart(Integer ItemId) {
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "update items set item_in_cart = true where item_id = ?;";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setInt(1,ItemId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

    }

    @Override
    public void createItemforListWithAmount(GeroceryItem item) {
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "insert into items(item_name ,list_id_fk)\n" +
                    "values (?,?,?);";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,item.getName());
            ps.setInt(2,item.getAmount());
            ps.setInt(3,item.getId());

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    public void createItemforListWithoutAmount(GeroceryItem item){
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "insert into items(item_name ,list_id_fk)\n" +
                    "values (?,?);";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,item.getName());
            ps.setInt(2,item.getId());

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteItemFromList(Integer ItemId) {
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "delete from items where item_id = ?;";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setInt(1,ItemId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
