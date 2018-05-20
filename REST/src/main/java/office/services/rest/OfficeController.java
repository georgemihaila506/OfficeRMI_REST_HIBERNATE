package office.services.rest;

import Domain.Cursa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;

@RestController
@RequestMapping("/office/Cursa")
public class OfficeController {
    private static final String template="Hello, %s!";

    @Autowired
    private MyRepoCursa repoCursa;

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name",defaultValue = "World") String name)
    {
        return String.format(template,name);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cursa[] getAll()
    {
        int i=0;
        List<Cursa> cursaList=repoCursa.getAll();
        Cursa[] curse=new Cursa[cursaList.size()];
        for(Cursa cursa:cursaList)
        {
            curse[i]=cursa;
            i++;
        }
        return curse;
    }

    @RequestMapping(value="/{cursa}",method = RequestMethod.GET)
    public int getId(@PathVariable Cursa cursa)
    {
        return repoCursa.cautaCursa(cursa);
    }
    @RequestMapping(method=RequestMethod.POST)
    public void addEntity(@RequestBody Cursa cursa)
    {
        repoCursa.addEntity(cursa);
    }

    @RequestMapping(value ="/{id}",method=RequestMethod.PUT)
    public void updateEntity(@RequestBody Cursa cursa)
    {
        repoCursa.updateNrLocuri(cursa);
    }

    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
    public void deleteEntity(@PathVariable String id)
    {
        repoCursa.deleteEntity(id);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String userError(Executable e) {
        return e.toString();
    }
}
