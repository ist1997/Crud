package model;

public class Footballer {

    private int id;
    private String name;
    private String team;
    private String nationality;
    private double price;


    public Footballer(String name, String team, String nationality, double price) {
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.price = price;
    }

    public Footballer(int id, String name, String team, String nationality, double price) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.nationality = nationality;
        this.price = price;
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

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
