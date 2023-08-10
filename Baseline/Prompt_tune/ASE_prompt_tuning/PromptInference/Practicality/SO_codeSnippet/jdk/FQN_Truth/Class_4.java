class Class_4 {
    private static java.util.regex.Pattern twopart = java.util.regex.Pattern.compile("(\\d+)-(\\d+)");

    public static void checkString(java.lang.String s) {
        java.util.regex.Matcher m = Class_.Class_4.twopart.matcher(s);
        if (m.matches()) {
            java.lang.System.out.println(((((s + " matches; first part is ") + m.group(0)) + ", second part is ") + m.group(1)) + ".");
        } else {
            java.lang.System.out.println(s + " does not match.");
        }
    }

    public static void main(java.lang.String[] args) {
        Class_.Class_4.checkString("123-4567");
        Class_.Class_4.checkString("foo-bar");
        Class_.Class_4.checkString("123-");
        Class_.Class_4.checkString("-4567");
        Class_.Class_4.checkString("123-4567-890");
    }

    public static java.lang.String[] mySplit(java.lang.String text, java.lang.String delimiter) {
        java.util.List<java.lang.String> parts = new java.util.ArrayList<java.lang.String>();
        text += delimiter;
        for (int i = text.indexOf(delimiter), j = 0; i != (-1);) {
            java.lang.String temp = text.substring(j, i);
            if (temp.trim().length() != 0) {
                parts.add(temp);
            }
            j = i + delimiter.length();
            i = text.indexOf(delimiter, j);
        }
        return parts.toArray(new java.lang.String[0]);
    }

    public static void main_2() {
        java.lang.String str = "004-034556";
        java.lang.String delimiter = "-";
        java.lang.String[] result = Class_.Class_4.mySplit(str, delimiter);
        for (java.lang.String s : result) {
            java.lang.System.out.println(s);
        }
    }
}

