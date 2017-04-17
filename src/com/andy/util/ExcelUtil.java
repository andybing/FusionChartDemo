package com.andy.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;

/**
 * ����Excel������
 * @author andy
 * @version v1.0
 */
public class ExcelUtil {
	/**
	 * ���������б�ļ���
	 * @author andy
	 * @param list 
	 * @param path
	 */
	public static void exportExcelData(List<HashMap<String,Object>> list,String path){
		String[] title = {"�γ̱��","�γ�����","�γ�������Ϣ"};
		jxl.write.WritableWorkbook wb = null;
		try{
			File file = new File(path);
			wb = jxl.Workbook.createWorkbook(file);
			WritableSheet sheet = wb.createSheet("course", 0);
			//������ͷ
			Label label = null;
			for(int i = 0;i<title.length;i++){
				label = new Label(i, 0, title[i]);
				sheet.addCell(label);
			}
			//�������
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
