// getters and setters...
@Entity
@Table(name = "log_entries")
@org.hibernate.annotations.Table(appliesTo = "log_entries", indexes = { @org.hibernate.annotations.Index(name = "idx", columnNames = { "job", "version", "schedule", "dttmRun", "pid" }) })
public class hibernate_class_32 {
  @Id
  @GeneratedValue
  java.lang.Long id;

  java.lang.String job;

  java.lang.String version;

  java.lang.String schedule;

  java.lang.String dttmRun;

  int pid;

  java.lang.String command;

  int duration;
}
