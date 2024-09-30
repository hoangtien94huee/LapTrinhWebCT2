package iostar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import iostar.configs.DBConnectMySQL;
import iostar.dao.ICategoryDao;
import iostar.models.CategoryModel;
import iostar.models.UserModel;

public class CategoryDaoImpl extends DBConnectMySQL implements ICategoryDao{
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs= null;
	@Override
	public List<CategoryModel> findALL() {
		String sql = "Select * from categories";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 rs = ps.executeQuery();
			 while (rs.next()) {
					CategoryModel category = new CategoryModel();
					category.setCategoryid(rs.getInt("categoryid"));
					category.setCategoryname(rs.getString("categoryname"));
					category.setImages(rs.getString("images"));
					category.setStatus(rs.getInt("status"));
					list.add(category);
				}
			 conn.close();
			 ps.close();
			 rs.close();
			 return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public CategoryModel findById(int id) {
		String sql = "Select * from categories where categoryid = ?";
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1,id);
			 rs = ps.executeQuery();
			 while (rs.next()) {
					CategoryModel category = new CategoryModel();
					category.setCategoryid(rs.getInt("categoryid"));
					category.setCategoryname(rs.getString("categoryname"));
					category.setImages(rs.getString("images"));
					category.setStatus(rs.getInt("status"));
					return category;
				}
			 conn.close();
			 ps.close();
			 rs.close();
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	@Override
	public void insert(CategoryModel category) {
		String sql = "insert into categories(categoryname,images,status) VALUES (?,?,?)";
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,category.getCategoryname());
			 ps.setString(2, category.getImages());
			 ps.setInt(3, category.getStatus());
			 ps.executeUpdate();
			 conn.close();
			 ps.close();
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Override
	public void update(CategoryModel category) {
		String sql = "update categories set categoryname = ? ,images = ?,status= ? WHERE categoryid = ?";
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,category.getCategoryname());
			 ps.setString(2, category.getImages());
			 ps.setInt(3, category.getStatus());
			 ps.setInt(4, category.getCategoryid());
			 ps.executeUpdate();
			 conn.close();
			 ps.close();
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM  categories WHERE categoryid = ?";
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 ps.executeUpdate();
			 conn.close();
			 ps.close();
			}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	@Override
	public List<CategoryModel> findName(String keyword) {
		String sql = "Select * from categories where categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = super.getDatabaseConnection();
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, "%" + keyword + "%");
			 rs = ps.executeQuery();
			 while (rs.next()) {
					CategoryModel category = new CategoryModel();
					category.setCategoryid(rs.getInt("categoryid"));
					category.setCategoryname(rs.getString("categoryname"));
					category.setImages(rs.getString("images"));
					category.setStatus(rs.getInt("status"));
					list.add(category);
				}
			 conn.close();
			 ps.close();
			 rs.close();
			 return list;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	
}
