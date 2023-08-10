public class Class_15 {
    public class Employee {
        java.lang.String name;

        java.lang.String mobile;

        public Employee(java.lang.String name, java.lang.String mobile) {
            this.name = name;
            this.mobile = mobile;
        }

        @java.lang.Override
        public int hashCode() {
            java.lang.System.out.println("calling hascode method of Employee");
            java.lang.String str = this.name;
            java.lang.Integer sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum = sum + str.charAt(i);
            }
            return sum;
        }

        @java.lang.Override
        public boolean equals(java.lang.Object obj) {
            // TODO Auto-generated method stub
            java.lang.System.out.println("calling equals method of Employee");
            Class_.Class_15.Employee emp = ((Class_.Class_15.Employee) (obj));
            if (this.mobile.equalsIgnoreCase(emp.mobile)) {
                java.lang.System.out.println("returning true");
                return true;
            } else {
                java.lang.System.out.println("returning false");
                return false;
            }
        }

        public void main(java.lang.String[] args) {
            // TODO Auto-generated method stub
            Class_.Class_15.Employee emp = new Class_.Class_15.Employee("abc", "hhh");
            Class_.Class_15.Employee emp2 = new Class_.Class_15.Employee("abc", "hhh");
            java.util.HashMap<Class_.Class_15.Employee, Class_.Class_15.Employee> h = new java.util.HashMap<>();
            // for (int i=0;i<5;i++){
            h.put(emp, emp);
            h.put(emp2, emp2);
            // }
            java.lang.System.out.println("----------------");
            java.lang.System.out.println("size of hashmap: " + h.size());
        }
    }
}

