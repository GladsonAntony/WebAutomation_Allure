package controllers;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import utils.ExcelUtils;

/**
 * @Author Gladson Antony
 * @Date 21-Feb-2017
 */

public class ExcelDataProvider extends InitMethod {
	@DataProvider(name = "multiSheetExcelRead")
	public static Object[][] multiSheetExcelRead(Method method) throws Exception {
		File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
		String SheetName = method.getName();
		System.out.println(SheetName);
		return ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
	}

	@DataProvider(name = "excelSheetNameAsMethodName")
	public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception {
		File file = new File("./src/test/resources/Test Data/Excel Files/" + method.getName() + ".xlsx");
		System.out.println("Opening Excel File:" + file.getAbsolutePath());
		return ExcelUtils.getTableArray(file.getAbsolutePath());
	}
}
