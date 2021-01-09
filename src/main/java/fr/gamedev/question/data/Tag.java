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
    @GenericGenerator(name = "seq_gen_tag", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_tag"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    //TODO grp2 by DJE : JavaDoc : le commentaire JavaDoc ne devrait pas être vide !
    /**
    *
    */
    private String value;

    //TODO grp2 by DJE : JavaDoc : ce commentaire semble (devenu?) faux.
    /**.
     * Many tag to many category
     */
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

    /**
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * @param theValue
     */
    public void setValue(final String theValue) {
        this.value = theValue;
    }

    /**
     * @return Category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param theCategory
     */
    public void setCategory(final Category theCategory) {
        this.category = theCategory;
    }

}
