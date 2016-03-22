package cs.ss.Design.Pattern.Builder;

public class User {
	private String firstName; // required
	private String lastName; // required
	private int age; // optional
	private String phone; // optional
	private String address; // optional

	public User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}
	
	public interface Builder<T extends User>{
		T build();
	}

	public static class UserBuilder implements Builder<User>{
		private final String firstName; // required
		private final String lastName; // required
		private int age; // optional
		private String phone; // optional
		private String address; // optional

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder Age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder Phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder Address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
