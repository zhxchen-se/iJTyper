public class Android27 extends android.widget.BaseAdapter {
  private android.content.Context context;

  private java.lang.String[] texts = new java.lang.String[]{ "aaa", "bbb", "ccc", "ddd", "eee", "fff", "eee", "hhh", "iii" };

  public Android27(android.content.Context context) {
    this.context = context;
  }

  public int getCount() {
    return 9;
  }

  public java.lang.Object getItem(int position) {
    return null;
  }

  public long getItemId(int position) {
    return 0;
  }

  public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
    android.widget.TextView tv;
    if (convertView == null) {
      tv = new android.widget.TextView(context);
      android.widget.TextView.setLayoutParams(GridView.LayoutParams)
    } else {
      tv = ((android.widget.TextView) (convertView));
    }
    android.widget.TextView.setText(java.lang.String)
    return tv;
  }
}
