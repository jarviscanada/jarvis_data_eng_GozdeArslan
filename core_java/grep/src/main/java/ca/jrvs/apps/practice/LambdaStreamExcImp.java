package ca.jrvs.apps.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStreamExcImp implements  LambdaStreamExc{
    @Override
    public Stream<String> createStrStream(String... strings) {

        Stream <String> strStream = Arrays.stream(strings) ;
        return  strStream;

   }

    @Override
    public Stream<String> toUpperCase(String... strings) {
        Stream <String> strStream = Stream.of(strings);
        return strStream.map(String::toUpperCase);
    }

    @Override
    public Stream<String> filter(Stream<String> stringStream, String pattern) {

       // Stream<String> filter = Stream.of(stringStream);

        return stringStream.filter(str->(str.contains(pattern)));
    }

    @Override
    public IntStream createIntStream(int[] arr) {
      //  IntStream intStream =IntStream.of(arr) ;
      //  return intStream;
        return IntStream.of(arr);
    }

    @Override
    public <E> List<E> toList(Stream<E> stream) {


        return stream.collect(Collectors.toList());
    }

    @Override
    public List<Integer> toList(IntStream intStream) {
        //The boxed method converts the int primitive values of an IntStream into a stream of Integer objects
        return intStream.boxed().collect(Collectors.toList());
    }

    @Override
    public IntStream createIntStream(int start, int end) {
      /*  IntStream intStream = IntStream.range(start, end);
        return intStream;*/
        return IntStream.range(start, end);
    }

    @Override
    public DoubleStream squareRootIntStream(IntStream intStream) {
         DoubleStream stream =intStream.mapToDouble(n->(double)(n));

       // return stream.map(Math.sqrt);
        return stream.map(n->n*n);
    }

    @Override
    public IntStream getOdd(IntStream intStream) {
       // Stream<String> filter = Stream.of(stringStream);
        /*Set<Integer> oddNumbers = Stream.of(intStream)
                .filter(n->n%2!= 0).boxed().collect(Collectors.toSet());*/
    // IntStream strStream = Arrays.stream(intStream) ;
     // int results=  Arrays.intStream(intStream).filter(i -> i % 2 != 0).getAsInt();
        return intStream.filter(n -> n%2==1);

      //  return (IntStream) oddNumbers;


    }

    @Override
    public Consumer<String> getLambdaPrinter(String prefix, String suffix) {
       // Consumer <String> n = Arrays.stream();
         //       forEach(a -> System.out.print(prefix+ " "+suffix));


        return n->System.out.print(prefix+suffix);



    }

    @Override
    public void printMessages(String[] messages, Consumer<String> printer) {

    }

    @Override
    public void printOdd(IntStream intStream, Consumer<String> printer) {

    }

    @Override
    public Stream<Integer> flatNestedInt(Stream<List<Integer>> ints) {
        return null;
    }
}
