/**
 * Getters and setters *
 */
@Entity
@Table(name = "tblUser")
public class hibernate_class_13 implements java.io.Serializable , java.lang.Cloneable {
    @Id
    @Column(name = "CountyId", nullable = false)
    private java.lang.Integer countyId;

    @Id
    @Column(name = "Username", length = 25, nullable = false)
    private java.lang.String username;

    // private County county;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CountyId", nullable = false, insertable = false, updatable = false)
    @org.hibernate.annotations.ForeignKey(name = "FK_CountyID")
    @Column(name = "Name", length = 50, nullable = true)
    private java.lang.String name;

    @Column(name = "Password", length = 30, nullable = true)
    private java.lang.String password;

    @Column(name = "Role", nullable = false)
    private java.lang.Integer role;

    @ManyToMany(targetEntity = java.security.Permission.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "tblUserPermission", joinColumns = { @JoinColumn(name = "Username", referencedColumnName = "Username"), @JoinColumn(name = "CountyId", referencedColumnName = "CountyId") }, inverseJoinColumns = { @JoinColumn(name = "PermissionId", referencedColumnName = "PermissionId") })
    private java.util.Collection<java.security.Permission> permissions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "county")
    @org.hibernate.annotations.IndexColumn(name = "version")
    private java.util.List<Version> versions;
}

