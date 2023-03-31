package com.example.mukul;

public class Data {
    private final String price;
    private final String country;
    private final String district;
    private final String phone;
    private final String propertyType;
    private final String location;
    private final String radioButtonValue;

    public Data(String price, String country, String district, String phone, String propertyType, String location, String radioButtonValue) {
        this.price = price;
        this.country = country;
        this.district = district;
        this.phone = phone;
        this.propertyType = propertyType;
        this.location = location;
        this.radioButtonValue = radioButtonValue;
    }

    public String getPrice() {
        return price;
    }

    public String getCountry() {
        return country;
    }

    public String getDistrict() {
        return district;
    }

    public String getPhone() {
        return phone;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public String getLocation() {
        return location;
    }

    public String getRadioButtonValue() {
        return radioButtonValue;
    }
}

