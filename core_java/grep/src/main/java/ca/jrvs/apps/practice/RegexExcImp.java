package ca.jrvs.apps.practice;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
    private static final String IPV4_PATTERN =
            "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";

    private static final Pattern pattern = Pattern.compile(IPV4_PATTERN);

    public static boolean isValid(final String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }*/
/*Pattern p = Pattern.compile("\n{2,}");
String line = "\n\n";
System.out.println(p.matcher(line).find());*/

public class RegexExcImp implements RegexExc {

    @Override
    public boolean matchJpeg(String filename) {
        String filePattern= ".*\\.(png|jpg)";
      if (Pattern.compile(filename, Pattern.CASE_INSENSITIVE.filename)){

           return true;

       }else{


            System.out.println("The png|jpg files does not exist");
        }

              return false;
    }

    @Override
    public boolean matchIP(String ip) {


     String ipPattern= "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
                //"/^[0-9]\+\.[0-9]\+\.[0-9]\+\.[0-9]\+$/";


        boolean b = Pattern.matches("^\\s*$","^\\s*$");
        return Pattern.compile(ip,Pattern.ipPattern);
    }

    @Override
    public boolean isEmptyLine(String line) {
          String emptyLinePattern ="^\\s*$";
               boolean b = Pattern.matches("^\\s*$","^\\s*$");

        return b;
                //Pattern.matches("^\\s*$","^\\s*$");
    }

}
