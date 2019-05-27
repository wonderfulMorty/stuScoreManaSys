package com.zhengyuan.liunao.tools;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;

public class ExcelUtil {

	/**
	 * 导出Excel
	 * 
	 * @param sheetName sheet名称
	 * @param title     标题
	 * @param values    内容
	 * @param wb        HSSFWorkbook对象
	 * @return
	 */
	public static Workbook getHSSFWorkbook(Workbook wb, Object ob, List list) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		ExportParams ep = new ExportParams();
		wb = ExcelExportUtil.exportExcel(ep, ob.getClass(), list);
		return wb;
	}

	public static LinkedHashMap<String, String> excel2json(MultipartFile file) throws IOException {

		System.out.println("excel2json方法执行....");

		// 返回的map
		LinkedHashMap<String, String> excelMap = new LinkedHashMap<>();

		// Excel列的样式，主要是为了解决Excel数字科学计数的问题
		CellStyle cellStyle;
		// 根据Excel构成的对象
		Workbook wb;
		// 如果是2007及以上版本，则使用想要的Workbook以及CellStyle
		if (file.getOriginalFilename().endsWith("xlsx")) {
			wb = new XSSFWorkbook(file.getInputStream());
			XSSFDataFormat dataFormat = (XSSFDataFormat) wb.createDataFormat();
			cellStyle = wb.createCellStyle();
			// 设置Excel列的样式为文本
			cellStyle.setDataFormat(dataFormat.getFormat("@"));
		} else {
			System.out.println("是2007以下版本  xls");
			POIFSFileSystem fs = new POIFSFileSystem(file.getInputStream());
			wb = new HSSFWorkbook(fs);
			HSSFDataFormat dataFormat = (HSSFDataFormat) wb.createDataFormat();
			cellStyle = wb.createCellStyle();
			// 设置Excel列的样式为文本
			cellStyle.setDataFormat(dataFormat.getFormat("@"));
		}

		// sheet表个数
		int sheetsCounts = wb.getNumberOfSheets();
		// 遍历每一个sheet
		for (int i = 0; i < sheetsCounts; i++) {
			Sheet sheet = wb.getSheetAt(i);
			System.out.println("第" + i + "个sheet:" + sheet.toString());

			// 一个sheet表对于一个List
			List list = new LinkedList();

			// 将第一行的列值作为正个json的key
			String[] cellNames;
			// 取第一行列的值作为key
			Row fisrtRow = sheet.getRow(0);
			// 如果第一行就为空，则是空sheet表，该表跳过
			if (null == fisrtRow) {
				continue;
			}
			// 得到第一行有多少列
			int curCellNum = fisrtRow.getLastCellNum();
			System.out.println("第一行的列数：" + curCellNum);
			// 根据第一行的列数来生成列头数组
			cellNames = new String[curCellNum];
			// 单独处理第一行，取出第一行的每个列值放在数组中，就得到了整张表的JSON的key
			for (int m = 0; m < curCellNum; m++) {
				Cell cell = fisrtRow.getCell(m);
				// 设置该列的样式是字符串
				cell.setCellStyle(cellStyle);
				cell.setCellType(Cell.CELL_TYPE_STRING);
				// 取得该列的字符串值
				cellNames[m] = cell.getStringCellValue();
			}
			for (String s : cellNames) {
				System.out.print("得到第" + i + " 张sheet表的列头： " + s + ",");
			}
			System.out.println();

			// 从第二行起遍历每一行
			int rowNum = sheet.getLastRowNum();
			System.out.println("总共有 " + rowNum + " 行");
			for (int j = 1; j <= rowNum; j++) {
				// 一行数据对于一个Map
				LinkedHashMap rowMap = new LinkedHashMap();
				// 取得某一行
				Row row = sheet.getRow(j);
				int cellNum = row.getLastCellNum();
				// 遍历每一列
				for (int k = 0; k < cellNum; k++) {
					Cell cell = row.getCell(k);

					cell.setCellStyle(cellStyle);
					cell.setCellType(Cell.CELL_TYPE_STRING);
					// 保存该单元格的数据到该行中
					rowMap.put(cellNames[k], cell.getStringCellValue());
				}
				// 保存该行的数据到该表的List中
				list.add(rowMap);
			}
			// 将该sheet表的表名为key，List转为json后的字符串为Value进行存储
			excelMap.put(sheet.getSheetName(), JSON.toJSONString(list, false));
		}

		System.out.println("excel2json方法结束....");

		return excelMap;
	}

}
