
//ID = 1483026
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.test.cache.Item;

import library.model.User;
public class hibernate_class_14 {
	@Entity
	@Table(name = "tblPermission")
	public class Permission implements Serializable, Cloneable {

	    private static final long serialVersionUID = 7155322069731920447L;

	    @Id
	    @Column(name = "PermissionId", length = 8, nullable = false)
	    private String PermissionId = "";

	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name = "CountyId", nullable = false)
	    @ForeignKey(name="FK_CountyID")
//	    private County county;

	    @Column(name = "Permission", nullable = true)
	    private Integer permission = 1;

	    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	          mappedBy = "Permissions",
	          targetEntity = Item.class )
	    private Collection<Item> items;

	    @ManyToMany( cascade = {CascadeType.PERSIST, CascadeType.MERGE},
	          mappedBy = "Permissions",
	          targetEntity = User.class )
	    private Collection<User> users;

	    /** Getters and Setters **/
	}

}
