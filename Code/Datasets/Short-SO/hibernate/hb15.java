package java.hibernate;


import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.Set;

public class hb15<GlobalConfigScope> {
    private static Object Type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="globalConfig", orphanRemoval = true)
    private Set<GlobalConfigScope> gcScopeSet;
}
