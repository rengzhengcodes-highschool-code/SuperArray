import java.util.Arrays;

public class DemoTester {

  public static void main(String[] args) {
    String[] aElements = {
      "9","1","2","2","3","4"
    };
    String[] bElements = {
      "0","4","2","2","9"
    };
    SuperArray a = new SuperArray();
    SuperArray b = new SuperArray();

    for (String element : aElements) {
      a.add(element);
    }
    for (String element : bElements) {
      b.add(element);
    }

    SuperArray output = Demo.findOverlap(a, b);
    String[] expectedArray = {"9","2","4"};
    if (Arrays.equals(output.toArray(), expectedArray)) {
      System.out.println("findOverlap() passed.");
    } else {
      System.out.println("findOverlap() failed. Expected: " + expectedArray.toString()
      + " \t Actual: " + output.toArray().toString());
    }
  }

}
