public class SuperArray {

  private String[] data;
  private int size = 0; //current array size

  public SuperArray() {
    this.size = 0;
    this.data = new String[8];
  }

  public int size()  {
    return this.size;
  }

  public boolean add(String element) {
    if (this.size == this.data.length) {
      this.resize();
    }

    this.data[this.size] = element;
    this.size++;
    return true;
  }

  public String get(int index) {
    if (index < this.size) {
      return this.data[index];
    } else {
      return null;
    }
  }

  public String set(int index, String element) {
    String replaced = this.data[index];
    this.data[index] = element;
    return replaced;
  }

  private void resize() {
    String[] dataNew = new String[this.data.length + 8];

    for (int index = 0; index < this.data.length; index++) {
      dataNew[index] = this.data[index];
    }

    this.data = dataNew;
  }

  public void clear() {
    this.data = new String[8];
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public String toString() {
    int addedValues = 0;
    String output = "[";
    String spacer = ", ";
    for (int i = 0; i < this.data.length; i++) {
      if (data[i] != null) {
        addedValues++;
        output += this.data[i] + spacer;
      }
    }

    if (output.contains(", ")) {
      output = output.substring(0, output.lastIndexOf(", "));
    }

    output += "]";
    return output;
  }

  public boolean contains(String s) {
    if (s == null || this.size == 0) {
      return false;
    }

    for (String element : this.data) {
      if (element != null && element.equals(s)) {
        return true;
      }
    }
    return false;
  }

  public SuperArray(int initialCapacity) {
      this.size = 0;
      this.data = new String[initialCapacity];
  }

}
