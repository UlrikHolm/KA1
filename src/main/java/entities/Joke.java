
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jeppe
 */
@Entity
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke")
public class Joke implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String joke;
    private String reference;
    private String type;

    public Joke() {
    }
    
    public Joke(String joke, String reference, String type) {
        this.joke = joke;
        this.reference = reference;
        this.type = type;
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getJoke() {
            return joke;
        }

        public void setJoke(String joke) {
            this.joke = joke;
        }

        public String getReference() {
            return reference;
        }

        public void setReference(String reference) {
            this.reference = reference;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }


}