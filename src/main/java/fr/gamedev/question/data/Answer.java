package fr.gamedev.question.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author djer1
 *
 */
@Entity
public class Answer {

    /**
    * Id.
    */
    @GeneratedValue(generator = "seq_gen_answer")
    @GenericGenerator(name = "seq_gen_answer", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_answer"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;

    /**
     * Correct answer.
     */
    private Boolean correctAnswer;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param theId the id to set
     */
    public void setId(final long theId) {
        this.id = theId;
    }

    /**
     * @return the correctAnswer
     */
    public Boolean getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * @param theCorrectAnswer the correctAnswer to set
     */
    public void setCorrectAnswer(final Boolean theCorrectAnswer) {
        this.correctAnswer = theCorrectAnswer;
    }

}
