[
  {
    "maskCode": "<mask><mask><mask>.DateTimeFormatter DATE_FORMAT =",
    "Glob_context": "public class jdk9 { public static void h1(){ <mask><mask><mask>.DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": "new <mask><mask><mask>.DateTimeFormatterBuilder().appendPattern(String)",
    "Glob_context": "public class jdk9 { public static void h1(){ DateTimeFormatter DATE_FORMAT = new <mask><mask><mask>.DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.HOUR_OF_DAY, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(<mask><mask><mask>.ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.MINUTE_OF_HOUR, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(<mask><mask><mask>.ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  },
  {
    "maskCode": ".parseDefaulting(<mask><mask><mask>.ChronoField.SECOND_OF_MINUTE, 0)",
    "Glob_context": "public class jdk9 { public static void h1(){ DateTimeFormatter DATE_FORMAT = new DateTimeFormatterBuilder().appendPattern(String) .parseDefaulting(ChronoField.HOUR_OF_DAY, 0) .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0) .parseDefaulting(<mask><mask><mask>.ChronoField.SECOND_OF_MINUTE, 0) .toFormatter(); } };"
  }
]