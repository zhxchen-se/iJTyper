[
  {
    "maskCode": "<mask><mask><mask>.DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT);",
    "Glob_context": "//ID = 7807271 public class JodaTime20 { public static void main(String[] args) { String DATE_FORMAT = String; <mask><mask><mask>.DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT); DateTimeZone dateTimeZone = DateTimeZone.forID(String); //date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String);"
  },
  {
    "maskCode": "DateTimeFormatter DATETIME_FORMATTER = <mask><mask><mask>.DateTimeFormat.forPattern(DATE_FORMAT);",
    "Glob_context": "//ID = 7807271 public class JodaTime20 { public static void main(String[] args) { String DATE_FORMAT = String; DateTimeFormatter DATETIME_FORMATTER = <mask><mask><mask>.DateTimeFormat.forPattern(DATE_FORMAT); DateTimeZone dateTimeZone = DateTimeZone.forID(String); //date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String);"
  },
  {
    "maskCode": "<mask><mask><mask>.DateTimeZone dateTimeZone = DateTimeZone.forID(String);",
    "Glob_context": "//ID = 7807271 public class JodaTime20 { public static void main(String[] args) { String DATE_FORMAT = String; DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT); <mask><mask><mask>.DateTimeZone dateTimeZone = DateTimeZone.forID(String); //date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String); System.out.println(String + date.toString());"
  },
  {
    "maskCode": "DateTimeZone dateTimeZone = <mask><mask><mask>.DateTimeZone.forID(String);",
    "Glob_context": "//ID = 7807271 public class JodaTime20 { public static void main(String[] args) { String DATE_FORMAT = String; DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT); DateTimeZone dateTimeZone = <mask><mask><mask>.DateTimeZone.forID(String); //date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String); System.out.println(String + date.toString());"
  },
  {
    "maskCode": "<mask><mask><mask>.DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String);",
    "Glob_context": "DateTimeFormatter DATETIME_FORMATTER = DateTimeFormat.forPattern(DATE_FORMAT); DateTimeZone dateTimeZone = DateTimeZone.forID(String); //date is 2000-01-01 00:00:00 -03:00 <mask><mask><mask>.DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String); System.out.println(String + date.toString()); //now convert to UTC DateTime convertedDate = date.toDateTime(DateTimeZone.UTC);"
  },
  {
    "maskCode": "<mask><mask><mask>.DateTime convertedDate = date.toDateTime(DateTimeZone.UTC);",
    "Glob_context": "//date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String); System.out.println(String + date.toString()); //now convert to UTC <mask><mask><mask>.DateTime convertedDate = date.toDateTime(DateTimeZone.UTC); System.out.println(String + date.toString()); // TODO Auto-generated method stub } };"
  },
  {
    "maskCode": "DateTime convertedDate = date.toDateTime(<mask><mask><mask>.DateTimeZone.UTC);",
    "Glob_context": "//date is 2000-01-01 00:00:00 -03:00 DateTime date = DATETIME_FORMATTER.withZone(dateTimeZone).parseDateTime(String); System.out.println(String + date.toString()); //now convert to UTC DateTime convertedDate = date.toDateTime(<mask><mask><mask>.DateTimeZone.UTC); System.out.println(String + date.toString()); // TODO Auto-generated method stub } };"
  }
]