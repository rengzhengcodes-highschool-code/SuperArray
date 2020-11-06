public class Demo {
  public static void removeDuplicates(SuperArray s){
    SuperArray.removeDuplicates(s);
  }

  public static void main(String[]args){
    SuperArray words = new SuperArray();
    //grouped to save vertical space
    words.add("kani");   words.add("uni");     words.add("ebi");     words.add("una");
    words.add("una");    words.add("ebi");     words.add("kani");    words.add("una");
    words.add("una");    words.add("ebi");     words.add("toro");

    System.out.println(words);
    removeDuplicates(words);
    System.out.println(words);
  }

  public static SuperArray findOverlap(SuperArray a, SuperArray b) {
    SuperArray overlap = new SuperArray();

    String[] aElements = a.toArray();
    String[] bElements = b.toArray();
    for (String elementa : aElements) {
      for (String elementb : bElements) {
        if (elementa.equals(elementb)) {
          overlap.add(elementa);
        }
      }
    }

    removeDuplicates(overlap);
    return overlap;
  }

  public static SuperArray zip(SuperArray a, SuperArray b) {
    int lowestSize = Math.min(a.size(), b.size());

    String[] elementsA = a.toArray();
    String[] elementsB = b.toArray();
    String[] largest;
    if (elementsA.length > elementsB.length) {
      largest = elementsA;
    } else {
      largest = elementsB;
    }

    SuperArray output = new SuperArray(lowestSize * 2);
    int index = 0;
    for (; index < lowestSize; index++) {
      output.add(elementsA[index]);
      output.add(elementsB[index]);
    }

    for (; index < largest.length; index++) {
      output.add(largest[index]);
    }

    return output;
  }

}
