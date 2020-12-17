package fr.gamedev.question.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
     *
     */
    @GeneratedValue(generator = "seq_gen_user")
    @GenericGenerator(name = "seq_gen_user", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "seq_user"), @Parameter(name = "initial_value", value = "0"),
            @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    /**
     *
     */
    private String login;
    /**
     *
     */
    private String lastName;

    /**
    *
    */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "user_skill", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private List<Skill> skills = new ArrayList<>();

    /**
     * @return the skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    // Setter volontairement retiré

    /**
     * @param skill
     */
    public void addSkill(final Skill skill) {
        skills.add(skill);
        skill.getUsers().add(this);
    }

    /**
     * @param skill
     */
    public void removeSkill(final Skill skill) {
        skills.remove(skill);
        skill.getUsers().remove(this);
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param unLogin the login to set
     */
    public void setLogin(final String unLogin) {
        this.login = unLogin;
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

}
