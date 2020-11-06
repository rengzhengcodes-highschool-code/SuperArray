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

}
