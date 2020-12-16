package fr.gamedev.question.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

author djer1
 *
 */
@RestController
public class GreetingController {

    /**
     *
     */
    private static final String TEMPLATE = "Hello, %s!";
    /**
     *
     */
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public final Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {
        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }
}
