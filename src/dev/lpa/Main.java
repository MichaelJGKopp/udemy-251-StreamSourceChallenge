package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    int z = 15;

    int[] array = new int[z];
    Arrays.setAll(array, i -> i + 1);
    var firstStream = Arrays.stream(array)
        .mapToObj(i -> "B" + i + " ");
//    firstStream.forEach(System.out::print);
    System.out.println();

    List<Integer> list = new ArrayList<>(Collections.nCopies(z, 1));
    list.replaceAll(i -> list.indexOf(i) + 1 + z);
    var secondStream = list.stream()
      .map(i -> "I" + i + " ");
//    secondStream.forEach(System.out::print);
    System.out.println();

    var thirdStream = Stream.iterate(1 + 2 * z, n -> n <= 3 * z, n -> n + 1)
      .map(i -> "N" + i + " ");
//    thirdStream.forEach(System.out::print);
    System.out.println();

    var fourthStream = IntStream.rangeClosed(1 + 3 * z, 4 * z)
      .mapToObj(i -> "G" + i + " ");
//    fourthStream.forEach(System.out::print);
    System.out.println();

    var fifthStream = Stream.iterate(61, i -> i + 1)
      .limit(15)
      .map(i -> "O" + i + " ");
//    fifthStream.forEach(System.out::print);
//    System.out.println("========================================");

    Stream concStream = Stream.of(
      firstStream, Stream.of("\n"),
      secondStream, Stream.of("\n"),
      thirdStream, Stream.of("\n"),
      fourthStream, Stream.of("\n"),
      fifthStream).flatMap(e -> e);

    concStream.forEach(System.out::print);

  }
}
