/**
 * Several models are date range sensitive, this base class provides that basic
 * functionality.
 *
 * @author jim
 */
@javax.persistence.MappedSuperclass
public abstract class hibernate_class_8 {
  private static final long serialVersionUID = 1L;

  private java.util.Date from;

  private java.util.Date thru;

  /**
   * Determines if a model is active. A model is active if now is after or
   * equal to from , and thru is either null, or after now, or equal to now.
   */
  @javax.persistence.Transient
  public boolean isActive() {
    java.util.Date now = new java.util.Date();
    boolean afterFrom = java.util.Date.before(java.util.Date) || java.util.Date.equals(java.lang.Object);
    boolean beforeThru = ((thru == null) || java.util.Date.after(java.util.Date)) || java.util.Date.equals(java.lang.Object);
    return afterFrom && beforeThru;
  }

  @org.hibernate.validator.AssertTrue(message = "Dates are not valid the thru date must be empty, or after the fromdate.")
  public boolean areDatesValid() {
    if (thru == null) {
      return true;
    } else {
      return java.util.Date.after(java.util.Date);
    }
  }

  @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
  @org.hibernate.validator.NotNull
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
