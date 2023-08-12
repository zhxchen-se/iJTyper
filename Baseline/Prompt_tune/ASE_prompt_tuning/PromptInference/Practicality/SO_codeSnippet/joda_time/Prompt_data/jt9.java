[
  {
    "maskCode": "<mask><mask><mask>.LocalDate today = LocalDate.now();",
    "Glob_context": "public class jt9 { public static void h1() { <mask><mask><mask>.LocalDate today = java.time.LocalDate.now(); java.time.ZonedDateTime zdt = today.atStartOfDay().atZone(java.time.ZoneId.systemDefault()); java.time.OffsetDateTime odt = zdt.toOffsetDateTime();"
  },
  {
    "maskCode": "LocalDate today = <mask><mask><mask>.LocalDate.now();",
    "Glob_context": "public class jt9 { public static void h1() { java.time.LocalDate today = <mask><mask><mask>.LocalDate.now(); java.time.ZonedDateTime zdt = today.atStartOfDay().atZone(java.time.ZoneId.systemDefault()); java.time.OffsetDateTime odt = zdt.toOffsetDateTime();"
  },
  {
    "maskCode": "<mask><mask><mask>.ZonedDateTime zdt = today.atStartOfDay().atZone(ZoneId.systemDefault());",
    "Glob_context": "public class jt9 { public static void h1() { java.time.LocalDate today = java.time.LocalDate.now(); <mask><mask><mask>.ZonedDateTime zdt = today.atStartOfDay().atZone(java.time.ZoneId.systemDefault()); java.time.OffsetDateTime odt = zdt.toOffsetDateTime(); } };"
  },
  {
    "maskCode": "ZonedDateTime zdt = today.atStartOfDay().atZone(<mask><mask><mask>.ZoneId.systemDefault());",
    "Glob_context": "public class jt9 { public static void h1() { java.time.LocalDate today = java.time.LocalDate.now(); java.time.ZonedDateTime zdt = today.atStartOfDay().atZone(<mask><mask><mask>.ZoneId.systemDefault()); java.time.OffsetDateTime odt = zdt.toOffsetDateTime(); } };"
  },
  {
    "maskCode": "<mask><mask><mask>.OffsetDateTime odt = zdt.toOffsetDateTime();",
    "Glob_context": "public class jt9 { public static void h1() { java.time.LocalDate today = java.time.LocalDate.now(); java.time.ZonedDateTime zdt = today.atStartOfDay().atZone(java.time.ZoneId.systemDefault()); <mask><mask><mask>.OffsetDateTime odt = zdt.toOffsetDateTime(); } };"
  }
]