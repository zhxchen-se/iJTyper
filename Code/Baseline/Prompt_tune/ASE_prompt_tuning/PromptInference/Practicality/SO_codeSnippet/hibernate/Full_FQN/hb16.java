public class hb16<Car_OneToMany> {
  @javax.persistence.OneToMany(cascade = { javax.persistence.CascadeType.ALL })
  @javax.persistence.Column(name = "ListOfCarsDrivenByDriver")
  private java.util.List<Car_OneToMany> listOfCarsBeingDriven = new java.util.ArrayList<Car_OneToMany>();
}
