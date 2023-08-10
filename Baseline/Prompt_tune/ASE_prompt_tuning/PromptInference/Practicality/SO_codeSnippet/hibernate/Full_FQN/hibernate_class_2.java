public class hibernate_class_2 {
  /**
   * Entity implementation class for Entity: Part
   */
  @org.hibernate.annotations.Entity
  @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
  public class Part implements java.io.Serializable {
    private int id;

    private java.lang.String name;

    private static final long serialVersionUID = 1L;

    private hibernate_class_2.Part mainPart;

    private java.util.List<hibernate_class_2.Part> parts;

    public Part() {
      java.lang.Object.java.lang.Object()
    }

    @Id
    public int getId() {
      return this.id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @Column(name = "PART_NAME")
    public java.lang.String getName() {
      return this.name;
    }

    public void setName(java.lang.String name) {
      this.name = name;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public hibernate_class_2.Part getMainPart() {
      return mainPart;
    }

    public void setMainPart(hibernate_class_2.Part mainPart) {
      this.mainPart = mainPart;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "mainPart_id", referencedColumnName = "id")
    @org.hibernate.annotations.Cache(usage = org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
    public java.util.List<hibernate_class_2.Part> getParts() {
      return parts;
    }

    public void setParts(java.util.List<hibernate_class_2.Part> parts) {
      this.parts = parts;
    }
  }
}
