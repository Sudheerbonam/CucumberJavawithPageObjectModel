package entities;

public class CreateHotelBooking {
    private String firstName;
    private String surname;
    private String price;
    private String deposit;
    private String checkIn;
    private String checkOut;

    public CreateHotelBooking(String firstName, String surname, String price, String deposit, String checkIn, String checkOut) {
        this.firstName = firstName;
        this.surname = surname;
        this.price = price;
        this.deposit = deposit;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
//Setters
    public String getFirstName() {
        return firstName;
    }
    public String getSurname() {  return surname;    }
    public String getPrice() {
        return price;
    }
    public String getDeposit() {
        return deposit;
    }
    public String getCheckIn() {
        return checkIn;
    }
    public String getCheckOut() {
        return checkOut;
    }
//Getters
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }
    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }
    public void setPrice(String price) {     this.price = price;     }



}
