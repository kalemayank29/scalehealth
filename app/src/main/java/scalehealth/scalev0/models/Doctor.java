package scalehealth.scalev0.models;

/**
 * Created by mayank on 9/12/17.
 */

public class Doctor {

    private int id;
    private String date;
    private boolean oncologist;
    private double latitude;
    private double longitude;
    private String name;
    private String phone;
    private String username;
    private String password;

    public Doctor() {
    }

    public Doctor(boolean oncologist, double latitude, double longitude, String name, String phone, String username, String password) {
        this.oncologist = oncologist;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isOncologist() {
        return oncologist;
    }

    public void setOncologist(boolean oncologist) {
        this.oncologist = oncologist;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
