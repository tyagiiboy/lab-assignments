package com.shopcart.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Users {
	
	private Map<String, User> customers;
	private Map<String, User> admins;
	private static final String ADMIN_FILE = "db/admins.bin";
	private static final String CUSTOMER_FILE = "db/customers.bin";

	public Users() throws IOException {
		loadAll();
	}

	@SuppressWarnings("unchecked")
	private void loadAdmins() throws IOException {
		File file = new File(ADMIN_FILE);

		if (!file.exists()) {
			file.createNewFile();
			admins = new HashMap<>();
			User admin = new User("admin", "admin", "Administrator");
			admins.put(admin.getUserName(), admin);

			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
				oos.writeObject(admins);
				oos.flush();
			}
		} else {

			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				try {
					Object obj = ois.readObject();
					admins = (HashMap<String, User>)obj;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void loadCustomers() {
		File file = new File(CUSTOMER_FILE);

		if (!file.exists()) {
			customers = new HashMap<>();
		} else {
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
				customers = (HashMap<String, User>)ois.readObject();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void saveCustomers() {
		File file = new File(CUSTOMER_FILE);
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(customers);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void saveAdmins() {
		File file = new File(ADMIN_FILE);

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(admins);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadAll() throws IOException {
		loadCustomers();
		loadAdmins();
	}
	
	public void saveAll() {
		saveCustomers();
		saveAdmins();
	}
	
	public boolean isAdmin(String userName) {
		return admins.containsKey(userName);
	}
	
	public boolean isCustomer(String userName) {
		return customers.containsKey(userName);
	}
	
	public void addCustomer(User user) {
		if(null != user) {
			customers.put(user.getUserName(), user);
		}
	}
	
	public void addAdmin(User admin) {
		if (null != admin) {
			admins.put(admin.getUserName(), admin);
		}
	}
	
	public User getUser(String userName) {
		User user = null;
		if (isCustomer(userName)) user = customers.get(userName);
		else if (isAdmin(userName)) user = admins.get(userName);
		return user;
	}
	
	public boolean contains(String userName) {
		return (customers.containsKey(userName) || admins.containsKey(userName));
	}

	@Override
	protected void finalize() throws Throwable {
		saveAll();
	}
	
}
