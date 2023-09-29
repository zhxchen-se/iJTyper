public class hibernate_class_11 {
    /* Getters, Setters, toString, equals & hashCode */
    @Entity
    @Table(name = "User")
    public class User implements java.io.Serializable {
        private static final long serialVersionUID = 2209767646758652729L;

        @Id
        @Column(name = "id", nullable = false)
        private java.lang.Integer id;

        @Column(name = "name", length = 200, nullable = true)
        private java.lang.String name;
    }
}

