@javax.persistence.MappedSuperclass
public abstract class hibernate_class_8 {
    private static final long serialVersionUID = 1L;

    private java.util.Date from;

    private java.util.Date thru;

    @javax.persistence.Transient
    public boolean isActive() {
        java.util.Date now = new java.util.Date();
        boolean afterFrom = from.before(now) || from.equals(now);
        boolean beforeThru = ((thru == null) || thru.after(now)) || thru.equals(now);
        return afterFrom && beforeThru;
    }

    @org.hibernate.validator.AssertTrue(message = "Dates are not valid the thru date must be empty, or after the fromdate.")
    public boolean areDatesValid() {
        if (thru == null) {
            return true;
        } else {
            return thru.after(from);
        }
    }

    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @com.sun.istack.internal.NotNull
    @javax.persistence.Column(name = "fromDate")
    public java.util.Date getFrom() {
        return from;
    }

    public void setFrom(java.util.Date from) {
        this.from = from;
    }

    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public java.util.Date getThru() {
        return thru;
    }

    public void setThru(java.util.Date thru) {
        this.thru = thru;
    }
}

