public class Android19 {
    public android.view.View getView(int position, android.view.View convertView, android.view.ViewGroup parent) {
        android.widget.ImageView imageView;
        if (convertView == null) {
            android.content.Context mContext = null;
            imageView = new android.widget.ImageView(mContext);
            imageView.setLayoutParams(new android.widget.GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = ((android.widget.ImageView) (convertView));
        }
        int[] mThumbIds = null;
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}

