
/**
 * @author alexd
 *
 */
package fr.gamedev.question.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Skill {

    /**
     *
     */
    @GeneratedValue(generator = "seq_gen_skill")
    @GenericGenerator(name = "seq_gen_skill", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_skill"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    /**
     *
     */
    private String label;
    /**
    *
    */
    private String name;

    /**
    *
    */
    @ManyToMany(mappedBy = "skills")
    private List<User> users = new ArrayList<>();

    /**
     * @return the users
     */
    public List<User> getUsers() {
        return users;
    }

    // Setter volontairement retiré

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param identifiant
     */
    public void setId(final long identifiant) {
        this.id = identifiant;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param unLabel
     */
    public void setLabel(final String unLabel) {
        this.label = unLabel;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param unName
     */
    public void setName(final String unName) {
        this.name = unName;
    }

}
