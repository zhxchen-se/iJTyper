public class Class_5 {
    public static <K, V extends java.lang.Comparable<? super V>> java.util.Map<K, V> sortByValue(java.util.Map<K, V> map) {
        java.util.List<java.util.Map.Entry<K, V>> list = new java.util.LinkedList<java.util.Map.Entry<K, V>>(map.entrySet());
        java.util.Collections.sort(list, new java.util.Comparator<java.util.Map.Entry<K, V>>() {
            public int compare(java.util.Map.Entry<K, V> o1, java.util.Map.Entry<K, V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        java.util.Map<K, V> result = new java.util.LinkedHashMap<K, V>();
        for (java.util.Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public class main {
        public void main_1() {
            java.util.HashMap<java.lang.String, java.lang.Double> map = new java.util.HashMap<java.lang.String, java.lang.Double>();
            Class_.Class_5.ValueComparator bvc = new Class_.Class_5.ValueComparator(map);
            java.util.TreeMap<java.lang.String, java.lang.Double> sorted_map = new java.util.TreeMap<java.lang.String, java.lang.Double>(bvc);
            map.put("A", 99.5);
            map.put("B", 67.4);
            map.put("C", 67.4);
            map.put("D", 67.3);
            java.lang.System.out.println("unsorted map: " + map);
            sorted_map.putAll(map);
            java.lang.System.out.println("results: " + sorted_map);
        }
    }

    class ValueComparator implements java.util.Comparator<java.lang.String> {
        java.util.Map<java.lang.String, java.lang.Double> base;

        public ValueComparator(java.util.Map<java.lang.String, java.lang.Double> base) {
            this.base = base;
        }

        public int compare(java.lang.String a, java.lang.String b) {
            if (base.get(a) >= base.get(b)) {
                return -1;
            }
             else {
                return 1;
            }

        }
    }
}

