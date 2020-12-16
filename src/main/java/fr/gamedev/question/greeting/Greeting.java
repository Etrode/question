/**
 *
 */
package fr.gamedev.question.greeting;

/**
 * @author djer1
 *
 */
public class Greeting {

    /**
     *
     */
    private final long id;
    /**
     *
     */
    private final String content;

    public Greeting(final long unId, final String unContent) {
        this.id = unId;
        this.content = unContent;
    }

    public final long getId() {
        return id;
    }

    public final String getContent() {
        return content;
    }

}
