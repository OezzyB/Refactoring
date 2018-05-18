package main;

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

	public String getCustomerInfo() {
		String result = "Rental Record for " + getName() + System.lineSeparator();
		result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + System.lineSeparator();

		for (Rental eachRental : rentals) {
			result += eachRental.getRentalInfo();
		}

		result += "Amount owed is " + getTotalAmount() + System.lineSeparator();
		result += "You earned " + getFrequentRenterPoints() + " frequent renter points";
		return result;
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for (Rental each : rentals) {
			totalAmount += each.getAmount();
		}
		return totalAmount;
	}
	
	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		frequentRenterPoints += rentals.size();
		for (Rental r : rentals) {
			if (r.getMovie().getPriceCode() == Movie.NEW_RELEASE && r.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
		}
		return frequentRenterPoints;
	}
}
