public class hb15<GlobalConfigScope> {
    private static java.lang.Object Type;

    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "globalConfig", orphanRemoval = true)
    private java.util.Set<GlobalConfigScope> gcScopeSet;
}

