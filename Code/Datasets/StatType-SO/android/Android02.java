package androidExamples;

import android.app.Activity;
import android.os.Bundle;

import gen.R;

public class Android02 extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
