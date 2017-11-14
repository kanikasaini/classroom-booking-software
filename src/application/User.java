package application;
import java.io.Serializable;
import java.util.*;

public class User implements Serializable {

protected String userId;
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
