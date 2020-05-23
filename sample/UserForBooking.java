package sample;

import java.io.Serializable;

public class UserForBooking implements Serializable {
    private String name;
    private String number_of_phone;
    private String date;
    private String time;
    private String number_of_persons;


    public UserForBooking() {

    }

    public UserForBooking(String name, String number_of_phone, String date, String time, String number_of_persons) {
        this.name = name;
        this.number_of_phone = number_of_phone;
        this.date = date;
        this.time = time;
        this.number_of_persons = number_of_persons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_of_phone() {
        return number_of_phone;
    }

    public void setNumber_of_phone(String number_of_phone) {
        this.number_of_phone = number_of_phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber_of_persons() {
        return number_of_persons;
    }

    public void setNumber_of_persons(String number_of_persons) {
        this.number_of_persons = number_of_persons;
    }

    @Override
    public String toString() {
        return "UserForBooking{" +
                "name='" + name + '\'' +
                ", number_of_phone='" + number_of_phone + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", number_of_persons='" + number_of_persons + '\'' +
                '}';
    }
}



