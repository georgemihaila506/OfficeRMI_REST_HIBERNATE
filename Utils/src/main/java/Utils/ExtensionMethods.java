package Utils;

import Repository.RepoUser;
import Repository.RepositoryCursa;
import Repository.RepositoryRezervare;
import Service.ServiceInterface;
import Service.ServiceOffice;
import Service.ServiceUser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ExtensionMethods {
    private static ServiceInterface serviceUser;
    private static ServiceInterface serviceOffice;
    private static ServiceInterface serviceClient;
    public static ServiceUser getServiceUser()
    {

        if(serviceUser==null)
            createServiceUser();
        return (ServiceUser) serviceUser;
    }
    public static ServiceOffice getServiceOffice()
    {
        if(serviceOffice==null) {
            createServiceOffice();
        }
        return (ServiceOffice) serviceOffice;
    }
    private static void createServiceOffice() {
        RepositoryRezervare repositoryRezervare=new RepositoryRezervare(getInstaceProperties());
        RepositoryCursa repositoryCursa=new RepositoryCursa(getInstaceProperties());
        serviceOffice=new ServiceOffice(repositoryCursa,repositoryRezervare);
    }

    private static void createServiceUser() {
        RepoUser repoUser=new RepoUser(getInstaceProperties());
        serviceUser=new ServiceUser(repoUser);
        //serviceUser=new ClientProxy(repoUser,getInstaceProperties());
    }
    public static Properties  getInstaceProperties(){
        Properties serverProps=new Properties();
        try {
            serverProps.load(new FileReader("E:\\Projects\\OfficeTransport\\Utils\\src\\main\\resources\\Utils\\bd.config"));
            //System.setProperties(serverProps);

            System.out.println("Properties set. ");
            //System.getProperties().list(System.out);
            serverProps.list(System.out);
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
            return null;
        }
        // SortingTaskJdbcRepository repo=new SortingTaskJdbcRepository(serverProps);//Repository(new SortingTaskValidator());
        // ObservableTaskRunner runner=new ObservableTaskRunner(new TaskStack());
        return serverProps;
    }


}
