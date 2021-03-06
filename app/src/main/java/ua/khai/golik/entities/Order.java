package ua.khai.golik.entities;

public class Order {

    // Default constructor

    public Order(){

    }

    // Initial constructor

    public Order(int id, int user_id, String first_date, String second_date, double priceStep, double price,
                 int count_of_children, int count_of_adults, int count_of_seats,
                 boolean isBusinessClass, String from_place, String to_place){
        this.id = id;
        this.user_id = user_id;
        this.first_date = first_date;
        this.second_date = second_date;
        this.priceStep = priceStep;
        this.price = price;
        this.count_of_children = count_of_children;
        this.count_of_adults = count_of_adults;
        this.count_of_seats = count_of_seats;
        this.isBusinessClass = isBusinessClass;
        this.from_place = from_place;
        this.to_place = to_place;

    }

    // Class's fields

    private int id;
    private int user_id;
    private String first_date;
    private String second_date;
    private String from_place;
    private String to_place;
    private double priceStep;
    private double price;
    private int count_of_children;
    private int count_of_adults;
    private int count_of_seats;
    private boolean isBusinessClass;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_date() {
        return first_date;
    }

    public void setFirst_date(String first_date) {
        this.first_date = first_date;
    }

    public String getSecond_date() {
        return second_date;
    }

    public void setSecond_date(String second_date) {
        this.second_date = second_date;
    }

    public double getPriceStep() {
        return priceStep;
    }

    public void setPriceStep(double priceStep) {
        this.priceStep = priceStep;
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

    public int getCount_of_seats() {
        return count_of_seats;
    }

    public void setCount_of_seats(int count_of_seats) {
        this.count_of_seats = count_of_seats;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }

    public String getFrom_place() {
        return from_place;
    }

    public void setFrom_place(String from_place) {
        this.from_place = from_place;
    }

    public String getTo_place() {
        return to_place;
    }

    public void setTo_place(String to_place) {
        this.to_place = to_place;
    }
}
