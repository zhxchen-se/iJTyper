public class hibernate_class_25 {
    @javax.persistence.Entity
    public class A {
        private java.lang.Integer id;

        private hibernate_class_25.B b;

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
        @org.hibernate.annotations.Fetch(org.hibernate.annotations.FetchMode.JOIN)
        public hibernate_class_25.B getB() {
            return b;
        }

        public void setB(hibernate_class_25.B b) {
            this.b = b;
        }
    }

    @javax.persistence.Entity
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

