public class Android46 extends android.app.Activity {
    private android.widget.EditText mTextSearch;

    @java.lang.Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.media_preview);
        mTextSearch = ((android.widget.EditText) (findViewById(R.id.lay)));
        android.widget.Button searchButton = ((android.widget.Button) (findViewById(100)));
        searchButton.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(android.view.View v) {
                android.content.Intent data = new android.content.Intent();
                data.putExtra("TITLE", mTextSearch.getText().toString());
                setResult(androidExamples.RESULT_OK, data);
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

