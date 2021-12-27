package ca.jrvs.apps.grep;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.log4j.BasicConfigurator;

import java.io.*;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.io.FileDescriptor.in;

public class JavaGrepImp implements JavaGrep {

    static final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
    private String regex;
    private String rootPath;
    private String outFile;


    public static void main(String[] args) throws IOException {

         if(args.length!=3){

             throw new IllegalArgumentException("Error!! USAGE: JavaGrep Regex outFile rootPath");


         }

         //Use default logger config

        BasicConfigurator.configure();
         JavaGrepImp grepImp =new JavaGrepImp();

         //Set arguments using setter
        grepImp.setRegex(args[0]);
        grepImp.setRootPath(args[1]);
        grepImp.setOutFile(args[2]);
        try {
            grepImp.process();
        }catch (Exception message){
            JavaGrepImp.logger.error("Error unable to process",message);
        }

    }

    @Override
    public void process() throws IOException {
        List <String> lineMatched =new ArrayList<String>();
        //   for (int i =0;i< ArrayList.length;i++)
        for (File  file :listFiles(rootPath)){
            for (String lines :readLines(file)){
                if (containsPattern(lines)){
                    lineMatched.add(lines);
                    writeToFile(lineMatched);
                }
            }
        }
    }

    public List <String> readLines(File file) throws IOException {
        List <String> lines =new ArrayList<>();
        BufferedReader bReader;

        try {
            String line;
            bReader = new BufferedReader(new FileReader(in));
            line = bReader.readLine();
            lines.add(line);
          line=bReader.readLine();
            bReader.close();
        }catch (IOException ex){
            ex.printStackTrace();


        }

        return lines;

    }

    @Override
    public List<File> listFiles(String rootDir) {
         File file = new File (rootDir);
         ArrayList<File> files =new ArrayList<File>(Arrays.asList(file.listFiles()));
         return files;

    }

    @Override
    public boolean containsPattern(String line) {
        return line.matches(regex);
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        FileWriter fWriter = new FileWriter(outFile);
        for (String line : lines){

            fWriter.write(line);
        }
        fWriter.close();



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
