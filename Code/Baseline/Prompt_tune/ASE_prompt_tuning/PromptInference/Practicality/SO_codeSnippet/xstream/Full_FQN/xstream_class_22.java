@XStreamAlias("container")
public class xstream_class_22 {
  private java.lang.String name;

  // any element named numberOfEmployees should go into this list
  @XStreamImplicit(itemFieldName = "numberOfEmployees")
  protected java.util.List<xstream_class_22.NumberOfPersonnel> numberOfEmployees;

  public xstream_class_22(java.lang.String name, java.util.List<xstream_class_22.NumberOfPersonnel> noEmp) {
    this.name = name;
    this.numberOfEmployees = noEmp;
  }

  public java.lang.String toString() {
    return (name + ", ") + numberOfEmployees;
  }

  public static void main(java.lang.String[] args) throws java.lang.Exception {
    com.thoughtworks.xstream.XStream xs = new com.thoughtworks.xstream.XStream();
    com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println(char[])
    java.io.PrintStream.println(java.lang.String)
    java.io.PrintStream.println()
  }

  @XStreamConverter(value = com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter.class, strings = { "value" })
  public class NumberOfPersonnel {
    public NumberOfPersonnel(int year, double value) {
      this.year = year;
      this.value = value;
    }

    private int year;

    private double value;

    public java.lang.String toString() {
      return (year + ": ") + value;
    }
  }
}
