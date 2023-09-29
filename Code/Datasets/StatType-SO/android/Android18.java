package androidExamples;
//ID = 724419
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import gen.R;
public class Android18 extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main);
     this.setTitle("MainActivity");
    }



	@Override
	public void onClick(DialogInterface arg0, int arg1) {
	     startActivity(new Intent(this, ChildActivity.class));
		
	}

}

class ChildActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.main2);
     this.setTitle("ChildActivity");

    }

}
