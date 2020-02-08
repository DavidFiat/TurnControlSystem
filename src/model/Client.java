package model;

public class Client {

	private String typeOfDocument;
	private String ID;
	private String name;
	private String surnames;
	private int phone;
	private String address;

	public Client(String typeOfDocument, String iD, String name, String surnames, int phone, String address) {
		super();
		this.typeOfDocument = typeOfDocument;
		ID = iD;
		this.name = name;
		this.surnames = surnames;
		this.phone = phone;
		this.address = address;
	}

	public Client(String typeOfDocument, String iD, String name, String surnames) {
		super();
		this.typeOfDocument = typeOfDocument;
		ID = iD;
		this.name = name;
		this.surnames = surnames;

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

	public void setID(String iD) {
		ID = iD;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
