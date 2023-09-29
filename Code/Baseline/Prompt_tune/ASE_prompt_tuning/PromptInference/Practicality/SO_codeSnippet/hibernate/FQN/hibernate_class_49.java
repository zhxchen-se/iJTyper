@javax.persistence.Entity
public class hibernate_class_49 implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private java.lang.String username;

    private java.lang.String password;

    private java.lang.Integer VERSION;

    @javax.persistence.Version
    public java.lang.Integer getVERSION() {
        return VERSION;
    }

    public void setVERSION(java.lang.Integer vERSION) {
        VERSION = vERSION;
    }

    @org.hibernate.annotations.NaturalId
    public java.lang.String getUsername() {
        return username;
    }

    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    public java.lang.String getPassword() {
        return password;
    }

    public void setPassword(java.lang.String password) {
        this.password = password;
    }
}

