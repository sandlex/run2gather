package com.sandlex.run2gather.runkeeper;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;

/**
 * author: Alexey Peskov
 */
public abstract class MightyTestParent {

    protected String getFileContent(String file) throws IOException {
        InputStream is = getClass().getResourceAsStream("/json/" + file);
        return IOUtils.toString(is);
    }

    protected Date getDate(String date) throws ParseException {
        return DateUtils.parseDate(date, Requestor.DATE_FORMAT);
    }

}
