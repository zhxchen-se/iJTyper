// private void updateTableData(ArrayList<ListItem> result) {
// DataTable data = createTableData();
// 
// data.addRows(result.size());
// 
// int row = 0;
// for (ListItem li : result) {
// data.setValue(row, 0, li.getName());
// data.setValue(row, 1, li.getIntVal());
// data.setValue(row, 2, li.getIntSecondVal());
// data.setValue(row, 3, li.getThirdIntVal());
// row++;
// }
// 
// this.table.draw(data, createTableOptions());
// }
public class gwt_class_7 {
    // private Options createTableOptions() {
    // Options options = Options.create();
    // 
    // return options;
    // }
    // private DataTable createTableData() {
    // DataTable data = DataTable.create();
    // 
    // data.addColumn(ColumnType.STRING, "Name");
    // data.addColumn(ColumnType.NUMBER, "Intval 1");
    // data.addColumn(ColumnType.NUMBER, "Intval 2");
    // data.addColumn(ColumnType.NUMBER, "Intval 3");
    // 
    // return data;
    // }
    // private void getTableData() {
    // rpcService.getListOfItems(new AsyncCallback<ArrayList<ListItem>>(){
    // public void onFailure(Throwable caught) {
    // Do nothing
    // }
    // 
    // public void onSuccess(ArrayList<ListItem> result) {
    // if (WITH_TABLE){
    // GWTMemoryIssue.this.updateTableData(result);
    // }else{
    // Ignore the data from the server
    // }
    // }
    // });
    public class GWTMemoryIssue implements com.google.gwt.core.client.EntryPoint {
        // Run with or without table
        private static final boolean WITH_TABLE = false;

        // private final TestServiceAsync rpcService = GWT.create(TestService.class);
        private com.google.gwt.user.client.ui.Panel panel;

        private com.google.gwt.user.client.Timer timer;

        private com.extjs.gxt.ui.client.widget.table.Table table;

        public void onModuleLoad() {
            com.google.gwt.user.client.ui.RootPanel rootPanel = com.google.gwt.user.client.ui.RootPanel.get();
            this.panel = new com.google.gwt.user.client.ui.VerticalPanel();
            this.panel.setSize("100%", "100%");
            rootPanel.add(panel);
            if (gwt_class_7.GWTMemoryIssue.WITH_TABLE) {
                loadTable();
            } else {
                startUpdateTask();
            }
        }

        private void startUpdateTask() {
            this.timer = new com.google.gwt.user.client.Timer() {
                public void run() {
                    // GWTMemoryIssue.this.getTableData();
                }
            };
            this.timer.scheduleRepeating(2000);
        }

        public void loadTable() {
            java.lang.Runnable onLoadCallback = new java.lang.Runnable() {
                public void run() {
                    // GWTMemoryIssue.this.table = new Table(createTableData(), createTableOptions());
                    gwt_class_7.GWTMemoryIssue.this.table.setSize("100%", "100%");
                    gwt_class_7.GWTMemoryIssue.this.panel.add(gwt_class_7.GWTMemoryIssue.this.table);
                    gwt_class_7.GWTMemoryIssue.this.startUpdateTask();
                }
            };
            // VisualizationUtils.loadVisualizationApi(onLoadCallback, Table.PACKAGE);
        }
    }
}

