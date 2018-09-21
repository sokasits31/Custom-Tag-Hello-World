package com.stevesokasits.customtags;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CountDownTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        LocalDate currentDate = LocalDate.now();

        LocalDate futureDate = LocalDate.parse("2018-11-21");



        int daysUntil = (int) ChronoUnit.DAYS.between(LocalDate.now(), futureDate);

        out.println(daysUntil + " days until oncall support starts");
    }
}
