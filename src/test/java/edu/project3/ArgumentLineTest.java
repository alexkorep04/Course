package edu.project3;

import edu.project3.arguments.Argument;
import edu.project3.arguments.TypeOfArg;
import edu.project3.resolvers.ArgumentLineResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ArgumentLineTest {
    ArgumentLineResolver argumentLineResolver;

    @BeforeEach
    public void createObject() {
        argumentLineResolver = new ArgumentLineResolver();
    }

    @Test
    @DisplayName("Test resolving line, where there is only --path")
    public void testPath() {
        List<String> args = List.of("--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "test.pdf"
        );
        List<Argument> expected = List.of(new Argument(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs test.pdf",
            TypeOfArg.PATH
        ));

        List<Argument> response = argumentLineResolver.getArguments(args);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test resolving line, where there is --path and from")
    public void testPathFrom() {
        List<String> args = List.of("--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--from",
            "2023-08-31"
        );
        List<Argument> expected = List.of(new Argument(
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                TypeOfArg.PATH
            )
            , new Argument("2023-08-31", TypeOfArg.FROM));

        List<Argument> response = argumentLineResolver.getArguments(args);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test resolving line, where there is --path, from and to")
    public void testPathFromTo() {
        List<String> args = List.of("--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--from",
            "2023-08-31",
            "--to",
            "2023-09-30"
        );
        List<Argument> expected = List.of(new Argument(
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                TypeOfArg.PATH
            )
            , new Argument("2023-08-31", TypeOfArg.FROM), new Argument("2023-09-30", TypeOfArg.TO));

        List<Argument> response = argumentLineResolver.getArguments(args);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test resolving line, where there is --path, from and to")
    public void testPathFromToAndFormat() {
        List<String> args = List.of("--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            "--from",
            "2023-08-31",
            "--to",
            "2023-09-30"
            ,
            "--format",
            "adoc"
        );
        List<Argument> expected = List.of(
            new Argument(
                "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
                TypeOfArg.PATH
            )
            ,
            new Argument("2023-08-31", TypeOfArg.FROM),
            new Argument("2023-09-30", TypeOfArg.TO),
            new Argument("adoc", TypeOfArg.FORMAT)
        );

        List<Argument> response = argumentLineResolver.getArguments(args);

        assertThat(expected.size()).isEqualTo(response.size());
        assertThat(expected).isEqualTo(response);
    }

    @Test
    @DisplayName("Test not correct arguments where their size is too low")
    public void testTooLowArguments() {
        List<String> args = List.of("--path");

        assertThatThrownBy(() -> {
            argumentLineResolver.getArguments(args);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Test not correct arguments where --path not first")
    public void testPathNotFirst() {
        List<String> args = List.of(
            "--from",
            "2023-08-31",
            "--to",
            "2023-09-30"
            ,
            "--format",
            "adoc",
            "--path",
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs"
        );

        assertThatThrownBy(() -> {
            argumentLineResolver.getArguments(args);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Test not correct arguments where there is no path")
    public void testWhereThereIsNoPath() {
        List<String> args = List.of("--from", "2023-08-31", "--to", "2023-09-30"
            , "--format", "adoc");

        assertThatThrownBy(() -> {
            argumentLineResolver.getArguments(args);
        }).isInstanceOf(RuntimeException.class);
    }
}
