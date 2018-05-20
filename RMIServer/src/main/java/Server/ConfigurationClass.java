package Server;

import Repository.*;
import Service.ISingleService;
import Service.ServiceInterface;
import Service.SingleService;
import Utils.ExtensionMethods;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.sql.SQLException;

@Configuration
public class ConfigurationClass {
    @Bean
    public RepoUser repoUser() throws SQLException, IOException, ClassNotFoundException
    {
        return new RepoUser(ExtensionMethods.getInstaceProperties());
    }
    @Bean
    public RepositoryCursa repoCursa() throws SQLException, IOException, ClassNotFoundException
    {
        return new RepositoryCursa(ExtensionMethods.getInstaceProperties());
    }
    @Bean
    public RepositoryRezervare repoRezervare() throws SQLException, IOException, ClassNotFoundException
    {
        return new RepositoryRezervare(ExtensionMethods.getInstaceProperties());
    }
    @Bean
    public ServiceInterface singleRmiService() throws SQLException, IOException, ClassNotFoundException
    {

        return new SingleService(repoCursa(),repoRezervare(),repoUser());
    }
}
