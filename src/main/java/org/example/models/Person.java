package org.example.models;


import jakarta.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Full name must not be empty")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 30 characters")
    private String fullName;
    @NotNull(message = "Born year must not be null")
    @Min(value = 1900, message = "Born year must be greater than 1900")
    @Max(value = 2100, message = "Born year must be less than 2100")
    private int bornYear;

    public Person(int id, String fullName, int bornYear) {
        this.id = id;
        this.fullName = fullName;
        this.bornYear = bornYear;
    }

    public Person() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }
}
