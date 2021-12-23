package ca.jrvs.apps.grep;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;

public interface JavaGrep {


    /**
     * Top level search Work flow
     * @throws IOException
     */
    void process() throws IOException;

    /**
     *
     * @param rootDir
     * @return
     */
    List<File> listFiles(String rootDir);

    /**
     *
     * @param line
     * @return
     */
    boolean  containsPattern(String line);

    /**
     *
     * @param lines
     * @throws IOException
     */
    void writeToFile(List<String> lines) throws IOException;

    /**
     *
     * @return
     */
    String getRootPath();

    /**
     *
     * @param getRootPath
     * @return
     */
    void setRootPath(String getRootPath);

    /**
     *
     * @return
     */
    String getRegex();

    /**
     *
     * @param regex
     */
    void setRegex(String regex);

    /**
     *
     * @return
     */
    String getOutFile();

    /**
     *
     * @param outfile
     */
    void setOutFile(String outfile);

}
