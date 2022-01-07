package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.io.file.Files;
import java.io.file.Path;
import java.io.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaGrepLambdaImp extends JavaGrepImp {

    public static void main(String[] args) {
        if (args.length!=3){
            //Creating JavaGrepLambdaImp instead of JavaGrepImp
            // JavaGrepLambdaImp inherits all methods  except two pverride methods in

            JavaGrepLambdaImp javaGrepLambdaImp =new JavaGrepLambdaImp();
            javaGrepLambdaImp.setRegex(args[0]);
            javaGrepLambdaImp.setRootPath(args[1]);
            javaGrepLambdaImp.setOutFile(args[2]);

             try{
                 javaGrepLambdaImp.process();

             }catch(Exception ex){

                // ex.printStackTrace();
                 javaGrepLambdaImp. logger.error("Error unable to process",ex);
             }


        }
    }

    @Override
    public List<String> readLines(File inputFile){
              List<String> lines = new ArrayList<>();
              String fName = inputFile.toString();
              Path pathOfFile = Paths.get(fName);

              try{

                 // lines =Files.lines(pathOfFile).collect(Collectors.toList());
                  lines=Files.list(Paths.get(getRootPath())).map(Path::toFile).collect(Collectors.toList());


              }catch(Exception ex){

                  logger.error("Error unable to process",ex);
              }





        return lines;
    }
    @Override
    public List <File> listFiles(String rootDir){
        try {
            List<File> files = Files.list(Paths.get(rootDir)).map(Path::toFile).collect(Collectors.toList());
        } catch (IOException ex) {
            logger.error("Error unable to process",ex);
        }
        return listFiles(rootDir);

    }

}
