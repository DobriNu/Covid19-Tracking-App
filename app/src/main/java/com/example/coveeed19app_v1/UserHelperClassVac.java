package com.example.coveeed19app_v1;

public class UserHelperClassVac {

    String name, cnp, phone, mail, city, center;

    public UserHelperClassVac() {
    }

    public UserHelperClassVac(String name, String cnp, String phone, String mail, String city, String center) {
        this.name = name;
        this.cnp = cnp;
        this.phone = phone;
        this.mail = mail;
        this.city = city;
        this.center = center;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }
}
