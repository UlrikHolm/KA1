package facades;

import entities.Joke;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import static oracle.jrockit.jfr.events.Bits.intValue;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private JokeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Joke getJokeById(long id){
         EntityManager em = emf.createEntityManager();
        try{
            Joke joke = em.find(Joke.class, id);
            return joke;
        }finally {
            em.close();
        }
    }
    
    public List<Joke> getAllJokes() {
    EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Joke> query = 
                       em.createQuery("Select j from Joke j",Joke.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    
    //TODO Remove/Change this before use
    public long getJokeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long jokeCount = (long)em.createQuery("SELECT COUNT(j) FROM Joke j").getSingleResult();
            return jokeCount;
        }finally{  
            em.close(); 
        }
            
    }
    
    public Joke getRandomJoke () {           
        EntityManager em = emf.createEntityManager();
        try{
            Random rand = new Random();
            long randLong = Long.valueOf(rand.nextInt((int) getJokeCount()))+1;
            System.out.println("######## " + randLong);
            Joke joke = em.find(Joke.class, randLong);
            return joke;
        }finally {
            em.close();
        }
        
    }
    
    
}
