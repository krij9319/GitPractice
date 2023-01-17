package kadaidto;

public class Kadai1dto {
	private String name;
	private int age;
	private String gender;
	private String phototel;
	private String mail;
	private String salt;
	private String pw;
	private String hashedpw;
	
	public Kadai1dto(String name, int age, String gender, String phototel, String mail, String salt, String pw,
			String hashedpw) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.phototel = phototel;
		this.mail = mail;
		this.salt = salt;
		this.pw = pw;
		this.hashedpw = hashedpw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhototel() {
		return phototel;
	}

	public void setPhototel(String phototel) {
		this.phototel = phototel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getHashedpw() {
		return hashedpw;
	}

	public void setHashedpw(String hashedpw) {
		this.hashedpw = hashedpw;
	}
}