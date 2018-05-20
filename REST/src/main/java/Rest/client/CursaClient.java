package Rest.client;

import Domain.Cursa;
import office.services.rest.ServiceException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

public class CursaClient {
    public static final String URL = "http://localhost:8080/office/Cursa";

    private RestTemplate restTemplate = new RestTemplate();

    private <T> T execute(Callable<T> callable){
        try {
            return callable.call();
        } catch (ResourceAccessException | HttpClientErrorException e) { // server down, resource exception
            throw new ServiceException(e);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
    public Cursa[] getAll()
    {
        return execute(()->restTemplate.getForObject(URL,Cursa[].class));
    }
    public void addEntity(Cursa cursa)
    {
        execute(()->restTemplate.postForObject(URL,cursa,Cursa.class));
    }
    public void updateEntity(Cursa cursa)
    {
        execute(() -> {
            restTemplate.put(String.format("%s/%s", URL, cursa.getDestinatie()), cursa);
            return null;
        });
    }
    public void deleteEntity(String id)
    {
        execute(()->
        {
           restTemplate.delete(String.format("%s/%s",URL,id));
           return null;
        });
    }
}
