package Controler;

import Domain.Cursa;
import Domain.Rezervare;
import Service.ServiceException;
import Service.ServiceInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;

public class ReserveControler {

    @FXML
    TextField destinationField;
    @FXML
    DatePicker datePicker;
    @FXML
    TextField hourField;
    @FXML
    TextField minuteField;
    @FXML
    TextField nameField;
    @FXML
    TextField numberField;
    ServiceInterface serviceOffice;
    private ObservableList<Rezervare> model= FXCollections.observableArrayList();

    @FXML
    TableView<Rezervare> tableView;
    @FXML
    TableColumn<Rezervare,Integer> numberColumn;
    @FXML
    TableColumn<Rezervare,String> nameColumn;
    @FXML
    public void initialize()
    {
        numberColumn.setCellValueFactory(new PropertyValueFactory<Rezervare,Integer>("nrLocuri"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Rezervare,String>("nume"));
    }
    @FXML
    public void reserverHandle()
    {
        String destination=destinationField.getText();
        String date;
        try {
            date = datePicker.getValue().toString();
        }
        catch (Exception e)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Wrong informations!");
            alert.setContentText("Please try again!");
            alert.show();
            return;
        }

        String time=hourField.getText()+":"+minuteField.getText();
        time=time+":00";

        String name=nameField.getText();
        String number=numberField.getText();

        if(destination.equals("")||date.equals("")||time.equals("")||name.equals("")||number.equals("")||hourField.getText().equals("")||minuteField.getText().equals(""))
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Wrong informations!");
            alert.setContentText("Please try again!");
            alert.show();
            return;
        }
        try {
            serviceOffice.rezerva(new Cursa(destination,date,time,0),new Rezervare(name, Integer.parseInt(number)));
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            model.setAll(serviceOffice.cautaRezervari(new Cursa(destination,date,time,0)));
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        tableView.setItems(model);


    }
    public void setService(ServiceInterface service)
    {
        serviceOffice= service;
    }
}
