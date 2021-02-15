package fr.gamedev.question.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
/**
 * @author alexd
 *
 */
@Entity
public class User {

    /**
     * id.
     */
    @GeneratedValue(generator = "seq_gen_user")
    @GenericGenerator(name = "seq_gen_user", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_user"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    /**
     * firstname.
     */
    private String firstname;
    /**
     * lastname.
     */
    private String lastName;

    /**
    * Many User to many Tag.
    */
    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Tag> preferences;

    /**
    * Many User to many Question.
    */
    @ManyToMany
    private List<Question> attributedQuestions;

    /**
     * @return the tags
     */
    public List<Tag> getPreferences() {
        if (preferences == null) {
            preferences = new ArrayList<Tag>();
        }
        return preferences;
    }

    /**
     * @param lTags
     */
    public void setPreferences(final List<Tag> lTags) {
        this.preferences = preferences;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param unId the id to set
     */
    public void setId(final long unId) {
        this.id = unId;
    }

    /**
     * @return the unFirstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param unFirstname the firstname to set
     */
    public void setFirstname(final String unFirstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param unLastName the lastName to set
     */
    public void setLastName(final String unLastName) {
        this.lastName = unLastName;
    }

    /**
     * @return list of questions
     */
    public List<Question> getQuestions() {
        if (attributedQuestions == null) {
            attributedQuestions = new ArrayList<Question>();
        }
        return attributedQuestions;
    }

    /**
     * @param theQuestions the questions to set
     */
    public void setQuestions(final List<Question> theQuestions) {
        this.attributedQuestions = theQuestions;
    }

}
