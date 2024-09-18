package iostar.services;

import iostar.models.UserModel;

public interface UserService {
	UserModel login(String username, String password);

	UserModel get(String username);

	void insert(UserModel user);

	boolean register(String email, String username, String fullname,String password, String phone);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean checkExistPhone(String phone);
	boolean update(String username, String newPassword);
}
