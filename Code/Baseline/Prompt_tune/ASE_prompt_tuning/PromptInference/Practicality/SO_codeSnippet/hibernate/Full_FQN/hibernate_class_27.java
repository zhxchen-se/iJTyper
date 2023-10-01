public class hibernate_class_27 {
  public static java.util.List<hibernate_class_27.ProjectAssignment> getAllResources() {
    java.util.List<hibernate_class_27.ProjectAssignment> projectMasters;
    org.hibernate.Session session = HibernateUtil.getSessionFactory()###<unknown>.openSession();
    org.hibernate.Query query = org.hibernate.Session.createQuery(java.lang.String);
    projectMasters = org.hibernate.Query.list();
    org.hibernate.Session.close()
    return projectMasters;
  }

  public class ProjectAssignment implements java.io.Serializable {
    private short aid;

    private java.lang.String pid;

    private java.lang.String userName;

    public ProjectAssignment() {
    }

    public ProjectAssignment(short aid) {
      this.aid = aid;
    }

    public ProjectAssignment(short aid, java.lang.String pid, java.lang.String userName) {
      this.aid = aid;
      this.pid = pid;
      this.userName = userName;
    }

    public short getAid() {
      return this.aid;
    }

    public void setAid(short aid) {
      this.aid = aid;
    }

    public java.lang.String getPid() {
      return this.pid;
    }

    public void setPid(java.lang.String pid) {
      this.pid = pid;
    }

    public java.lang.String getUserName() {
      return this.userName;
    }

    public void setUserName(java.lang.String userName) {
      this.userName = userName;
    }
  }
}
