package infoClass;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int number;
    private double salary;

    Player(){
        this.name = "";
        this.country = "";
        this.age = 0;
        this.height = 0.0;
        this.club = "";
        this.position = "";
        this.number = 0;
        this.salary = 0.0;
    }

    Player(String name, String country, int age, double height, String club, String position, int number, double salary){
        this.name = name;
        this.country = country;
        this.age = age;
        this.height = height;
        this.club = club;
        this.position = position;
        this.number = number;
        this.salary = salary;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setClub(String club){
        this.club = club;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setNumber(int number){
        this.number = number;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public String getCountry(){
        return this.country;
    }
    public int getAge(){
        return this.age;
    }
    public double getHeight(){
        return this.height;
    }
    public String getClub(){
        return this.club;
    }
    public String getPosition(){
        return this.position;
    }
    public int getNumber(){
        return this.number;
    }
    public double getSalary(){
        return this.salary;
    }

    public String toString(){
        return name + ", " + country + ", " + age + ", " + height + ", " + club + ", " + position + ", " + number + ", " + salary;
    }

}
