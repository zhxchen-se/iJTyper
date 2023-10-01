public class Android50 extends android.app.Activity {
    public static final java.lang.String tag = "TipCalculator";

    @java.lang.Override
    public void onCreate(android.os.Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_list_item);
        final android.widget.EditText mealpricefield = ((android.widget.EditText) (findViewById(100)));
        final android.widget.TextView answerfield = ((android.widget.TextView) (findViewById(R.id.background)));
        final android.widget.Button button = ((android.widget.Button) (findViewById(101)));
        button.setOnClickListener(new android.widget.Button.OnClickListener() {
            @java.lang.Override
            public void onClick(android.view.View view) {
            }

            public void onClick(javax.swing.text.View v) {
                try {
                    android.util.Log.i(android.Android50.tag, "onClick invoked.");
                    java.lang.String mealprice = mealpricefield.getText().toString();
                    android.util.Log.i(android.Android50.tag, ("mealprice is [" + mealprice) + "]");
                    java.lang.String answer = "";
                    if (mealprice.indexOf("$") == (-1)) {
                        mealprice = "$" + mealprice;
                    }
                    float fmp = 0.0F;
                    java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance();
                    fmp = nf.parse(mealprice).floatValue();
                    fmp *= 1.2;
                    android.util.Log.i(android.Android50.tag, ("Total Meal Price (unformatted) is [" + fmp) + "]");
                    answer = "Full Price, including 20% Tip: " + nf.format(fmp);
                    answerfield.setText(answer);
                    android.util.Log.i(android.Android50.tag, "onClick Complete");
                } catch (java.text.ParseException pe) {
                    android.util.Log.i(android.Android50.tag, "Parse exception caught");
                    answerfield.setText("Failed to parse amount?");
                } catch (java.lang.Exception e) {
                    android.util.Log.e(android.Android50.tag, "Failed to Calculate Tip:" + e.getMessage());
                    e.printStackTrace();
                    answerfield.setText(e.getMessage());
                }
            }
        });
    }
}

