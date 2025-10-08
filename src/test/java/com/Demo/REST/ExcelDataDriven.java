package com.Demo.REST;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;

public class ExcelDataDriven {
	public static void main(String[] args) throws IOException
	{
		System.out.println("ExcelData");
		FileInputStream fis = new FileInputStream("C:\\Users\\BB2712\\Downloads\\DataDriven.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int Noofsheets = workbook.getNumberOfSheets();
		System.out.println(Noofsheets);
		
		ArrayList<String> Ar = new ArrayList<String>();
		for(int i=0;i<Noofsheets;i++) {
			System.out.println(workbook.getSheetName(i));
//			System.out.println(workbook.getSheetName(i).equals("TestData"));
			if(workbook.getSheetName(i).equals("TestData"))
			{
				System.out.println("into the loop");
				XSSFSheet sheet = workbook.getSheetAt(i);
				
				Iterator<Row> Rows = sheet.iterator();
				while(Rows.hasNext())
				{
//					Rows.next();
					Iterator<Cell> Cells = Rows.next().cellIterator();
					int k =0;
					int column = 0;
					while(Cells.hasNext())
					{
						
						Cell ce = Cells.next();
						if(ce.getStringCellValue().equalsIgnoreCase("TestCase"))
						{
							System.out.println(ce.getStringCellValue());
							column = k;
							break;
						}
						k++;	
						while(Rows.hasNext())
						{
							
							Row r = Rows.next();
							if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login3"))
							{
								Iterator<Cell> cee = r.iterator();
								while(cee.hasNext())
								{
									Cell cl = cee.next();
									if(cl.getCellType()==CellType.STRING){
										Ar.add(cl.getStringCellValue());
									}
									else
									{
										Ar.add(String.valueOf(cl.getNumericCellValue()));
									}
								}
							}
						}
						
					}	
					
					
					
				}
			
		}
	}
		
		System.out.println("Values in the array");
		System.out.println(Ar.get(0));
		System.out.println(Ar.get(1));
		System.out.println(Ar.get(2));
		System.out.println(Ar.get(3));
	}
}

