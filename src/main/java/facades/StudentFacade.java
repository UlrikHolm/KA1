package facades;

import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class StudentFacade {

    private static StudentFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private StudentFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static StudentFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Student getStudentById(long id){
         EntityManager em = emf.createEntityManager();
        try{
            Student stud = em.find(Student.class, id);
            return stud;
        }finally {
            em.close();
        }
    }
    
    public List<Student> getAllStudents() {
    EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Student> query = 
                       em.createQuery("Select s from Student s",Student.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(s) FROM Student s").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
        
    }

}
