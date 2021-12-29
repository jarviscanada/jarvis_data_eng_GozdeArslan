package ca.jrvs.apps.grep;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class JavaGrepImp implements JavaGrep {

     final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
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
        grepImp.process();

        try {
            grepImp.process();
        }catch (Exception message){
            grepImp.logger.error("Error unable to process",message);
        }

    }

    @Override
    public void process() throws IOException {
        List <String> lineMatched =new ArrayList<>();
        //   for (int i =0;i< ArrayList.length;i++)
        try{
            for (File  file :listFiles(getRootPath())) {
                for (String lines : readLines(file)) {
                    if (containsPattern(lines)) {
                        lineMatched.add(lines);
                    }
                    this.writeToFile(lineMatched);
                }
            }
            }catch (IOException ex){

                        throw new IOException("Cannot Write to File");
                    }





    }

    public List <String> readLines(File file) {
        List <String> lines =new ArrayList<>();

           try {
                BufferedReader bReader;
                String line;
                bReader = new BufferedReader(new FileReader(file));
                line = bReader.readLine();
                lines.add(line);
                bReader.close();
            }catch (FileNotFoundException ex){

                ex.printStackTrace();

            } catch (IOException e) {
               e.printStackTrace();
           }


        return lines;

    }

    @Override
    public List<File> listFiles(String rootDir) {

        File file = new File(rootDir);
        ArrayList<File> files =new ArrayList<>(Arrays.asList(file.listFiles()));
        return files;

    }

    @Override
    public boolean containsPattern(String line) {
        return line.matches(regex);
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        File fileOut = new File(outFile);
        FileOutputStream fos = new FileOutputStream(fileOut);

        BufferedWriter BuffWrite = new BufferedWriter(new OutputStreamWriter(fos));
        for (String temp: lines) {
            try {
                BuffWrite.write(temp);
                BuffWrite.newLine();
            }catch (IOException e) {
                e.printStackTrace();
            }
        } BuffWrite.close();



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