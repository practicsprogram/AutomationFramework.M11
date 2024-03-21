package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Sandeep Anand
 */

public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel File and return the value to Caller
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		
		return value;
	}
}
