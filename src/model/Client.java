package model;

public class Client {

	private String typeOfDocument;
	private String ID;
	private String name;
	private String surnames;
	private String phone;
	private String address;

	/**
	 * Description: This it the constructor method of Client class. <br>
	 * 
	 * @param typeOfDocument It is the type of client's document.
	 * @param ID It is client's identification.
	 * @param name It is client's name.
	 * @param surnames It is client's surnames.
	 * @param phone It is client's phone number.
	 * @param address It is client's address.
	 */
	public Client(String typeOfDocument, String ID, String name, String surnames, String phone, String address) {
		this.typeOfDocument = typeOfDocument;
		this.ID = ID;
		this.name = name;
		this.surnames = surnames;
		this.phone = phone;
		this.address = address;
	}

	/**
	 * Description: This method gives us the client's type of document. <br>
	 * 
	 * @return client's type of document.
	 */
	public String getTypeOfDocument() {
		return typeOfDocument;
	}

	/**
	 * Description: This method change client's type of document. <br>
	 * <b>post: </b> The type of document had been changed.
	 * 
	 * @param typeOfDocument is a String that sets client's type of document.
	 */
	public void setTypeOfDocument(String typeOfDocument) {
		this.typeOfDocument = typeOfDocument;
	}

	/**
	 * Description: This method gives us the client's ID. <br>
	 * 
	 * @return client's ID.
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Description: This method change client's ID. <br>
	 * <b>post: </b> The ID had been changed.
	 * 
	 * @param ID is a String that sets client's ID.
	 */
	public void setID(String ID) {
		this.ID = ID;
	}

	/**
	 * Description: This method gives us the client's name. <br>
	 * 
	 * @return client's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Description: This method change client's name. <br>
	 * <b>post: </b> The name had been changed.
	 * 
	 * @param name is a String that sets client's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Description: This method gives us the client's surnames. <br>
	 * 
	 * @return client's surnames.
	 */
	public String getSurnames() {
		return surnames;
	}

	/**
	 * Description: This method change client's surnames. <br>
	 * <b>post: </b> The surnames had been changed.
	 * 
	 * @param surnames is a String that sets client's surnames.
	 */
	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	/**
	 * Description: This method gives us the client's phone number. <br>
	 * 
	 * @return client's phone.
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Description: This method change client's phone number. <br>
	 * <b>post: </b> The phone had been changed.
	 * 
	 * @param phone is a String that sets client's phone number.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Description: This method gives us the client's address. <br>
	 * 
	 * @return client's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Description: This method change client's address. <br>
	 * <b>post: </b> The address had been changed.
	 * 
	 * @param address is a String that sets client's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
