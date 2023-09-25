[
  {
    "maskCode": "public class Android01 extends <mask><mask><mask>.Activity {",
    "Glob_context": "public class Android01 extends <mask><mask><mask>.Activity { /** Called when the activity is first created. */ @Override public void onCreate(android.os.Bundle savedInstanceState) { super.onCreate(savedInstanceState); mTextView = new android.widget.TextView(this); if (savedInstanceState == null) { mTextView.setText(String);"
  },
  {
    "maskCode": "public void onCreate(<mask><mask><mask>.Bundle savedInstanceState) {",
    "Glob_context": "public class Android01 extends android.app.Activity { /** Called when the activity is first created. */ @Override public void onCreate(<mask><mask><mask>.Bundle savedInstanceState) { super.onCreate(savedInstanceState); mTextView = new android.widget.TextView(this); if (savedInstanceState == null) { mTextView.setText(String);"
  },
  {
    "maskCode": "mTextView = new <mask><mask><mask>.TextView(this);",
    "Glob_context": "public class Android01 extends android.app.Activity { /** Called when the activity is first created. */ @Override public void onCreate(android.os.Bundle savedInstanceState) { super.onCreate(savedInstanceState); mTextView = new <mask><mask><mask>.TextView(this); if (savedInstanceState == null) { mTextView.setText(String); } else { mTextView.setText(String);"
  },
  {
    "maskCode": "private <mask><mask><mask>.TextView mTextView = null;",
    "Glob_context": "} else { mTextView.setText(String); } setContentView(mTextView); } private <mask><mask><mask>.TextView mTextView = null; };"
  }
]