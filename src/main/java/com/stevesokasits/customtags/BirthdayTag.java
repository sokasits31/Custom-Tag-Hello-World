package com.stevesokasits.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

/**
 * The type Greeting tag.
 */
public class BirthdayTag extends SimpleTagSupport {

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();

        JspWriter out = getJspContext().getOut();

        out.println(birthdayGreeting());

    }


    private String birthdayGreeting () {

        Map<String, LocalDate> birthdays = new TreeMap<>();

        birthdays.put("Steve", LocalDate.parse("1972-06-09"));
        birthdays.put("Heather", LocalDate.parse("1977-09-23"));
        birthdays.put("Lea",LocalDate.parse("2008-07-21"));
        birthdays.put("Bradley",LocalDate.parse("2010-10-16"));


        int count = 0;
        String greeting = null;

        for(Map.Entry<String , LocalDate> entry: birthdays.entrySet()) {

            String person = entry.getKey();
            LocalDate birthday = entry.getValue();

            String birthdayMonthDay = Integer.toString(birthday.getMonthValue())
                    + Integer.toString(birthday.getDayOfMonth());

            if (birthdayMonthDay.equals(getCurrentMonthDay())) {
                count ++;
                if (count == 1) {
                    greeting = "Happy Birthday " + person;
                } else {
                    greeting += " and " + person;
                }
            }

            if (count > 1) {
                greeting += "!";
            }

        }

        return greeting;

    }

    private String getCurrentMonthDay () {

        String currentMonthDay = Integer.toString(LocalDate.now().getMonthValue()) +
                Integer.toString(LocalDate.now().getDayOfMonth());

        return currentMonthDay;

    }


}

