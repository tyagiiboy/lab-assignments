package app.acts.library.pojo;

import java.util.Objects;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private String publishDate;
	
	public Book() {
		
	}

	public Book(String title, String author, String publisher, String publishDate) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, publisher, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (!(obj instanceof Book)) return false;
		
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(publisher, other.publisher)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", publisher=" + publisher + ", publishDate="
				+ publishDate + "]";
	}
	
}