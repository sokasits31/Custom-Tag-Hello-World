package com.stevesokasits.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalTime;

/**
 * The type Greeting tag.
 */
public class GreetingTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        out.println(timeGreeting());

    }

    private String timeGreeting() {

        // Local Variables
        String timeGreeting;
        LocalTime currentTime = LocalTime.now();

        if (currentTime.isBefore(LocalTime.of(12, 00))) {
            timeGreeting = "Good Morning";
        } else {
            if (currentTime.isBefore(LocalTime.of(17, 00))) {
                timeGreeting = "Good Afternoon";
            } else {
                timeGreeting = "Good Evening";
            }
        }


        return timeGreeting;

    }

}
