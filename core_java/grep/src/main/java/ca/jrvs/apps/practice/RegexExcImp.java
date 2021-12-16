package ca.jrvs.apps.practice;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExcImp implements RegexExc {

    @Override
    public boolean matchJpeg(String filename) {
        String filePattern= ".*\\.(png|jpg)";
        if (Pattern.compile(filePattern, Pattern.CASE_INSENSITIVE.filename)){

            return true;

        }else{


            System.out.println("The png|jpg files does not exist");
        }

              return false;
    }

    @Override
    public boolean matchIP(String filename) {
        return false;
    }

    @Override
    public boolean isEmptyLine(String Line) {
        return false;
    }

}
