package controllers;

import java.io.IOException;

import application.Admin;
import application.Booking;
import application.Booking;
import application.Booking;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class MyBookings_AdminController {

	@FXML private MenuBar mainNavBar;
	@FXML private Label myBookingsLabel;
	@FXML private TableView<Booking> tableView;
    @FXML private TableColumn<Booking, String> roomColumn;
    @FXML private TableColumn<Booking, String> dayColumn;
    @FXML private TableColumn<Booking, String> timeColumn;
    @FXML private TableColumn<Booking, Boolean> cancelColumn;
    private ObservableList<Booking> bookinglist = FXCollections.observableArrayList();

    private Admin admin;

	protected void setUser(Admin a)
	{
		this.admin= (Admin)a;
		System.out.println(a.getPassword());

	}


	public void initialize() throws IOException {
        //Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Admin.fxml"));
        //Scene homepage = new Scene(rootHomepage);
		//stage.setScene(homepage);
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
              return new AddBookingCell(tableView);
            }
          });

          //tableView.getColumns().setAll(roomColumn, dayColumn, timeColumn,  cancelColumn);
        tableView.setItems(bookinglist);
          tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

          //stage.setScene(new Scene(tableView));
          //stage.show();

    }

	private class AddBookingCell extends TableCell<Booking, Boolean> {
	    // a button for adding a new Booking.
	    final Button addButton       = new Button("Add");
	    // pads and centers the add button in the cell.
	    final StackPane paddedButton = new StackPane();
	    // records the y pos of the last button press so that the add Booking dialog can be shown next to the cell.
	    final DoubleProperty buttonY = new SimpleDoubleProperty();

	    AddBookingCell(final TableView table) {
	      paddedButton.setPadding(new Insets(3));
	      paddedButton.getChildren().add(addButton);
	      addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent mouseEvent) {
	          buttonY.set(mouseEvent.getScreenY());
	        }
	      });
	      addButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {
	          showAddBookingDialog(table, buttonY.get());
	          table.getSelectionModel().select(getTableRow().getIndex());
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


	private void showAddBookingDialog(final TableView<Booking> table, double y) {
	        // initialize the dialog.

	      }
	public void makeList() throws IOException
    {
		System.out.println(admin.getUserId());
		bookinglist = (ObservableList)admin.getBookings();

		//bookinglist= FXCollections.observableArrayList(
		   //     new Booking("C21", "monday", "10:30", "11:00")
		    //  );
    }
	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_AdminController usc= fxmlLoader.<User_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			HandleRequests_AdminController usc= fxmlLoader.<HandleRequests_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
}