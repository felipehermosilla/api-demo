package py.com.api.demo.web.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import py.com.api.demo.enums.GenderEnum;

/**
 *
 * @author felipehermosilla
 *
 */
public class UserDTO {

	private Long id;

	@JsonProperty
	private String name;

	@JsonProperty
	private String lastname;

	@JsonProperty
	private Integer age;

	@JsonProperty
	private GenderEnum gender;

	@JsonProperty
	private String phoneNumber;

	@JsonProperty
	private String email;

	@JsonProperty
	private String country;

	@JsonProperty
	private String city;

	@JsonProperty
	private String address;

	@JsonProperty
	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
