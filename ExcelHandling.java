package com.rbs.samples;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class ExcelHandling {
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException, BiffException {
		 WritableWorkbook wworkbook =
				 Workbook.createWorkbook(new File("rbsmarketdata.xls"));
	     
				 
		 WritableSheet wsheet=null;
		 String[] months={"January","February","March","April","May"};
		 Number number=null;
		 for(int i=0;i<5;i++)
		 {
		  wsheet= wworkbook.createSheet(months[i], i);
	      Label label = new Label(0, 2, "Employee Number");      
	      
	      wsheet.addCell(label);  
		
		 
	      
	     number=null;
	      for(int j=3;j<1000;j++)
	      {
	      number= new Number(0, j, new Random().nextInt(10000));
	      wsheet.addCell(number);
	      
	      }
	      
		 }
	      wworkbook.write();
	      wworkbook.close();

	      Workbook workbook = Workbook.getWorkbook(new File("rbsmarketdata.xls"));
	      Sheet sheet = workbook.getSheet(0);
	      //Cell cell1 = sheet.getCell(0, 2);
	     // System.out.println(cell1.getContents());
	      
	      int data = sheet.getRows();
	      System.out.format("Number of Rows in Excel Sheet\t%d\n",data);
	      
	      Cell cell=null;
	      for(int i=0;i<data;i++)
	      {
	    	cell = sheet.getCell(0, i);
		    System.out.println(cell.getContents());
	      }
	     // Cell cell2 = sheet.getCell(3, 4);
	      //System.out.println(cell2.getContents());
	       
	      
	  	      workbook.close();
	
	}
}
