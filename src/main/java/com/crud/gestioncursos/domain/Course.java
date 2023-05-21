package com.crud.gestioncursos.domain;

public class Course {

    private Integer courseId;
    private String name;
    private Integer categoryId;
    private Double price;
    private Integer capacityCourse;
    private boolean active;
    private Category category;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCapacityCourse() {
        return capacityCourse;
    }

    public void setCapacityCourse(Integer capacityCourse) {
        this.capacityCourse = capacityCourse;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
