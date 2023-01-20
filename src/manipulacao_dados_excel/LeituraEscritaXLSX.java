package manipulacao_dados_excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeituraEscritaXLSX {
	InputStream inputStream;
	
	public LeituraEscritaXLSX(String arquivo) throws IOException {
		
		try {
			
			this.inputStream = new FileInputStream(arquivo);
			this.leituraArquivo();
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void leituraArquivo() {

		try {
			
            //Adicionar um separador entre as linhas
            System.out.print(String.format("%68s", "\n").replace(" ", "-"));
            //Titulo
            String titulo = "Listar dados do arquivo XLSX";
            int caracteres = (int) (68 - titulo.length()) / 2;
            System.out.println(String.format("%" + caracteres + "s", "") + titulo);
            //Adicionar um separador entre as linhas
            System.out.print(String.format("%68s", "\n").replace(" ", "-"));

			XSSFWorkbook workbook = new XSSFWorkbook(this.inputStream);
	
			//Selecionar a primeira SHEET/FOLHA
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			 Iterator<Row> rowIterator = sheet.iterator();
			 
			 while(rowIterator.hasNext()) {
				 XSSFRow row = (XSSFRow)rowIterator.next();
				 
				 Iterator<Cell> colunas = row.cellIterator();
				 
				 while(colunas.hasNext()) {
					 XSSFCell celula = (XSSFCell)colunas.next();
	
	                 switch (celula.getCellType()) {
	                    case NUMERIC:
	                    	double numerico = celula.getNumericCellValue();
	                        System.out.print(String.format("%15.15s", numerico));
	                        break;
	                    case STRING:
	                    	String texto = celula.getStringCellValue();
	                        System.out.print(String.format("%-15.15s", texto));
	                        break;
	                    default:
	                    	System.out.print("Cell_Type_Not_Defined;");
						break;
	                 }
	             	
					 //Adicionar um separador para as colunas
		             System.out.print("| ");
					 
				 }
	
				 //Quebra de linha quando não houver mais colunas
	             System.out.print("\n");
	             //Adicionar um separador entre as linhas
	             System.out.print(String.format("%68s", "\n").replace(" ", "-"));
				 
			 }
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
