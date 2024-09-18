package iostar.dao;

import java.util.List;

import iostar.models.UserModel;

public interface IUserDao {
	
	List<UserModel> findAll();
	UserModel findById(int id);
	
	void insert(UserModel user);
	UserModel findByUserName(String username);
	UserModel get(String username);
	boolean checkExitUsername(String username);
	boolean checkExitEmail(String email);
	boolean checkExitPhone(String phone);
	boolean update(String username,String newPassword);
}
