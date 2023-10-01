package java.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class hb16<Car_OneToMany> {
    @OneToMany(cascade = {CascadeType.ALL})
    @Column(name = "ListOfCarsDrivenByDriver")
    private List<Car_OneToMany> listOfCarsBeingDriven = new ArrayList<Car_OneToMany>();
}
