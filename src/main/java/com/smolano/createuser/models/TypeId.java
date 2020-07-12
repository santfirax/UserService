package com.smolano.createuser.models;

public enum TypeId {
    CC("Cédula de Ciudadanía"),
    CE("Cédula de extranjeria"),
    PA("Pasaporte"),
    AS("Adulto sin identidad");


    TypeId(String description) {
        this.description = description;
    }

    private String description;

    @Override
    public String toString() {
        return "TypeId{" +
                "description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }
}
