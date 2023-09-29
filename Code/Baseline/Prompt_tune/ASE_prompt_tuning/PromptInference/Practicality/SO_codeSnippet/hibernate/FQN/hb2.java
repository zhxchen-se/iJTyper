public class hb2 {
    @javax.persistence.Entity
    public static class University<Student> {
        private java.lang.String address;

        @javax.persistence.OneToMany(fetch = javax.persistence.FetchType.LAZY)
        private java.util.List<Student> students;
    }
}

