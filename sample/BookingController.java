package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BookingController extends ConfixBooking {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField FirstName;

    @FXML
    private TextField phone_num;

    @FXML
    private DatePicker date;

    @FXML
    private TextField time;


    @FXML
    private TextField num_persons;


    @FXML
    private Button SignUpBooking;



    @FXML
    void initialize() {
        SignUpBooking.setOnAction(event -> {
           SignUpBooking.getScene().getWindow().hide();
            SignUpBooking.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/menu.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();


            signUpNewUser();
        });



    }


    private void signUpNewUser() {
            /* Connection dbConnection;
             Class.forName("com.mysql.jdbc.Driver");
             String connectionString = "jdbc:mysql://" + dbHost + ":"
                     + dbPort + "/" + dbName;
             Class.forName("com.mysql.jdbc.Driver");
             dbConnection = getConnection(connectionString
                     , dbUser, dbPass);
             */
        String name = FirstName.getText();
        String phonenumber = phone_num.getText();
        String data = String.valueOf(date.getValue());
        String timee = time.getText();
        String persons = num_persons.getText();

        UserForBooking userForBooking = new UserForBooking(name, phonenumber, data, timee, persons);
        //PackageData bd = new PackageData("Add",user);
        //Main.connect(bd);


        DBHandler dbHandler = new DBHandler();
        dbHandler.signUpUserBooking(userForBooking);

    }
    Connection dbConnection;
    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql:// jdbc:mysql://localhost:3306/Booking?useUnicode=true&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager. getConnection("jdbc:mysql://localhost:3306/Booking?useUnicode=true&serverTimezone=UTC",
                "root","root");
        return dbConnection;
    }
}

