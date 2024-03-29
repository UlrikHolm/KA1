/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import org.apache.commons.lang3.StringUtils;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author Jeppe
 */
public class JokeFacadeTest {
private static EntityManagerFactory emf;
    private static JokeFacade facade;

    public JokeFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ka1_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = JokeFacade.getFacadeExample(emf);
    }

    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST,EMF_Creator.Strategy.DROP_AND_CREATE);
       facade = JokeFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    Joke joke1 = new Joke("Why do Java programmers wear glasses? Cause they dont C#", "https://www.reddit.com/r/Jokes/comments/1k0tv1/why_do_java_programmers_wear_glasses", "Programmer Joke");
    Joke joke2 = new Joke("Database SQL walked into a NoSQL bar. A little while later they walked out, Because they couldn't find a table!", "https://twitter.com/code4startups?lang=da", "Programmer Joke");
    Joke joke3 = new Joke("A journalist asked a programmer: What makes a code bad? No Comment.", "https://www.freelancinggig.com/blog/2018/12/15/5-hilarious-programming-jokes-for-programmers", "Programmer Joke");
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.createNativeQuery("ALTER TABLE ka1_test.JOKE AUTO_INCREMENT = 1").executeUpdate();
            em.persist(joke1);
            em.persist(joke2);
            em.persist(joke3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testAFacadeMethod() {
        assertEquals(3, facade.getJokeCount(), "Expects tree rows in the database");
    }
     
    @Test
    public void testGetJokeById() {
        Joke joke = facade.getJokeById(joke2.getId());
        assertThat(joke.getJoke(), containsString("Database SQL walked into a NoSQL bar. A little while later they walked out, Because they couldn't find a table!"));
    } 
    
    @Test
    public void testGetAllJokes() {
        List<Joke> result = facade.getAllJokes();
        assertEquals(3, result.size());   
    }  
    
    @Test
    public void testGetRandomJoke() {
        Joke joke = facade.getRandomJoke();
        assertTrue(StringUtils.contains(joke1.getJoke() + joke2.getJoke() + joke3.getJoke(),joke.getJoke()));
        System.out.println("#####" + joke.getJoke());
    }
    
}