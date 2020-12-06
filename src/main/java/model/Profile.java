package model;

public class Profile {

	private String profileID;
	private String OwnerSSN;
	// private String profileName;
	private int age;
	private int DatingAgeRangeStart;
	private int DatingAgeRangeEnd;
	private int geoRange;
	// private String address;
	private String gender;
	// private String phy_char;
	private String hobbies;
	private int height;
	private int weight;
	private String HairColor;
	// private String photo;
	// private String ageRange;
	private String CreationDate;
	private String LastModDate;

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	/*
	 * public String getProfileName() { return profileName; }
	 * 
	 * public void setProfileName(String profileName) { this.profileName =
	 * profileName; }
	 */

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 */

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public String getPhy_char() { return phy_char; }
	 * 
	 * public void setPhy_char(String phy_char) { this.phy_char = phy_char; }
	 * 
	 * 
	 * public String getInterests() { return interests; }
	 * 
	 * public void setInterests(String interests) { this.interests = interests; }
	 * 
	 * public String getPhoto() { return photo; }
	 * 
	 * public void setPhoto(String photo) { this.photo = photo; }
	 * 
	 * public String getAgeRange() { return ageRange; }
	 * 
	 * public void setAgeRange(String ageRange) { this.ageRange = ageRange; }
	 * 
	 */

	public int getGeoRange() {
		return geoRange;
	}

	public void setGeoRange(int geoRange) {
		this.geoRange = geoRange;
	}

	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getLastModDate() {
		return LastModDate;
	}

	public void setLastModDate(String lastModDate) {
		LastModDate = lastModDate;
	}

	public String getHairColor() {
		return HairColor;
	}

	public void setHairColor(String hairColor) {
		HairColor = hairColor;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public int getDatingAgeRangeEnd() {
		return DatingAgeRangeEnd;
	}

	public void setDatingAgeRangeEnd(int datingAgeRangeEnd) {
		DatingAgeRangeEnd = datingAgeRangeEnd;
	}

	public int getDatingAgeRangeStart() {
		return DatingAgeRangeStart;
	}

	public void setDatingAgeRangeStart(int datingAgeRangeStart) {
		DatingAgeRangeStart = datingAgeRangeStart;
	}

	public String getOwnerSSN() {
		return OwnerSSN;
	}

	public void setOwnerSSN(String ownerSSN) {
		OwnerSSN = ownerSSN;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
