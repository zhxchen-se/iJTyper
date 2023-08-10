@javax.persistence.Entity
@javax.persistence.Table(name = "log_entries")
@javax.persistence.Table(appliesTo = "log_entries", indexes = { @org.hibernate.annotations.Index(name = "idx", columnNames = { "job", "version", "schedule", "dttmRun", "pid" }) })
public class hibernate_class_32 {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue
    java.lang.Long id;

    java.lang.String job;

    java.lang.String version;

    java.lang.String schedule;

    java.lang.String dttmRun;

    int pid;

    java.lang.String command;

    int duration;
}

