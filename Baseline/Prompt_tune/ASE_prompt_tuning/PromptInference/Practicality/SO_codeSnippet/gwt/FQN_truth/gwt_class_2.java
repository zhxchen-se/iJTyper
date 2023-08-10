public class gwt_class_2 extends GWTTestCase {
    public java.lang.String getModuleName() {
        return "com.google.gwt.sample.stockwatcher.StockWatcher";
    }

    public void testSimple() {
        GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
        greetingService.greetServer("Bob", new AsyncCallback<java.lang.String>() {
            public void onFailure(java.lang.Throwable caught) {
                java.lang.System.out.println(caught);
                fail("big time failure");
                finishTest();
            }

            public void onSuccess(java.lang.String result) {
                java.lang.System.out.println("success, biatch");
                assertTrue(true);
            }
        });
        delayTestFinish(1000);
    }
}

