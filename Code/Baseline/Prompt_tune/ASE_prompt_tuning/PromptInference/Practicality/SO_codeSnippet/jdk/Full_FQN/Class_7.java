public class Class_7 {
  public static class Person {
    public java.lang.String name;

    public int id;

    public java.util.Date hireDate;

    public Person(java.lang.String iname, int iid, java.util.Date ihireDate) {
      name = iname;
      id = iid;
      hireDate = ihireDate;
    }

    public java.lang.String toString() {
      return (((name + " ") + id) + " ") + java.util.Date.toString();
    }

    // Comparator
    public static class CompId implements java.util.Comparator<Class_.Class_7.Person> {
      @java.lang.Override
      public int compare(Class_.Class_7.Person arg0, Class_.Class_7.Person arg1) {
        return arg0.id - arg1.id;
      }
    }

    public static class CompDate implements java.util.Comparator<Class_.Class_7.Person> {
      private int mod = 1;

      public CompDate(boolean desc) {
        if (desc)
          mod = -1;

      }

      @java.lang.Override
      public int compare(Class_.Class_7.Person arg0, Class_.Class_7.Person arg1) {
        return mod * java.util.Date.compareTo(java.util.Date);
      }
    }
  }

  public static void main(java.lang.String[] args) {
    // TODO Auto-generated method stub
    java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("mm-dd-yyyy");
    java.util.ArrayList<Class_.Class_7.Person> people;
    people = new java.util.ArrayList<Class_.Class_7.Person>();
    try {
      java.util.ArrayList.add(java.lang.Object)
      java.util.ArrayList.add(java.lang.Object)
      java.util.ArrayList.add(java.lang.Object)
    } catch (java.text.ParseException e) {
      java.lang.Throwable.printStackTrace()
    }
    java.util.Collections.sort(java.util.List,java.util.Comparator)
    java.io.PrintStream.println(java.lang.String)
    for (Class_.Class_7.Person p : people) {
      java.io.PrintStream.println(java.lang.String)
    }
    java.util.Collections.sort(java.util.List,java.util.Comparator)
    java.io.PrintStream.println(java.lang.String)
    for (Class_.Class_7.Person p : people) {
      java.io.PrintStream.println(java.lang.String)
    }
    java.util.Collections.sort(java.util.List,java.util.Comparator)
    java.io.PrintStream.println(java.lang.String)
    for (Class_.Class_7.Person p : people) {
      java.io.PrintStream.println(java.lang.String)
    }
  }
}
