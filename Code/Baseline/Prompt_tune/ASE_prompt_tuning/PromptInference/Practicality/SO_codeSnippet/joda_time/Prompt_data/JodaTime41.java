[
  {
    "maskCode": "<mask><mask><mask>.DateTime dt4 = new DateTime(String);",
    "Glob_context": "//id=41452661 public class JodaTime41 { public static void main(String[] args) { <mask><mask><mask>.DateTime dt4 = new org.joda.time.DateTime(String); System.out.println(String+ dt4); org.joda.time.format.DateTimeFormatter fmt = org.joda.time.format.DateTimeFormat.forPattern(String);"
  },
  {
    "maskCode": "DateTime dt4 = new <mask><mask><mask>.DateTime(String);",
    "Glob_context": "//id=41452661 public class JodaTime41 { public static void main(String[] args) { org.joda.time.DateTime dt4 = new <mask><mask><mask>.DateTime(String); System.out.println(String+ dt4); org.joda.time.format.DateTimeFormatter fmt = org.joda.time.format.DateTimeFormat.forPattern(String);"
  },
  {
    "maskCode": "<mask><mask><mask>.DateTimeFormatter fmt = DateTimeFormat.forPattern(String);",
    "Glob_context": "//id=41452661 public class JodaTime41 { public static void main(String[] args) { org.joda.time.DateTime dt4 = new org.joda.time.DateTime(String); System.out.println(String+ dt4); <mask><mask><mask>.DateTimeFormatter fmt = org.joda.time.format.DateTimeFormat.forPattern(String); System.out.println(String+fmt.print(dt4)); org.joda.time.DateTime previousDay = dt4.minusDays(1);"
  },
  {
    "maskCode": "DateTimeFormatter fmt = <mask><mask><mask>.DateTimeFormat.forPattern(String);",
    "Glob_context": "//id=41452661 public class JodaTime41 { public static void main(String[] args) { org.joda.time.DateTime dt4 = new org.joda.time.DateTime(String); System.out.println(String+ dt4); org.joda.time.format.DateTimeFormatter fmt = <mask><mask><mask>.DateTimeFormat.forPattern(String); System.out.println(String+fmt.print(dt4)); org.joda.time.DateTime previousDay = dt4.minusDays(1);"
  },
  {
    "maskCode": "<mask><mask><mask>.DateTime previousDay = dt4.minusDays(1);",
    "Glob_context": "org.joda.time.format.DateTimeFormatter fmt = org.joda.time.format.DateTimeFormat.forPattern(String); System.out.println(String+fmt.print(dt4)); <mask><mask><mask>.DateTime previousDay = dt4.minusDays(1); System.out.println(String+ previousDay); System.out.println(String+fmt.print(previousDay));"
  }
]