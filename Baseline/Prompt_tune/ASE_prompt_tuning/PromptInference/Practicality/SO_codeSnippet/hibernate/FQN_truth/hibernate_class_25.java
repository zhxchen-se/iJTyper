public class hibernate_class_25 {
    @org.hibernate.annotations.Entity
    public class A {
        private java.lang.Integer id;

        private hibernate.hibernate_class_25.B b;

        public A() {
            super();
        }

        @javax.persistence.Id
        @javax.persistence.GeneratedValue
        public java.lang.Integer getId() {
            return id;
        }

        public void setId(java.lang.Integer id) {
            this.id = id;
        }

        @javax.persistence.OneToOne(cascade = javax.persistence.CascadeType.ALL)
        public hibernate.hibernate_class_25.B getB() {
            return b;
        }

        public void setB(hibernate.hibernate_class_25.B b) {
            this.b = b;
        }
    }

    @org.hibernate.annotations.Entity
    public class B {
        private java.lang.Integer id;

        public B() {
            super();
        }

        @javax.persistence.Id
        @javax.persistence.GeneratedValue
        public java.lang.Integer getId() {
            return id;
        }

        public void setId(java.lang.Integer id) {
            this.id = id;
        }
    }
}

