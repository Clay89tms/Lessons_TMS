package idCarsServlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class MyTag extends SimpleTagSupport {

    StringWriter sw = new StringWriter();
    private String count;
    private Long count1;

    @Override
    public void doTag() throws JspException, IOException {
        getJspBody().invoke(sw);
        long count = Long.parseLong(this.count);

        JspWriter out = getJspContext().getOut();

        out.println("<ul>");
        for (int i = 0; i < count; i++) {
            out.println("<li>");
            out.println(sw.toString().toUpperCase());
            out.println("</li>");
        }
        out.println("</ul>");

    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
