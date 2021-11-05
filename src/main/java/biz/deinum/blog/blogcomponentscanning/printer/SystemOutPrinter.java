package biz.deinum.blog.blogcomponentscanning.printer;

import biz.deinum.blog.blogcomponentscanning.PrintingComponent;

import org.springframework.stereotype.Component;

/**
 * @author Marten Deinum
 */
// @Component
@PrintingComponent
class SystemOutPrinter implements Printer {

    @Override
    public void print(String msg) {
        System.out.printf("Message: %s%n", msg);
    }
}
