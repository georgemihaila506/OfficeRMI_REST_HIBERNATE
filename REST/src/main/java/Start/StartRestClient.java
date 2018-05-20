package Start;

import Domain.Cursa;
import office.services.rest.MyRepoCursa;
import office.services.rest.ServiceException;
import Rest.client.CursaClient;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class StartRestClient {
    private final static CursaClient cursaClient=new CursaClient();
    public static void main(String[] args)
    {
        RestTemplate restTemplate=new RestTemplate();
        Cursa cursa=new Cursa("Turda","01-06-2018","17:00",10);
        try
        {
            show(()->cursaClient.addEntity(cursa));
            cursa.setNrLocuri(15);
            show(()->cursaClient.updateEntity(cursa));
            show(()->cursaClient.deleteEntity("Turda"));
            show(()->{
                Cursa[] res=cursaClient.getAll();
                for(Cursa u:res){
                    System.out.println(u.getDestinatie()+": "+u.getData()+" : "+u.getOra()+" "+u.getNrLocuri());
                }
            });
        }catch(RestClientException ex){
            System.out.println("Exception ... "+ex.getMessage());
        }

    }
    private static void show(Runnable task) {
        try {
            task.run();
        } catch (ServiceException e) {
        //  LOG.error("Service exception", e);
        System.out.println("Service exception "+ e);
        }
    }
}
