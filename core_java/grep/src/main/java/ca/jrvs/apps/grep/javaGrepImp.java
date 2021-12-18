package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class javaGrepImp implements javaGrep {
    final Logger logger = LoggerFactory.getLogger(javaGrep.class);
    private String regex;
    private String  rootPath;
    private String outFile;
    public static void main(String[] args) {



         if(args.lenght!=3){

             throw new IllegalArgumentException("USAGE: JavaGrep Regex outFile rootPath");


         }

         //Use default logger config

        BasicConfigurator.configure();
         javaGrepImp grepImp =new javaGrepImp();

         //Set arguments using setter
        grepImp.setRegex(args[0]);
        grepImp.setRootPath(args[1]);
        grepImp.setOutFile(args[3]);

        grepImp.process();

    }

    @Override
    public void process() throws IOException {

    }

    @Override
    public List<File> listfiles(String rootDir) {
        return null;
    }

    @Override
    public boolean containsPattern(String line) {
        return false;
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {

    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public  void setRootPath(String getRootPath) {
               this.rootPath=getRootPath;
    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
       this.regex=regex;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public  void setOutFile(String outfile) {
        this.outFile=outfile;
    }
}
