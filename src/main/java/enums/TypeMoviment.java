package enums;

public enum TypeMoviment {

	ENTRADA("Entrada"),
	
	SAIDA("Saida");
	
	
	
	
	private TypeMoviment(String typeMoviment) {
		this.typeMoviment = typeMoviment;
	}


	public String getTypeMoviment() {
		return typeMoviment;
	}

	
	private String typeMoviment;
	
	
}
