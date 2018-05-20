package Controler;

import Service.Observer;
import Service.ServiceInterface;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowControler implements Observer {


    public MainWindowControler()
    {
    }
    AnchorPane home;
    AnchorPane search;
    AnchorPane reserve;
    @FXML
    AnchorPane hBox=null;
    @FXML
    public void initialize()
    {

    }
    ServiceInterface serviceUser;
    ServiceInterface serviceOffice;
    public void setService(ServiceInterface serviceUser, ServiceInterface serviceOffice)
    {
        this.serviceOffice=serviceOffice;
        this.serviceUser=serviceUser;
        try {
            //serviceOffice.addObserver(this);
            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("Home.fxml"));
            hBox.getChildren().setAll((AnchorPane) loader.load());
            HomeControler homeControler=loader.getController();
            homeControler.setService(serviceOffice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void homeHandle()
    {
        try {
            if(home==null) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Home.fxml"));
                //hBox.getChildren().setAll((AnchorPane) loader.load());
                home=loader.load();
                HomeControler homeControler=loader.getController();
                homeControler.setService(serviceOffice);
            }
            hBox.getChildren().setAll(home);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void searchHandle()
    {

        try {
            if(search==null) {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("Search.fxml"));
                //hBox.getChildren().setAll((AnchorPane) loader.load());
                search=loader.load();
                SearchControler searchCotroler = loader.getController();
                searchCotroler.setService(serviceOffice);
            }
            hBox.getChildren().setAll(search);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void reserveHandle()
    {

        try {
            if(reserve==null) {
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("Reserve.fxml"));
               // hBox.getChildren().setAll((AnchorPane) loader.load());
                reserve=loader.load();
                ReserveControler reserveControler = loader.getController();
                reserveControler.setService(serviceOffice);
            }
            hBox.getChildren().setAll(reserve);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void singoutHandle()
    {
        Stage stage=(Stage)hBox.getScene().getWindow();
        stage.close();
    }

    @Override
    public void update(ServiceInterface observer) {

    }
}
