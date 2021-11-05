package biz.deinum.blog.blogcomponentscanning.printer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Marten Deinum
 */
class FilePrinter /* implements Printer */ {

    public void print(String msg) {
        var f = Paths.get(System.getProperty("user.dir"), "printer.txt");
        try {
            var line = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME) + ": " + msg + System.lineSeparator();
            Files.writeString(f, line, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("Error appending to file '"+f+"'.", e);
        }
    }
}
