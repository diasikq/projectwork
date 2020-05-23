package sample;
import java.sql.*;
import java.util.ArrayList;

public class DBHandler extends ConfixBooking {
    Connection dbConnection;


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String connectionString = "jdbc:mysql://localhost:3306/Booking?useUnicode=true&serverTimezone=UTC";
        dbConnection = DriverManager.getConnection(connectionString, "root",
                "root");
        return  dbConnection;
    }
    public void signUpUserBooking(UserForBooking userForBooking){
        ArrayList<UserForBooking> userForBookings = new ArrayList<>();
        String insert = "INSERT " + ConstantBooking.USER_TABLE + "(" +
                ConstantBooking.USER_NAME + "," + ConstantBooking.USER_PHONE+ ","
                + ConstantBooking.USER_DATE + "," + ConstantBooking.USER_TIME + ","
                + ConstantBooking.USER_PERSONS + ")"
                + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1,userForBooking.getName());
            prSt.setString(2, userForBooking.getNumber_of_phone());
            prSt.setString(3, userForBooking.getDate());
            prSt.setString(4, userForBooking.getTime());
            prSt.setString(5, userForBooking.getNumber_of_persons());
            prSt.executeUpdate();
            prSt.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}




