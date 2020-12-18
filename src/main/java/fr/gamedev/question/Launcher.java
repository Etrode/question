/**
 *
 */
package fr.gamedev.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author djer1
 *
 */
@SpringBootApplication
@SuppressWarnings("checkstyle:hideutilityclassconstructor")
public class Launcher {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

}
