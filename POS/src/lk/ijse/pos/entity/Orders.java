package lk.ijse.pos.entity;

import java.util.Date;


public class Orders {
    private String id;
    private Date date;
    private String customerId;

    public Orders() {
    }

    public Orders(String id, Date date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Orders{" + "id=" + id + ", date=" + date + ", customerId=" + customerId + '}';
    }

}
