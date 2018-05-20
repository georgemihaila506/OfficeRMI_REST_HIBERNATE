package Client;

import Controler.LogInControler;
import Repository.RepositoryCursa;
import Service.ServiceException;
import Service.ServiceInterface;
import Service.SingleService;
import Utils.ExtensionMethods;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import java.rmi.RemoteException;

public class Client extends Application {
    static ServiceInterface logInService;
    static ServiceInterface officeService;
    public static void main(String[] args) {


        RmiProxyFactoryBean factoryBean = new RmiProxyFactoryBean();

        factoryBean.setServiceInterface(ServiceInterface.class);

        factoryBean.setServiceUrl("rmi://" + "127.0.0.1" + ":" + "1099" + "/" + "Office");

        factoryBean.afterPropertiesSet();

        logInService = (ServiceInterface) factoryBean.getObject();
        officeService = (ServiceInterface) factoryBean.getObject();

        //saleService = (ISingleService)factoryBean.getObject();

        //loginService = (ISingleService)factoryBean.getObject();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/Controler/LogIn.fxml"));
        Parent vBox=loader.load();

        Scene scene=new Scene(vBox);
        LogInControler logInControler=loader.getController();
        logInControler.setService(logInService,officeService);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
