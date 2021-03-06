package fr.gamedev.question.data;

/**
 * @author Alexandre_G
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Category {
    /**
    *
    */
    @GeneratedValue(generator = "seq_gen_category")
    @GenericGenerator(name = "seq_gen_category",
                    strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_category"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    /**
    *
    */
    private String name;

    /**
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * @param theId
     */
    public void setId(final long theId) {
        this.id = theId;
    }


    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @param theName
     */
    public void setName(final String theName) {
        this.name = theName;
    }

}
