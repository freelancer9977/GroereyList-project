package repo;

import models.User;

import java.sql.*;

/*
* What is JDBC?
*
*
* What is needed to connected to our postgresql database on AWS using JDBC?
*       - endpoint (location of the database)(URL)
*           -systax: jdbc: postgresql://[AWS_RDS_ENDPOINT][DATABASE_NAME]
*       - username for our AWS database
*       - password for our aws database
*       - driver(need to be )
*
* Inerface and classes of JDBC[unfinished]
*   -Connection ()
*
*
* the most common error for connecting to JDBC [unfinished]
* */
public class UserDAOImpl implements UserDAO{
    String url = "jdbc:postgresql://ms-fsj-db.cqc1utncxdnr.us-east-1.rds.amazonaws.com/G-list";
    String username = "postgres";
    String passwaord = "p4ssw0rd";

    @Override
    public User getUserGivenUsername(String username) {
        User user = null;
        try {
            //retrive active connection from our database
            Connection con = DriverManager.getConnection(url, this.username,passwaord);
            String sql = "select * from users where user_username = ?;";

            //preparing our sql statement
            PreparedStatement ps = con.prepareStatement(sql);

            //we are adding the username into the quetion mark in sql statement
            ps.setString(1,username);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getTimestamp(6));
            }
            return user;
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }

        return null;
    }

    @Override
    public void createUser(User user) {
        try{
            Connection con =  DriverManager.getConnection(this.url,this.username,this.passwaord);
            String sql = "insert into users(user_username, user_password, user_first_name, user_last_name) \n" +
                    "values (?,?,?,?);";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getFistname());
            ps.setString(4,user.getLastname());

            ps.executeUpdate();

        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}
