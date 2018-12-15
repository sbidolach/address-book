package com.gumtree.book.utils;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class DateUtilsTest {

    @Test
    public void parseDateStringOK() {
        Date actualDate = DateUtils.parseDateString("03/12/79");
        Calendar cal = Calendar.getInstance();
        cal.setTime(actualDate);

        assertEquals(1979, cal.get(Calendar.YEAR));
        assertEquals(12, cal.get(Calendar.MONTH) + 1);
        assertEquals(3, cal.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void parseDateStringReturnNullWhenSetDateHasWrongFormat() {
        assertNull(DateUtils.parseDateString("WRONG_DATE"));
    }

}