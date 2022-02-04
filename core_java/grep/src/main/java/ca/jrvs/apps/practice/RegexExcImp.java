package ca.jrvs.apps.practice;


import java.util.regex.Pattern;


public class RegexExcImp implements RegexExc {

    @Override
    public Pattern matchJpeg(String filename) {
        String filePattern=".*\\.(png|jpg)";
     return Pattern.compile(filePattern);

    }

    @Override
    public Pattern matchIP(String ip) {


     String ipPattern= "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

        return Pattern.compile(ipPattern);

    }

    @Override
    public boolean isEmptyLine(String line) {
          String emptyLinePattern ="^\\s*$";
               boolean b = Pattern.matches("^\\s*$","^\\s*$");

        return b;

    }

}
