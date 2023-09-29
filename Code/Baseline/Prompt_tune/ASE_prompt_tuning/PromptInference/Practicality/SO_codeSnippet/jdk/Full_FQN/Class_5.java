public class Class_5 {
  public static <K, V extends java.lang.Comparable<? super V>> java.util.Map<K, V> sortByValue(java.util.Map<K, V> map) {
    java.util.List<java.util.Map.Entry<K, V>> list = new java.util.LinkedList<java.util.Map.Entry<K, V>>(java.util.Map.entrySet());
    java.util.Collections.sort(java.util.List,java.util.Comparator)
    java.util.Map<K, V> result = new java.util.LinkedHashMap<K, V>();
    for (java.util.Map.Entry<K, V> entry : list) {
      java.util.Map.put(java.lang.Object,java.lang.Object)
    }
    return result;
  }

  public class main {
    public void main_1() {
      java.util.HashMap<java.lang.String, java.lang.Double> map = new java.util.HashMap<java.lang.String, java.lang.Double>();
      Class_.Class_5.ValueComparator bvc = new Class_.Class_5.ValueComparator(map);
      java.util.TreeMap<java.lang.String, java.lang.Double> sorted_map = new java.util.TreeMap<java.lang.String, java.lang.Double>(bvc);
      java.util.HashMap.put(java.lang.Object,java.lang.Object)
      java.util.HashMap.put(java.lang.Object,java.lang.Object)
      java.util.HashMap.put(java.lang.Object,java.lang.Object)
      java.util.HashMap.put(java.lang.Object,java.lang.Object)
      java.io.PrintStream.println(java.lang.String)
      java.util.TreeMap.putAll(java.util.Map)
      java.io.PrintStream.println(java.lang.String)
    }
  }

  class ValueComparator implements java.util.Comparator<java.lang.String> {
    java.util.Map<java.lang.String, java.lang.Double> base;

    public ValueComparator(java.util.Map<java.lang.String, java.lang.Double> base) {
      this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    public int compare(java.lang.String a, java.lang.String b) {
      if (java.util.Map.get(java.lang.Object) >= java.util.Map.get(java.lang.Object)) {
        return -1;
      }// returning 0 would merge keys
       else {
        return 1;
      }// returning 0 would merge keys

    }
  }
}
