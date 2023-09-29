public class hibernate_class_14 {
    /**
     * Getters and Setters *
     */
    @Entity
    @Table(name = "tblPermission")
    public class Permission implements java.io.Serializable , java.lang.Cloneable {
        private static final long serialVersionUID = 7155322069731920447L;

        @Id
        @Column(name = "PermissionId", length = 8, nullable = false)
        private java.lang.String PermissionId = "";

        // private County county;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "CountyId", nullable = false)
        @org.hibernate.annotations.ForeignKey(name = "FK_CountyID")
        @Column(name = "Permission", nullable = true)
        private java.lang.Integer permission = 1;

        @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "Permissions", targetEntity = org.hibernate.test.cache.Item.class)
        private java.util.Collection<org.hibernate.test.cache.Item> items;

        @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "Permissions", targetEntity = library.model.User.class)
        private java.util.Collection<library.model.User> users;
    }
}

