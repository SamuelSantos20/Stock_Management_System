package enums;

public enum CategoryProduct {

	 ELETRONICOS("Eletrônicos"),
	    VESTUARIO("Vestuário"),
	    ALIMENTOS("Alimentos"),
	    BELEZA("Beleza e Cuidados Pessoais"),
	    MOVEIS("Móveis"),
	    LIVROS("Livros"),
	    ESPORTES("Esportes e Lazer"),
	    BRINQUEDOS("Brinquedos"),
	    FERRAMENTAS("Ferramentas"),
	    AUTOMOTIVO("Automotivo");

	    private String descricao;

	  

	    private CategoryProduct(String descricao) {
			this.descricao = descricao;
		}



		public String getDescricao() {
	        return descricao;
	    }
	
	
}
