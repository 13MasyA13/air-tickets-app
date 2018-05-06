package ua.khai.golik.entities;

import java.util.Date;

public class Order {

    // Default constructor

    public Order(){

    }

    // Initial constructor

    public Order(int id, Date first_date, Date second_date, double price,
                 int count_of_children, int count_of_adults, boolean isBusinessClass,
                 String from, String to){
        this.id = id;
        this.first_date = first_date;
        this.second_date = second_date;
        this.price = price;
        this.count_of_children = count_of_children;
        this.count_of_adults = count_of_adults;
        this.isBusinessClass = isBusinessClass;
        this.from = from;
        this.to = to;

    }

    // Class's fields

    private int id;
    private Date first_date;
    private Date second_date;
    private String from;
    private String to;
    private double price;
    private int count_of_children;
    private int count_of_adults;
    private boolean isBusinessClass;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFirst_date() {
        return first_date;
    }

    public void setFirst_date(Date first_date) {
        this.first_date = first_date;
    }

    public Date getSecond_date() {
        return second_date;
    }

    public void setSecond_date(Date second_date) {
        this.second_date = second_date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount_of_children() {
        return count_of_children;
    }

    public void setCount_of_children(int count_of_children) {
        this.count_of_children = count_of_children;
    }

    public int getCount_of_adults() {
        return count_of_adults;
    }

    public void setCount_of_adults(int count_of_adults) {
        this.count_of_adults = count_of_adults;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
