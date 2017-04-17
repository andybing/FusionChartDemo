package com.andy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.andy.util.DBUtil;
/*
 * 对课程进行查询
 * 
 */

public class CourseDao {
	static List<HashMap<String,Object>> list = null;
	public static List<HashMap<String, Object>> queryCourse(){
		DBUtil db = null;
		ResultSet rs = null;
		try{
			list = new ArrayList<HashMap<String, Object>>();
			db = new DBUtil();
			String sql = "select * from courseinfo";
			rs = db.getQuery(sql);
			HashMap<String, Object> map = null;
			while(rs.next()){
				map = new HashMap<String, Object>();
				Integer id = rs.getInt("c_id");
				String name = rs.getString("c_name");
				String desc = rs.getString("c_desc");
				map.put("id", id);
				map.put("name", name);
				map.put("desc",desc);
				list.add(map);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db.connClose();
		}
		return list;
	}
}
