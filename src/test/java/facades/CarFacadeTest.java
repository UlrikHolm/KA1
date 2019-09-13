/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Car;
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

public class CarFacadeTest {
private static EntityManagerFactory emf;
    private static CarFacade facade;

    public CarFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ka1_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = CarFacade.getFacadeExample(emf);
    }

    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST,EMF_Creator.Strategy.DROP_AND_CREATE);
       facade = CarFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    Car car1 = new Car(1999, "Toyota", "Corolla", 15000);
    Car car2 = new Car(2018, "VW", "Golf", 150000);
    Car car3 = new Car(2004, "Opel", "Meriva", 45000);

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Car.deleteAllRows").executeUpdate();
            em.createNativeQuery("ALTER TABLE ka1_test.CAR AUTO_INCREMENT = 1").executeUpdate();
            em.persist(car1);
            em.persist(car2);
            em.persist(car3);
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
        assertEquals(3, facade.getCarCount(), "Expects three rows in the database");
    }
     
    @Test
    public void testGetCarById() {
        Car car = facade.getCarById(car2.getId());
        assertThat(car.getMake(), containsString("VW"));
    } 
    
    @Test
    public void testGetAllCars() {
        List<Car> result = facade.getAllCars();
        assertEquals(3, result.size());   
    }

}