package com.andy.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

/**
 * 操作Excel工具类
 * @author andy
 * @version v1.0
 */
public class ExcelUtil {
	/**
	 * 导出数据列表的集合
	 * @author andy
	 * @param list 
	 * @param path
	 */
	public static void exportExcelData(List<HashMap<String,Object>> list,String path){
		String[] title = {"课程编号","课程名称","课程描述信息"};
		jxl.write.WritableWorkbook wb = null;
		try{
			File file = new File(path);
			wb = jxl.Workbook.createWorkbook(file);
			WritableSheet sheet = wb.createSheet("course", 0);
			//创建表头
			Label label = null;
			for(int i = 0;i<title.length;i++){
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			//添加数据
			HashMap<String,Object> map = null;
			Label labelNext = null;
			for(int i = 0;i<list.size();i++){
				map = list.get(i);
				labelNext = new Label(0, i+1,String.valueOf(map.get("id")));
				sheet.addCell(labelNext);
				
				labelNext = new Label(1, i+1,String.valueOf(map.get("name")));
				sheet.addCell(labelNext);
				
				labelNext = new Label(2, i+1,String.valueOf(map.get("desc")));
				sheet.addCell(labelNext);
			}
			wb.write();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				wb.close();
			} catch (WriteException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
