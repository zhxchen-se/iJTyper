[
  {
    "maskCode": "<mask><mask><mask>.DateTimeFormatter DATE_FORMAT =",
    "Glob_context": "public class jdk9 { public static void h1(){ <mask><mask><mask>.DateTimeFormatter DATE_FORMAT = new java.time.format.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": "new <mask><mask><mask>.DateTimeFormatterBuilder().appendPattern(String)",
    "Glob_context": "public class jdk9 { public static void h1(){ java.time.format.DateTimeFormatter DATE_FORMAT = new <mask><mask><mask>.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.HOUR_OF_DAY, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ java.time.format.DateTimeFormatter DATE_FORMAT = new java.time.format.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(<mask><mask><mask>.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.MINUTE_OF_HOUR, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ java.time.format.DateTimeFormatter DATE_FORMAT = new java.time.format.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(<mask><mask><mask>.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(java.time.temporal.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.SECOND_OF_MINUTE, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ java.time.format.DateTimeFormatter DATE_FORMAT = new java.time.format.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(java.time.temporal.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(java.time.temporal.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(<mask><mask><mask>.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  }
]