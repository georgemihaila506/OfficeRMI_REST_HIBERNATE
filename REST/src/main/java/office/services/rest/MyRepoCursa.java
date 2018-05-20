package office.services.rest;

import Domain.Cursa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Component
public class MyRepoCursa{
    private List<Cursa> allCurse;
    public MyRepoCursa()
    {
        allCurse=new ArrayList<>();
        populate();
    }
    private void populate()
    {
        Cursa c1=new Cursa("Bucuresti","01-06-2018","17:00",10);
        Cursa c2=new Cursa("Cluj-Napoca","01-06-2018","17:00",10);
        allCurse.add(c1);
        allCurse.add(c1);
    }
    public List<Cursa> getAll()
    {
        return allCurse;
    }

    public int cautaCursa(Cursa cursa) {
        return 0;
    }

    public void addEntity(Cursa cursa) {
        allCurse.add(cursa);
    }

    public void updateNrLocuri(Cursa cursa) {
        for(Cursa x:allCurse)
        {
            if(x.getDestinatie().equals(cursa.getDestinatie()) && x.getData().equals(cursa.getData()))
            {
                x.setNrLocuri(cursa.getNrLocuri());
            }
        }
    }

    public void deleteEntity(String cursa) {
        for(int i=0;i<allCurse.size();i++)
        {
            if(allCurse.get(i).getDestinatie().equals(cursa))
            {
                allCurse.remove(i);
            }
        }
    }
}
