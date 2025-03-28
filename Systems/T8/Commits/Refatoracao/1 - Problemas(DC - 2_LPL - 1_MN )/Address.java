package br.sistemalojaroupas.model.entities;

public class Address {

    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String number;

    public Address() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Address{cep= '%s', state= '%s', city= '%s', neighborhood= '%s', street= '%s', number= '%s'}",cep, state, city, neighborhood, street, number);
    }


}
