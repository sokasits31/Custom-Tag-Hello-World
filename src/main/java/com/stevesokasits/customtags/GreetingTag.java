package com.stevesokasits.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;

public class GreetingTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        LocalTime currentTime = LocalTime.now();


        if (currentTime.isBefore(LocalTime.of(12,00))) {
            out.println("Good Morning");
        } else {
            if (currentTime.isBefore(LocalTime.of(17,00))) {
                out.println("Good Afternoon");
            } else {
                out.println("Good Evening");
            }

        }

    }
}
