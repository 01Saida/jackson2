import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
class User {
	
	public User(String string, String string2, int i, Address address2) {
		this.firstName = string;
		this.lastName = string2;
		this.age = i;
		this.address = address2;
	}
	
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
		this.street = string;
		this.city = string2;
		this.state = string3;
		this.zipCode = string4;
	}
}
