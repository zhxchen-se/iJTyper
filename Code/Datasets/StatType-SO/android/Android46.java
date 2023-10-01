package androidExamples;
//ID = 1254832
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import gen.R;
public class Android46 extends Activity {
	private EditText mTextSearch; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	 // TODO Auto-generated method stub
	 super.onCreate(savedInstanceState);  
	 setContentView(R.layout.media_preview); 

	 mTextSearch = (EditText)findViewById(R.id.lay);  
	 Button searchButton = (Button)findViewById(100);  

	 searchButton.setOnClickListener(new View.OnClickListener(){
	  public void onClick(View v){    
	   Intent data = new Intent();    
	   data.putExtra("TITLE", mTextSearch.getText().toString());   
	   setResult(RESULT_OK, data);
	   finish();
	  }
	 });
	} 

	@Override
	protected void onSaveInstanceState(Bundle outState){
	 super.onSaveInstanceState(outState);  
	}
	@Override
	protected void onPause(){
	 super.onPause();

	}
	@Override
	protected void onResume(){
	 super.onResume();  
	}

}
