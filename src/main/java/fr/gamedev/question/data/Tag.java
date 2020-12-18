package fr.gamedev.question.data;

/**
 * @author alexd
 *
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Tag {

    /**
     *
     */
    @GeneratedValue(generator = "seq_gen_tag")
    @GenericGenerator(name = "seq_gen_tag", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_tag"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    /**
    *
    */
    private String value;

    @ManyToOne
    private Category category;

    //    @ManyToMany(mappedBy = "tags")
    //    private List<User> users = new ArrayList<>();

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
