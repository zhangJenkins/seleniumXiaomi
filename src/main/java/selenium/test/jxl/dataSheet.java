package selenium.test.jxl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class dataSheet {
	static Workbook wbook;
	static WritableWorkbook wwbCopy;
	static String ExecutedTestCasesSheet;
	static WritableSheet shSheet;

	public void readExcel() {
		try {
			wbook = Workbook.getWorkbook(new File("D:\\Dev\\SampleTest\\datasheets\\testSampleData.xls"));
			wwbCopy = Workbook.createWorkbook(new File("D:\\Dev\\SampleTest\\datasheets\\testSampleDataCopy.xls"),wbook);
			shSheet = wwbCopy.getSheet(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void readExcel(String FilePath,String sheetName) throws BiffException, IOException {
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		// TO get the access to the sheet
		Sheet sh = wb.getSheet(sheetName);
		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();
		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				System.out.print(sh.getCell(col, row).getContents() + "\t");
			}
			System.out.println();
		}
	}
	

	@SuppressWarnings("deprecation")
	public void setValueIntoCell(String strSheetName, int iColumnNumber, int iRowNumber, String strData) throws WriteException {
		WritableSheet wshTemp = wwbCopy.getSheet(strSheetName);
		WritableFont cellFont = null;
		WritableCellFormat cellFormat = null;

		if (strData.equalsIgnoreCase("PASS")) {
			cellFont = new WritableFont(WritableFont.TIMES, 12);
			cellFont.setColour(Colour.GREEN);
			cellFont.setBoldStyle(WritableFont.BOLD);

			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		}

		else if (strData.equalsIgnoreCase("FAIL")) {
			cellFont = new WritableFont(WritableFont.TIMES, 12);
			cellFont.setColour(Colour.RED);
			cellFont.setBoldStyle(WritableFont.BOLD);

			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
		}

		else {
			cellFont = new WritableFont(WritableFont.TIMES, 12);
			cellFont.setColour(Colour.BLACK);

			cellFormat = new WritableCellFormat(cellFont);
			cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
			cellFormat.setWrap(true);
		}

		Label labTemp = new Label(iColumnNumber, iRowNumber, strData, cellFormat);
		try {
			wshTemp.addCell(labTemp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


 
    public void closeFile()
    {
        try {
            // Closing the writable work book
            wwbCopy.write();
            wwbCopy.close();

            // Closing the original work book
            wbook.close();
        } catch (Exception e)

        {
            e.printStackTrace();
        }
    }
    
    

	public void main(String[] args) throws WriteException {
		dataSheet ds = new dataSheet();
		ds.readExcel();
		ds.setValueIntoCell("Sheet1", 5, 1, "PASS");
		ds.setValueIntoCell("Sheet1", 5, 2, "FAIL");
		ds.setValueIntoCell("Sheet1", 5, 3, "N/A");

	}
}
