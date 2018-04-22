package ru.nsc.bionet.address.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
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
    
/*
 * конструкторы
 */
    public Person() {
    	String firstName = "Иван";
    	String lastName = "";
    	String street = "";
    	int postalCode = 630000;
    	String city = "N-sk";
    	LocalDate birthday = LocalDate.of(1900, 01, 01);
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    	this.setStreet(street);
    	setPostalCode(postalCode);
    	setCity(city);
    	setBirthday(birthday);
    }

 /*
  * методы для имени
  */
    public String getFirstName() {
		return firstName.get();
	}
    public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
    public StringProperty firstNameProperty() {
    	return firstName;
    }
		
/*
 * методы для фамилии		
 */
    public String getLastName() {
		return lastName.get();
	}
    public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}
    public StringProperty lastNameProperty() {
    	return lastName;
    }
	
/*
 * методы для улицы
 */
    public String getStreet() {
		return street.get();
	}
    public void setStreet(String street) {
		this.street.set(street);
	}
    public StringProperty streetProperty() {
    	return street;
    }

/*
 * методы для индекса
 */
    public int getPostalCode() {
		return postalCode.get();
	}
    public void setPostalCode(int postalCode) {
		this.postalCode.set(postalCode);
	}
    public IntegerProperty postalCodeProperty() {
    	return postalCode;
    }

/*
 * методы для города
 */
    public String getCity() {
		return city.get();
	}
    public void setCity(String city) {
		this.city.set(city);
	}
    public StringProperty cityProperty() {
    	return city;
    }

/*
 * методы для дня рождения
 */
    public LocalDate getBirthday() {
		return birthday.get();
	}
    public void setBirthday(LocalDate birthday) {
		this.birthday.set(birthday);
	}
	public ObjectProperty<LocalDate> Birthday() {
		return birthday;
	}
}