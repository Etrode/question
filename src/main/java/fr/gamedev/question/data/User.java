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
    @GenericGenerator(name = "seq_gen_user", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = { @Parameter(name = "sequence_name", value = "seq_user"),
                    @Parameter(name = "initial_value", value = "0"), @Parameter(name = "increment_size", value = "1") })
    @Id
    private long id;
    /**
     *
     */
    private String firstname;
    /**
     *
     */
    private String lastName;

    //TODO grp2 by DJE : JavaDoc : le commentaire JavaDoc ne devrait pas être vide !
    /**
    *
    */
    @ManyToMany(cascade = { CascadeType.ALL })
    //TODO grp1 by DJE : ORM : l'annotation @JoinTable est optionnelles et il faut eviter de l'utiliser. Cela créer des liens avec la BDD directement, ce que justement l'ORM essaie d'éviter. Cette annotation sert surtout lorsque l'on ajoute l'ORM après coups et que les règles par defaut n'ont pas été appliquées.
    @JoinTable(name = "user_tag", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    //TODO grp1 by DJE : POO : si cetet attribut s'apellait "prefrences" votre API serait beaucoup plus claire (avec un très petit effort). On pourrait lire "un utilsiateur a des préférences qui est une liste de tags".
    private List<Tag> tags = new ArrayList<>();

    /**
     * @return the tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * @param lTags
     */
    public void setTags(final List<Tag> lTags) {
        this.tags = lTags;
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
     * @param unFirstname the login to set
     */
    public void setLogin(final String unFirstname) {
        this.firstname = unFirstname;
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
