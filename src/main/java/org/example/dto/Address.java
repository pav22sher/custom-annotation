package org.example.dto;

import org.example.annotation.MaxLength;
import org.example.annotation.MinLength;
import org.example.annotation.NotEmpty;
import org.example.annotation.ValidBean;

@ValidBean("address")
public class Address {

    @MinLength(3)
    @MaxLength(10)
    @NotEmpty
    private String zip;
    @NotEmpty
    private String country;
    @NotEmpty
    private String addressLine;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }
}
