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
            return (((name + " ") + id) + " ") + hireDate.toString();
        }

        public static class CompId implements java.util.Comparator<Class_.Class_7.Person> {
            @java.lang.Override
            public int compare(Class_.Class_7.Person arg0, Class_.Class_7.Person arg1) {
                return arg0.id - arg1.id;
            }
        }

        public static class CompDate implements java.util.Comparator<Class_.Class_7.Person> {
            private int mod = 1;

            public CompDate(boolean desc) {
                if (desc) {
                    mod = -1;
                }
            }

            @java.lang.Override
            public int compare(Class_.Class_7.Person arg0, Class_.Class_7.Person arg1) {
                return mod * arg0.hireDate.compareTo(arg1.hireDate);
            }
        }
    }

    public static void main(java.lang.String[] args) {

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("mm-dd-yyyy");
        java.util.ArrayList<Class_.Class_7.Person> people;
        people = new java.util.ArrayList<Class_.Class_7.Person>();
        try {
            people.add(new Class_.Class_7.Person("Joe", 92422, df.parse("12-12-2010")));
            people.add(new Class_.Class_7.Person("Joef", 24122, df.parse("1-12-2010")));
            people.add(new Class_.Class_7.Person("Joee", 24922, df.parse("12-2-2010")));
        } catch (java.text.ParseException e) {

            e.printStackTrace();
        }
        java.util.Collections.sort(people, new Class_.Class_7.Person.CompId());
        java.lang.System.out.println("BY ID");
        for (Class_.Class_7.Person p : people) {
            java.lang.System.out.println(p.toString());
        }
        java.util.Collections.sort(people, new Class_.Class_7.Person.CompDate(false));
        java.lang.System.out.println("BY Date asc");
        for (Class_.Class_7.Person p : people) {
            java.lang.System.out.println(p.toString());
        }
        java.util.Collections.sort(people, new Class_.Class_7.Person.CompDate(true));
        java.lang.System.out.println("BY Date desc");
        for (Class_.Class_7.Person p : people) {
            java.lang.System.out.println(p.toString());
        }
    }
}

