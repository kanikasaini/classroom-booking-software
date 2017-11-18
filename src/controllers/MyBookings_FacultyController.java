package controllers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import application.Booking;
import application.Faculty;
import application.Room;
import application.User;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;
//class which handles the my bookings page of faculty
public class MyBookings_FacultyController {

	 @FXML private Label myBookingsLabel;
	 private Faculty faculty;
	 @FXML private TableView<Booking> tableView;
	    @FXML private TableColumn<Booking, String> roomColumn;
	    @FXML private TableColumn<Booking, String> dayColumn;
	    @FXML private TableColumn<Booking, String> timeColumn;
	    @FXML private TableColumn<Booking, Boolean> cancelColumn;
	    private ObservableList<Booking> bookinglist = FXCollections.observableArrayList();
		protected void setUser(Faculty a)
		{
			this.faculty= (Faculty)a;
		}

	 public void initializer() throws IOException { //first method, gets called itself
	        makeList();
	        tableView.setItems(bookinglist);
	        roomColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("roomNo"));
	    	dayColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("day"));
	        timeColumn.setCellValueFactory(new PropertyValueFactory<Booking, String>("time"));
	        cancelColumn.setSortable(false);

	        //Stage stage = (Stage)myBookingsLabel.getScene().getWindow();
	        cancelColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Booking, Boolean>, ObservableValue<Boolean>>() {
	            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Booking, Boolean> features) {
	              return new SimpleBooleanProperty(features.getValue() != null);
	            }
	          });

	        cancelColumn.setCellFactory(new Callback<TableColumn<Booking, Boolean>, TableCell<Booking, Boolean>>() {
	            @Override public TableCell<Booking, Boolean> call(TableColumn<Booking, Boolean> BookingBooleanTableColumn) {
	              return new CancelBookingCell(tableView);
	            }
	          });

	        tableView.setItems(bookinglist);
	          tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

	    }

		private class CancelBookingCell extends TableCell<Booking, Boolean> {
			//method which gets called when admin presses cancel button


		    // a button for adding a new Booking.
		    final Button cancelButton       = new Button("Cancel");
		    // pads and centers the add button in the cell.
		    final StackPane paddedButton = new StackPane();
		    // records the y pos of the last button press so that the add Booking dialog can be shown next to the cell.
		    final DoubleProperty buttonY = new SimpleDoubleProperty();

		    CancelBookingCell(final TableView table) {
		      paddedButton.setPadding(new Insets(3));
		      paddedButton.getChildren().add(cancelButton);
		      cancelButton.setOnMousePressed(new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent mouseEvent) {
		          buttonY.set(mouseEvent.getScreenY());
		        }
		      });
		      cancelButton.setOnAction(new EventHandler<ActionEvent>() {
		        @Override public void handle(ActionEvent actionEvent) {
//		          showCancelBookingDialog(table, buttonY.get());

		          table.getSelectionModel().select(getTableRow().getIndex());

		          if (table.getSelectionModel().getSelectedItem() != null) {
		             Booking b = (Booking) table.getSelectionModel().getSelectedItem();
		             faculty.cancelBooking(b);

		             try {

		            	ObjectInputStream in = new ObjectInputStream(new FileInputStream("database/bookedRooms/"+b.getRoomNo()+".txt"));
					    Room room = (Room)in.readObject();
					    ArrayList<String> s= room.getbookedSlots();
					    s.remove(b.getDay()+" "+b.getTime());
					    room.setbookedSlots(s);
					    serialize(room);
						serialize(faculty);
						makeList();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		             tableView.setItems(bookinglist);
			         tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		          }
		        }
		      });
		    }

		    @Override protected void updateItem(Boolean item, boolean empty) {
		        super.updateItem(item, empty);
		        if (!empty) {
		          setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		          setGraphic(paddedButton);
		        } else {
		          setGraphic(null);
		        }
		      }
		}

		public void makeList() throws IOException
	    {
			System.out.println(faculty.getUserId());
			bookinglist = FXCollections.observableArrayList(faculty.getBookings());
	    }
		public static void serialize(Room pl) throws IOException
    	{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("database/bookedRooms/"+pl.getNumber()+".txt"));
            out.writeObject(pl);
        } finally
        {
            out.close();
        }
    	}

		public static void serialize(User user) throws IOException
    	{
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("database/users/"+user.getUserId()+".txt"));
            out.writeObject(user);
        } finally
        {
            out.close();
        }
    	}
		//GUI interconnection
		 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Faculty.fxml"));
				Parent rootHomepage = fxmlLoader.load();
				User_FacultyController usc= fxmlLoader.<User_FacultyController>getController();
				usc.setUser(faculty);
				Scene homepage = new Scene(rootHomepage);
				((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
		 }

	 @FXML protected void handleAvailableRoomsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleBookRoomButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
}