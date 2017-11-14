package application;

public class Login {

public User user;
public Login()
{
	user= new User();
}
public void signUp(String userId, String password, String type)
{
	if(type.equals("Admin"))
		user = new Admin(userId, password, type);
	

}

}
