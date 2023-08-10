// ID = 1254832
public class Android46 extends android.app.Activity {
    private android.widget.EditText mTextSearch;

    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        mTextSearch = ((android.widget.EditText) (findViewById(R.id.background)));
        android.widget.Button searchButton = ((android.widget.Button) (findViewById(100)));
        searchButton.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(android.view.View v) {
                android.content.Intent data = new android.content.Intent();
                data.putExtra("TITLE", mTextSearch.getText().toString());
                setResult(android.RESULT_OK, data);
                finish();
            }
        });
    }

    @java.lang.Override
    protected void onSaveInstanceState(android.os.Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @java.lang.Override
    protected void onPause() {
        super.onPause();
    }

    @java.lang.Override
    protected void onResume() {
        super.onResume();
    }
}

