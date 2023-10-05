package com.project.Restaurant_Managementv2.dto.product;

public class ProductDto {
    private short id;
    private String name;
    private String country;
    private String img;
    private Double price;
    private short rate;
    private String categoryName;

    public ProductDto(){

    }

//    public ProductDto(String name, String country, String img, BigDecimal price, short rate, String categoryName) {
//        this.name = name;
//        this.country = country;
//        this.img = img;
//        this.price = price;
//        this.rate = rate;
//        this.categoryName = categoryName;
//    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public short getRate() {
        return rate;
    }

    public void setRate(short rate) {
        this.rate = rate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
