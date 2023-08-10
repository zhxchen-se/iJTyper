@javax.persistence.Entity
@javax.persistence.Table(name = "basic_user")
@org.hibernate.annotations.NamedQueries({ @org.hibernate.annotations.NamedQuery(name = "BasicUser.findAll", query = "SELECT b FROM BasicUser b"), @org.hibernate.annotations.NamedQuery(name = "BasicUser.findByFirstName", query = "SELECT b FROM BasicUser b WHERE b.firstName = :firstName"), @org.hibernate.annotations.NamedQuery(name = "BasicUser.findByLastName", query = "SELECT b FROM BasicUser b WHERE b.lastName = :lastName"), @org.hibernate.annotations.NamedQuery(name = "BasicUser.findByEmail", query = "SELECT b FROM BasicUser b WHERE b.email = :email"), @org.hibernate.annotations.NamedQuery(name = "BasicUser.findByPassword", query = "SELECT b FROM BasicUser b WHERE b.password = :password") })
public class hibernate_class_30 implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "First_Name")
    private java.lang.String firstName;

    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "Last_Name")
    private java.lang.String lastName;

    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "Email")
    private java.lang.String email;

    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "Password")
    private java.lang.String password;

    public hibernate_class_30() {
    }
}

