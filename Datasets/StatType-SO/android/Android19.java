package androidExamples;
//ID = 738817
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

public class Android19 {
	public View getView(int position, View convertView, ViewGroup parent) {
		  ImageView imageView;
		  if (convertView == null) {  
		    Context mContext = null;
			// if it's not recycled, initialize some attributes
		    imageView = new ImageView(mContext);
		    imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
		    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		    imageView.setPadding(8, 8, 8, 8);
		    //does this need imageView.onKeyDown(keyCode, event)?
		  } 
		  else {
		    imageView = (ImageView) convertView;
		  }

		  int[] mThumbIds = null;
		imageView.setImageResource(mThumbIds[position]);
		  return imageView;
		}


}
