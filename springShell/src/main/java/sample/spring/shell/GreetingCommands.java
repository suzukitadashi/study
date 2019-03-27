package sample.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GreetingCommands {

    @ShellMethod("GreetingCommands")
    public void greeting(@ShellOption(defaultValue="9") String text) {
        System.out.println(text);
    }
}
