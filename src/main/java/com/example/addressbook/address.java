package com.example.addressbook;

public class address {
    public int id;
    public String name;
    public String country;
    public String city;
    public String gender;

    public address(int id, String name, String country, String city, String gender) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", country='" + country + '\'' +
                        ", city='" + city + '\'' +
                        ", gender='" + gender + '\'';
    }
}
