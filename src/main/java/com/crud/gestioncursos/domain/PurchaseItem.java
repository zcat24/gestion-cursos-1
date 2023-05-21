package com.crud.gestioncursos.domain;

public class PurchaseItem {

    private int courseId;
    private int quantity;
    private double total;
    private boolean active;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseItemId) {
        this.courseId = courseItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
