package main;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie newmovie, int newdaysRented) {
		movie = newmovie;
		daysRented = newdaysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}
	
	public double getAmount() {
		double amount = 0;
		
		if(movie.getPriceCode()==0) {
			amount +=2;
			if(getDaysRented()>2) {
				amount += (getDaysRented() - 2)*1.5;
			}
		}
		
		if(movie.getPriceCode()==1) {
			amount += getDaysRented() * 3;
		}
		
		if(movie.getPriceCode()==2) {
			amount +=1.5;
			if(getDaysRented()>3) {
				amount += (getDaysRented() - 3)*1.5;
			}
		}
		
		return amount;
	}
	
}