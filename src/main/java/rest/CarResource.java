
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Car;
import facades.CarFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

@Path("car")
public class CarResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ka1",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final CarFacade FACADE =  CarFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCars() {
        List<Car> joke = FACADE.getAllCars();
        return GSON.toJson(joke);
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCarCount() {
        long count = FACADE.getCarCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getCarsById(@PathParam("id") long id) {
        return GSON.toJson(FACADE.getCarById(id));
    }

    @Path("/{make}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCarMake(@PathParam("make") String make) {
        return GSON.toJson(FACADE.getCarMake(make));
    }
 
}