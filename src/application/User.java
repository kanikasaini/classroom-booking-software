package application;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

protected String userId;
public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

protected String password;
protected String type;

public User()
{}

public User(String userId,String password,String type)
{
	this.userId= userId;
	this.password= password;
	this.type= type;
}

}
