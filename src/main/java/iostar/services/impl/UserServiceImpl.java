package iostar.services.impl;

import iostar.dao.IUserDao;
import iostar.dao.impl.UserDaoImpl;
import iostar.models.UserModel;
import iostar.services.UserService;

public class UserServiceImpl implements UserService {
	IUserDao userDao = new UserDaoImpl();

	// UserModel User = new UserModel();
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.get(username);
		if (user != null && password.equals(user.getPassWord())) {
			return user;
		}
		return null;
	}

	public UserModel findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public UserModel get(String username) {
		return userDao.get(username);
	}

	@Override
	public void insert(UserModel user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean register(String email, String username,  String fullname,String password, String phone) {
		if (userDao.checkExitUsername(username)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		userDao.insert(new UserModel(email, username, fullname, password, null, 1, phone, date));
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExitEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExitUsername(username);

	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExitPhone(phone);
	}

	@Override
	public boolean update(String username, String newPassword) {

	    UserModel user = userDao.findByUserName(username);
	    if (user == null) {
	        System.out.println("Người dùng không tồn tại!");
	        return false;
	    }
	    user.setPassWord(newPassword);
        boolean isUpdated = userDao.update(username,newPassword); 
        
        if (isUpdated) {
            System.out.println("Cập nhật mật khẩu thành công!");
            return true;
        } else {
            System.out.println("Cập nhật mật khẩu thất bại!");
            return false;
        }
		
	}

}
