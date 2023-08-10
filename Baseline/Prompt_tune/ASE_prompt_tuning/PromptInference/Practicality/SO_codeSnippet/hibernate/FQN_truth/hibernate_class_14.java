public class hibernate_class_14 {
    @javax.persistence.Entity
    @javax.persistence.Table(name = "tblPermission")
    public class Permission implements java.io.Serializable , java.lang.Cloneable {
        private static final long serialVersionUID = 7155322069731920447L;

        @javax.persistence.Id
        @javax.persistence.Column(name = "PermissionId", length = 8, nullable = false)
        private java.lang.String PermissionId = "";

        @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
        @javax.persistence.JoinColumn(name = "CountyId", nullable = false)
        @org.hibernate.annotations.ForeignKey(name = "FK_CountyID")
        @javax.persistence.Column(name = "Permission", nullable = true)
        private java.lang.Integer permission = 1;

        @javax.persistence.ManyToMany(cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE }, mappedBy = "Permissions", targetEntity = android.content.ClipData.Item.class)
        private java.util.Collection<android.content.ClipData.Item> items;

        @javax.persistence.ManyToMany(cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE }, mappedBy = "Permissions", targetEntity = library.model.User.class)
        private java.util.Collection<library.model.User> users;
    }
}

