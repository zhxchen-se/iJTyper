public class hibernate_class_11 {
    @javax.persistence.Entity
    @javax.persistence.Table(name = "User")
    public class User implements java.io.Serializable {
        private static final long serialVersionUID = 2209767646758652729L;

        @javax.persistence.Id
        @javax.persistence.Column(name = "id", nullable = false)
        private java.lang.Integer id;

        @javax.persistence.Column(name = "name", length = 200, nullable = true)
        private java.lang.String name;

        @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.EAGER)
        @javax.persistence.JoinColumn(name = "groupId", nullable = false, insertable = false, updatable = false)
        @org.hibernate.annotations.ForeignKey(name = "FK_GroupId")
        private org.apache.directory.api.ldap.aci.UserClass.UserGroup userGroup;
    }
}

