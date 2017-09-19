package scalehealth.scalev0.models;

import java.io.Serializable;

/**
 * Created by mayank on 9/12/17.
 */

//diagnosis field??

public class Patient implements Serializable{

    private int id;
    private int doctorId;
    private String date;
    private String name;
    private int age;
    private int sex;
    private String bloodGroup;      //  TODO: Implement hash table to convert into integer....
    private String phone;           // TODO: Implement international phone codes
    private String photoId;
    private String note;
    private String[] documents;

    public Patient() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int isSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String[] getDocuments() {
        return documents;
    }

    public void setDocuments(String[] documents) {
        this.documents = documents;
    }

}
