package main;

import java.lang.*;
import java.util.*;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	};

	public String getName() {
		return name;
	};

	// public String statement() {
	// double totalAmount = 0;
	// int frequentRenterPoints = 0;
	// Enumeration enum_rentals = rentals.elements();
	// String result = "Rental Record for " + this.getName() + "\n";
	// result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
	//
	// while (enum_rentals.hasMoreElements()) {
	// double thisAmount = 0;
	// Rental each = (Rental) enum_rentals.nextElement();
	// // determine amounts for each line
	// thisAmount = amountFor(each);
	// // add frequent renter points
	// frequentRenterPoints++;
	// // add bonus for a two day new release rental
	// if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
	// each.getDaysRented() > 1)
	// frequentRenterPoints++;
	// // show figures for this rental
	// result += "\t" + each.getMovie().getTitle() + "\t" + "\t" +
	// each.getDaysRented() + "\t"
	// + String.valueOf(thisAmount) + "\n";
	// totalAmount += thisAmount;
	// }
	// // add footer lines
	// result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
	// result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent
	// renter points";
	// return result;
	// }

	public String getCustomerInfo() {
		String result = "Rental Record for " + getName() + System.lineSeparator();
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + System.lineSeparator();

		for (Rental eachRental : rentals) {
			result += eachRental.getRentalInfo();
		}

		result += "Amount owed is " + getTotalAmount() + System.lineSeparator();
		return result;
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : rentals) {
			totalAmount += each.getAmount();
		}
		return totalAmount;
	}
}
