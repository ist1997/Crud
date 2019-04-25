package model;

public class Footballer {

    private int id;
    private String name;
    private String team;
    private String nationality;
    private double price;

    public Footballer() {
    }

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

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getNationality() {
        return nationality;
    }

    public double getPrice() {
        return price;
    }
}
