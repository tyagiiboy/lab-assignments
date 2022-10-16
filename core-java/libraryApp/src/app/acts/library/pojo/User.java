package app.acts.library.pojo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Comparable<User> {
	
	private static Integer START = 100;
	
	private String userId;
	private String name;
	private String email;
	public Set<Book> allotedBooks; 
	
	public User(Integer id, String email) {
		this.userId = id.toString();
	}

	public User(String name, String email) {
		Integer id = START++;
		this.userId = id.toString();
		this.name = name;
		this.email = email;
		this.allotedBooks = new HashSet<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (!(obj instanceof User)) return false;
		
		User other = (User) obj;
		return Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + "]";
	}

	@Override
	public int compareTo(User o) {
		return this.userId.compareTo(o.userId);
	}
	
}
