import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FirstClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getJson(new User("John", "Doe", 30, new Address("1st cross","Bangalore","KA","5602233")));

	}

	private static void getJson(User user) {
		ObjectMapper mapper = new ObjectMapper();

		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

		String json = null;
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(json);
		// getObj(json);

	}

	private static void getObj(String json) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

		User user = null;
		try {
			user = mapper.readValue(json, User.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		System.out.println(user.getFirstName());
//		System.out.println(user.getLastName());
//		System.out.println(user.getAge());

	}

}


class User {
	
	public User(String string, String string2, int i) {
		// TODO Auto-generated constructor stub
		this.setFirstName(string);
		this.setLastName(string2);
		this.setAge(i);

	}
	
	public User(String string, String string2, int i, Address address2) {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty("firstName")
	public String getFirstName() {
		return firstName;
	}
	@JsonProperty("firstName")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@JsonProperty("firstName")
	private String firstName;
	private String lastName;
	private Integer age;
	private Address address;
	
	
}

class Address {
	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	public Address(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
		
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


}
