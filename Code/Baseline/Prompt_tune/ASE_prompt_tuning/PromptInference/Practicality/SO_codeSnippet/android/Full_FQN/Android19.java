public class Android19 {
  public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
    android.widget.ImageView imageView;
    if (convertView == null) {
      android.content.Context mContext = null;
      // if it's not recycled, initialize some attributes
      imageView = new android.widget.ImageView(mContext);
      android.widget.ImageView.setLayoutParams(GridView.LayoutParams)
      android.widget.ImageView.setScaleType()
      android.widget.ImageView.setPadding(int,int,int,int)
      // does this need imageView.onKeyDown(keyCode, event)?
    } else {
      imageView = ((android.widget.ImageView) (convertView));
    }
    int[] mThumbIds = null;
    android.widget.ImageView.setImageResource(int)
    return imageView;
  }
}
