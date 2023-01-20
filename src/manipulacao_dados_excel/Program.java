package manipulacao_dados_excel;

public class Program {
	
	public Program() throws Exception {
		LeituraEscritaXLS leituraEscritaXLS = new LeituraEscritaXLS("testeXLS.xls");
		LeituraEscritaXLSX leituraEscritaXLSX = new LeituraEscritaXLSX("testeXLSX.xlsx");
	}

	public static void main(String[] args) {

		try {
			new Program();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
