/**
 *
 */
package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
@Entity
public class UserAnswer {

    /**
     *
     */
    @GeneratedValue(generator = "seq_gen_userAnswer")
    @GenericGenerator(name = "seq_gen_userAnswer", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_answerUser"),
            @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    /**
     *
     */
    @ManyToOne
    private User user;
    /**
    *
    */
    @ManyToOne
    /**
    *
    */
    private Answer answer;
    /**
    *
    */
    private long points;

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
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param unUser the user to set
     */
    public void setUser(final User unUser) {
        this.user = unUser;
    }

    /**
     * @return the points
     */
    public long getPoints() {
        return points;
    }

    /**
     * @param desPoints the points to set
     */
    public void setPoints(final long desPoints) {
        this.points = desPoints;
    }

    /**
     * @return the answer
     */
    public Answer getAnswer() {
        return answer;
    }

    /**
     * @param uneAnswer the answer to set
     */
    public void setAnswer(final Answer uneAnswer) {
        this.answer = uneAnswer;
    }

}
