package controllers;

import java.io.IOException;

import application.Admin;
import application.Booking;
import application.Request;
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


public class HandleRequests_AdminController {

	@FXML private MenuBar mainNavBar;
	@FXML private Label handleRequestsLabel;
	private Admin admin;
	@FXML private TableView<Request> tableView;
    @FXML private TableColumn<Request, String> roomColumn;
    @FXML private TableColumn<Request, String> dayColumn;
    @FXML private TableColumn<Request, String> timeColumn;
    @FXML private TableColumn<Request, String> purposeColumn;
    @FXML private TableColumn<Request, String> sentByColumn;
    @FXML private TableColumn<Request, Boolean> acceptColumn;
    @FXML private TableColumn<Request, Boolean> rejectColumn;

    private ObservableList<Request> requestlist = FXCollections.observableArrayList();
	protected void setUser(Admin a)
	{
		this.admin= (Admin)a;
	}

	public void initializer() throws Exception {
        makeList();
        tableView.setItems(requestlist);
        roomColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("prefferedRoom"));
    	dayColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("time"));
        sentByColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("sentBy"));
        purposeColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("purpose"));

        acceptColumn.setSortable(false);
        rejectColumn.setSortable(false);

        acceptColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Request, Boolean>, ObservableValue<Boolean>>() {
            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Request, Boolean> features) {
              return new SimpleBooleanProperty(features.getValue() != null);
            }
          });

        acceptColumn.setCellFactory(new Callback<TableColumn<Request, Boolean>, TableCell<Request, Boolean>>() {
            @Override public TableCell<Request, Boolean> call(TableColumn<Request, Boolean> RequestBooleanTableColumn) {
              return new AcceptRequestCell(tableView);
            }
          });


        rejectColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Request, Boolean>, ObservableValue<Boolean>>() {
            @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Request, Boolean> features) {
              return new SimpleBooleanProperty(features.getValue() != null);
            }
          });

        rejectColumn.setCellFactory(new Callback<TableColumn<Request, Boolean>, TableCell<Request, Boolean>>() {
            @Override public TableCell<Request, Boolean> call(TableColumn<Request, Boolean> RequestBooleanTableColumn) {
              return new RejectRequestCell(tableView);
            }
          });

        tableView.setItems(requestlist);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

	private class RejectRequestCell extends TableCell<Request, Boolean> {
	    // a button for adding a new Request.
	    final Button rejectButton       = new Button("Reject");
	    // pads and centers the add button in the cell.
	    final StackPane paddedButton = new StackPane();
	    // records the y pos of the last button press so that the add Request dialog can be shown next to the cell.
	    final DoubleProperty buttonY = new SimpleDoubleProperty();

	    RejectRequestCell(final TableView table) {
	      paddedButton.setPadding(new Insets(3));
	      paddedButton.getChildren().add(rejectButton);
	      rejectButton.setOnMousePressed(new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent mouseEvent) {
	          buttonY.set(mouseEvent.getScreenY());
	        }
	      });
	      rejectButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {

	          table.getSelectionModel().select(getTableRow().getIndex());

	          if (table.getSelectionModel().getSelectedItem() != null) {
	             Request b = (Request) table.getSelectionModel().getSelectedItem();
	             try {
					admin.deleteRequest(b);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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


	private class AcceptRequestCell extends TableCell<Request, Boolean> {
	    // a button for adding a new Request.
	    final Button acceptButton       = new Button("Accept");
	    // pads and centers the add button in the cell.
	    final StackPane paddedButton = new StackPane();
	    // records the y pos of the last button press so that the add Request dialog can be shown next to the cell.
	    final DoubleProperty buttonY = new SimpleDoubleProperty();

	    AcceptRequestCell(final TableView table) {
	      paddedButton.setPadding(new Insets(3));
	      paddedButton.getChildren().add(acceptButton);
	      acceptButton.setOnMousePressed(new EventHandler<MouseEvent>() {
	        @Override public void handle(MouseEvent mouseEvent) {
	          buttonY.set(mouseEvent.getScreenY());
	        }
	      });
	      acceptButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {
//	          showCancelBookingDialog(table, buttonY.get());

	          table.getSelectionModel().select(getTableRow().getIndex());

	          if (table.getSelectionModel().getSelectedItem() != null) {
	             Request b = (Request) table.getSelectionModel().getSelectedItem();
	             try {
					admin.acceptRequest(b);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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

	public void makeList() throws Exception
    {
		requestlist = FXCollections.observableArrayList(admin.getPendingRequests());

    }
	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_AdminController usc= fxmlLoader.<User_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		MyBookings_AdminController usc= fxmlLoader.<MyBookings_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
}

