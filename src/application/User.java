package application;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

//class to create user object. admin faculty and student extend user class

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
protected String notes;
protected transient Image image;
protected String imageUrl;

public Image getImage() {
	return image;
}

public void setImage(Image image) {
	this.image = image;
}

public String getImageUrl() {
	return imageUrl;
}

public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}

public User()
{}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public User(String userId,String password,String type) throws IOException
{
	this.userId= userId;
	this.password= password;
	this.type= type;
	this.notes="Notes here.";
	this.imageUrl= "database/bluebg.jpg";
	BufferedImage bufferedImage = ImageIO.read(new File("database/bluebg.jpg"));
    this.image = SwingFXUtils.toFXImage(bufferedImage, null);
}

}
