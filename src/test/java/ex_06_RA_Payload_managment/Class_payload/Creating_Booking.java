package ex_06_RA_Payload_managment.Class_payload;

public class Creating_Booking {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private boolean additionalneeds;
    private Booking_Date bookingdate;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public boolean isAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(boolean additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    public Booking_Date getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(Booking_Date bookingdate) {
        this.bookingdate = bookingdate;
    }


}
