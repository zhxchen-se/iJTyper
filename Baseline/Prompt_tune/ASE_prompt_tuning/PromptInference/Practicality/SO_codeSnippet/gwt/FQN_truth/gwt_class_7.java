public class gwt_class_7 {
    public class GWTMemoryIssue implements EntryPoint {
        private static final boolean WITH_TABLE = false;

        private Panel panel;

        private Timer timer;

        private Table table;

        public void onModuleLoad() {
            RootPanel rootPanel = RootPanel.get();
            this.panel = new VerticalPanel();
            this.panel.setSize("100%", "100%");
            rootPanel.add(panel);
            if (gwt_class_7.GWTMemoryIssue.WITH_TABLE) {
                loadTable();
            } else {
                startUpdateTask();
            }
        }

        private void startUpdateTask() {
            this.timer = new Timer() {
                public void run() {
                }
            };
            this.timer.scheduleRepeating(2000);
        }

        public void loadTable() {
            java.lang.Runnable onLoadCallback = new java.lang.Runnable() {
                public void run() {
                    gwt_class_7.GWTMemoryIssue.this.table.setSize("100%", "100%");
                    gwt_class_7.GWTMemoryIssue.this.panel.add(gwt_class_7.GWTMemoryIssue.this.table);
                    gwt_class_7.GWTMemoryIssue.this.startUpdateTask();
                }
            };
        }
    }
}

