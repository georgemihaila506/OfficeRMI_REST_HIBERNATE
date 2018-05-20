package Controler;

import Domain.Cursa;
import Service.Observer;
import Service.ServiceException;
import Service.ServiceInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class HomeControler extends UnicastRemoteObject implements Observer {

    @FXML
    private TableView<Cursa> tableView;
    @FXML
    private TableColumn<Cursa,String> destinationColumn;
    @FXML
    private TableColumn<Cursa,String> dateColumn;
    @FXML
    private TableColumn<Cursa,String> timeColumn;
    @FXML
    private TableColumn<Cursa,Integer> nrColumn;
    private ServiceInterface serviceOffice;
    private ObservableList<Cursa> model=FXCollections.observableArrayList();

    public HomeControler() throws RemoteException
    {
    }
    public void setService(ServiceInterface service)
    {
        try {
            serviceOffice= service;
            serviceOffice.addObserver(this);
            model.setAll(serviceOffice.getAllTrips());
            tableView.setItems(model);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    @FXML
    public void initialize()
    {
        destinationColumn.setCellValueFactory(new PropertyValueFactory<Cursa,String>("destinatie"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<Cursa,String>("data"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Cursa,String>("ora"));
        nrColumn.setCellValueFactory(new PropertyValueFactory<Cursa,Integer>("nrLocuri"));
    }

    @Override
    public void update(ServiceInterface observer) {
        System.out.println("am ajuns!");
        serviceOffice= observer;
        try {
            model.setAll(serviceOffice.getAllTrips());
            tableView.setItems(model);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
