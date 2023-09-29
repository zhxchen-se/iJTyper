@javax.persistence.Entity
@javax.persistence.Table(name = "tblUser")
public class hibernate_class_13 implements java.io.Serializable , java.lang.Cloneable {
    @javax.persistence.Id
    @javax.persistence.Column(name = "CountyId", nullable = false)
    private java.lang.Integer countyId;

    @javax.persistence.Id
    @javax.persistence.Column(name = "Username", length = 25, nullable = false)
    private java.lang.String username;

    @javax.persistence.ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @javax.persistence.JoinColumn(name = "CountyId", nullable = false, insertable = false, updatable = false)
    @org.hibernate.annotations.ForeignKey(name = "FK_CountyID")
    @javax.persistence.Column(name = "Name", length = 50, nullable = true)
    private java.lang.String name;

    @javax.persistence.Column(name = "Password", length = 30, nullable = true)
    private java.lang.String password;

    @javax.persistence.Column(name = "Role", nullable = false)
    private java.lang.Integer role;

    @javax.persistence.ManyToMany(targetEntity = java.security.Permission.class, cascade = { javax.persistence.CascadeType.PERSIST, javax.persistence.CascadeType.MERGE })
    @javax.persistence.JoinTable(name = "tblUserPermission", joinColumns = { @javax.persistence.JoinColumn(name = "Username", referencedColumnName = "Username"), @javax.persistence.JoinColumn(name = "CountyId", referencedColumnName = "CountyId") }, inverseJoinColumns = { @javax.persistence.JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId") })
    private java.util.Collection<java.security.Permission> permissions;

    @javax.persistence.OneToMany(fetch = javax.persistence.FetchType.LAZY, mappedBy = "county")
    @org.hibernate.annotations.IndexColumn(name = "version")
    private java.awt.List versions;
}

