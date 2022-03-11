package repo;

import models.GeroceryItem;
import models.GroceryList;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryListDAOImpl implements GroceryListDAO{
    String url = "jdbc: postgresql://ms-fsj-db.cqc1utncxdnr.us-east-1.rds.amazonaws.com/G-list";
    String username = "postgres";
    String passwaord = "";

    @Override
    public List<GroceryList> getallListGiveUser(Integer userId) {
        List<GroceryList> lists = new ArrayList<>();

        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String sql = "select * from lists where user_id_fk = ?;";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                lists.add(new GroceryList(rs.getInt(1), rs.getString(2),rs.getInt(3)));
            }

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return lists;
    }

    @Override
    public void createList(GroceryList groceryList) {
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "insert into lists(list_name, user_id_fk) values(?,?);";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,groceryList.getName());
            ps.setInt(2,groceryList.getUserId());

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }

    @Override
    public void deleteList(Integer listId) {
        try {
            Connection con = DriverManager.getConnection(this.url,this.username,this.passwaord);
            String str = "delete from list where list_id = ?;";

            PreparedStatement ps = con.prepareStatement(str);
            ps.setInt(1,listId);

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
