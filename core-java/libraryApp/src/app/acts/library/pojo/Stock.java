package app.acts.library.pojo;

public class Stock implements Comparable<Stock> {
	
	public Book book;
	private Integer total;
	private Integer rented;

	public Stock(Book book) {
		this.book = book;
		this.total = 0;
		this.rented = 0;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRented() {
		return rented;
	}

	public void setRented(Integer rented) {
		this.rented = rented;
	}
	
	@Override
	public int hashCode() {
		return book.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (!(obj instanceof Stock)) return false;
		
		Stock other = (Stock) obj;
		return this.book.equals(other.book);
	}

	@Override
	public int compareTo(Stock o) {
		return this.total.compareTo(o.total);
	}

	@Override
	public String toString() {
		return "\n" + book.toString();
	}
	
}
