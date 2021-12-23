package ca.jrvs.apps.grep;

import java.io.File;
import java.util.List;

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
                 JavaGrepImp.logger.error("Error unable to process",ex);
             }


        }
    }

    @Override
    public List<String> readLines(File inputfile){

        return readLines(inputfile);
    }
    @Override
    public List <File> listFiles(String rootDir){

return listFiles(rootDir);

    }

}
