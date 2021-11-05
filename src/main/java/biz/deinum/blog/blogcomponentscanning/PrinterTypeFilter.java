package biz.deinum.blog.blogcomponentscanning;

import biz.deinum.blog.blogcomponentscanning.printer.Printer;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

/**
 * @author Marten Deinum
 */
public class PrinterTypeFilter implements TypeFilter {

    @Override
    public boolean match(MetadataReader mr, MetadataReaderFactory mrf) {
        var cm = mr.getClassMetadata();
        var cn = cm.getClassName();
        try {
            return Printer.class.isAssignableFrom(ClassUtils.forName(cn, PrinterTypeFilter.class.getClassLoader()));
        } catch (ClassNotFoundException cnfe) {
            throw new IllegalStateException(cnfe);
        }
    }
}
