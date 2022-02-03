package ca.jrvs.apps.practice;

import java.util.regex.Pattern;

public interface RegexExc {
    /**
     *
     *
     * @param filename
     * @return
     * @exception 
     */

    public Pattern matchJpeg(String filename);

    /**
     *
     * @param ip
     * @return
     */
    public Pattern matchIP(String ip);

    /**
     *
     * @param Line
     * @return
     */
    public boolean isEmptyLine(String Line);
    /**
     *
     */
}
