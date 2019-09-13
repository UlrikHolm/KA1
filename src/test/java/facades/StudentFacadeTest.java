package facades;

import utils.EMF_Creator;
import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class StudentFacadeTest {

    private static EntityManagerFactory emf;
    private static StudentFacade facade;
    Student s1 = (new Student("Jeppe", "cph-xx34", "Yellow"));
    Student s2 = (new Student("Joshua", "cph-xx12", "Green"));
    Student s3 = (new Student("Ulrik", "cph-uh76", "Yellow"));
    
    public StudentFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ka1_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = StudentFacade.getFacadeExample(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = StudentFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Student.deleteAllRows").executeUpdate();
            em.createNativeQuery("ALTER TABLE ka1_test.STUDENT AUTO_INCREMENT = 1").executeUpdate();
            em.persist(s1);
            em.persist(s2);
            em.persist(s3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(3, facade.getRenameMeCount(), "Expects tree rows in the database");
    }
        
    @Test
    public void testGetStudentById() {
        Student s = facade.getStudentById(s2.getId());
        assertThat(s.getName(), containsString("Joshua"));
    } 
    
    @Test
    public void testGetAllStudents() {
        List<Student> result = facade.getAllStudents();
        assertEquals(3, result.size());   
    }  
    
}
