package facades;

import entities.Car;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private CarFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CarFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Car getCarById(long id){
         EntityManager em = emf.createEntityManager();
        try{
            Car car = em.find(Car.class, id);
            return car;
        }finally {
            em.close();
        }
    }
    
    public List<Car> getAllCars() {
    EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Car> query = 
                       em.createQuery("Select c from Car c",Car.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    
    //TODO Remove/Change this before use
    public long getCarCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long CarCount = (long)em.createQuery("SELECT COUNT(c) FROM Car c").getSingleResult();
            return CarCount;
        }finally{  
            em.close();
        }   
    }

    public List<Car> getCarMake(String make){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Car> car_make = em.createQuery("SELECT c FROM Car c WHERE c.make = :make", Car.class);
            return car_make.getResultList();
        } finally {
            em.close();
        }
    }

}