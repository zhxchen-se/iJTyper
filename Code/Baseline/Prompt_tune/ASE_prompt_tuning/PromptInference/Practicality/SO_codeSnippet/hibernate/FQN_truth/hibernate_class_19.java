@javax.persistence.Entity
@org.hibernate.annotations.Table(appliesTo = hibernate.hibernate_class_19.TABLE_NAME, indexes = { @org.hibernate.annotations.Index(name = "IDX_XDN_DFN", columnNames = { hibernate.hibernate_class_19.XDN, hibernate.hibernate_class_19.DFN }) })
public class hibernate_class_19 {
    public static final java.lang.String TABLE_NAME = "house";

    public static final java.lang.String XDN = "xdn";

    public static final java.lang.String DFN = "dfn";

    @javax.persistence.GeneratedValue
    private long Id;

    @javax.persistence.Column(name = hibernate.hibernate_class_19.XDN)
    private long xdn;

    @javax.persistence.Column(name = hibernate.hibernate_class_19.DFN)
    private long dfn;

    @javax.persistence.Column
    private java.lang.String address;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public long getXdn() {
        return xdn;
    }

    public void setXdn(long xdn) {
        this.xdn = xdn;
    }

    public long getDfn() {
        return dfn;
    }

    public void setDfn(long dfn) {
        this.dfn = dfn;
    }

    public java.lang.String getAddress() {
        return address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }
}

