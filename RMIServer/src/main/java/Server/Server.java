package Server;

import Service.ISingleService;
import Service.ServiceInterface;
import Service.SingleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.context.ApplicationContext;


public class Server {
    public static void  main(String[] args) throws Exception
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationClass.class);

        //Server server = new Server(context.getBean(LoginService.class),context.getBean(SaleService.class),context.getBean(ParticipationService.class),"/properties.prop");

        //server.start();

        RmiServiceExporter server = new RmiServiceExporter();

        server.setServiceName("Office");

        server.setService(context.getBean(SingleService.class));

        server.setServiceInterface(ServiceInterface.class);

        server.setServicePort(1099);

        server.afterPropertiesSet();
    }
}
