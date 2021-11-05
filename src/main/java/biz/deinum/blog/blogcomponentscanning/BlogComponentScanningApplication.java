package biz.deinum.blog.blogcomponentscanning;

import java.util.List;

import biz.deinum.blog.blogcomponentscanning.printer.Printer;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author Marten Deinum
 */

@SpringBootApplication
//@ComponentScan(
//    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
//    useDefaultFilters = false,
//    includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = Printer.class)
//})
//@ComponentScan(
//    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
//    useDefaultFilters = false,
//    includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "biz.deinum.blog.blogcomponentscanning.printer.*Printer")
//})
//@ComponentScan(
//    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
//    useDefaultFilters = false,
//    includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "biz.deinum.blog.blogcomponentscanning.printer.Printer+")
//    })
//@ComponentScan(
//    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
//    useDefaultFilters = false,
//    includeFilters = {
//        @ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*Printer")
//    })
//@ComponentScan(
//    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
//    useDefaultFilters = false,
//    includeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = { PrinterTypeFilter.class})
//    })
@ComponentScan(
    basePackages = "biz.deinum.blog.blogcomponentscanning.printer",
    useDefaultFilters = false,
    includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = { PrintingComponent.class})
    })

public class BlogComponentScanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogComponentScanningApplication.class, args);
    }

    @Bean
    public ApplicationRunner printHelloWorl(List<Printer> ps) {
        return args -> ps.forEach(p -> p.print("Hello World!"));
    }
}
