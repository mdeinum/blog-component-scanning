package biz.deinum.blog.blogcomponentscanning.printer;

import biz.deinum.blog.blogcomponentscanning.PrintingComponent;

/**
 * @author Marten Deinum
 */
@PrintingComponent
class SystemErrPrinter implements Printer {

    @Override
    public void print(String msg) {
        System.err.printf("Message: %s%n", msg);
    }
}
