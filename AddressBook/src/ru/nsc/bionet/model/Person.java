package ru.nsc.bionet.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/*
 * класс-модель для адресата (Person) 
 */

public class Person {
	private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;
    
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }
}
