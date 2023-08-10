[
  {
    "maskCode": "implements <mask><mask><mask>.Serializable",
    "Glob_context": "//ID = 1262298 public class hibernate_class_9 implements <mask><mask><mask>.Serializable { private int patientId; private String patientName; private String providerId; // foreign key to provider private static final long serialVersionUID = 81073;"
  },
  {
    "maskCode": "public static void load(<mask><mask><mask>.Session session, List<String> values){",
    "Glob_context": "private String patientName; private String providerId; // foreign key to provider private static final long serialVersionUID = 81073; public static void load(<mask><mask><mask>.Session session, java.util.List<String> values){ hibernate_class_9 PatientInfo = new hibernate_class_9(); PatientInfo.setPatientId(Integer.parseInt(values.get(0))); PatientInfo.setPatientName( values.get(1)); PatientInfo.setProviderId( values.get(2) );"
  },
  {
    "maskCode": "public static void load(Session session, <mask><mask><mask>.List<String> values){",
    "Glob_context": "private String patientName; private String providerId; // foreign key to provider private static final long serialVersionUID = 81073; public static void load(org.hibernate.Session session, <mask><mask><mask>.List<String> values){ hibernate_class_9 PatientInfo = new hibernate_class_9(); PatientInfo.setPatientId(Integer.parseInt(values.get(0))); PatientInfo.setPatientName( values.get(1)); PatientInfo.setProviderId( values.get(2) );"
  }
]