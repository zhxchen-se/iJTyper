package androidExamples;
//ID = 1182620
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

public class Android41 extends View {
	public Android41(Context context) {
		super(context);
		setBackgroundColor(Color.RED);
	}

	TextView tv;

	public void adText(TextView tv) {
		this.tv = tv;
		tv.setVisibility(tv.VISIBLE);
	}
}
