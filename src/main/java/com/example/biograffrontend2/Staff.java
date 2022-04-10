package com.example.biograffrontend2;

public class Staff {
    private int id;
    private String name;
    private String phone;
    private String username;
    private String password;
    private String tom;


    public Staff(String name, String phone, String username, String password, String tom){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.tom = tom;


    }

    public String getTom() {
        return tom;
    }

    public void setTom(String tom) {
        this.tom = tom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString(){
        return "Staff{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Phone='" + phone + '\'' +
                ", Username='" + username + '\'' +
                ", Password='" + password + '\'' +
                '}';


    }



}