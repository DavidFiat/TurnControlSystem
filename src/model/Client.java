package model;

public class Client {

	private String typeOfDocument;
	private String ID;
	private String name;
	private String surnames;
	private String phone;
	private String address;

	public Client(String typeOfDocument, String ID, String name, String surnames, String phone, String address) {
		this.typeOfDocument = typeOfDocument;
		this.ID = ID;
		this.name = name;
		this.surnames = surnames;
		this.phone = phone;
		this.address = address;
	}

	public String getTypeOfDocument() {
		return typeOfDocument;
	}

	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
