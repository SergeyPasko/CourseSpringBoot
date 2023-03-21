package lesson38.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class CustomerRequest {

    @NotNull
    @Positive
    private Integer customerNumber;
    @NotBlank
    private String customerName;
    @NotBlank
    private String contactLastName;
    @NotBlank
    private String contactFirstName;
    @NotBlank
    private String phone;
    @NotNull
    private String addressLine1;
    private String addressLine2;
    @NotBlank
    private String city;
    @Pattern(regexp = "[a-zA-z]{2,}")
    private String state;
    private String postalCode;
    private String country;
    @NotNull
    private BigDecimal creditLimit;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
                + contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addressLine1="
                + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city + ", state=" + state
                + ", postalCode=" + postalCode + ", country=" + country + ", creditLimit=" + creditLimit + "]";
    }

}
