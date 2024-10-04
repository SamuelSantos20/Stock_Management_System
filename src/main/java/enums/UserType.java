package enums;

public enum UserType {

	ADM("ADM");

	private UserType(String typeUser) {
		this.typeUser = typeUser;
	}

	public String getTypeUser() {
		return typeUser;
	}

	private String typeUser;

}
