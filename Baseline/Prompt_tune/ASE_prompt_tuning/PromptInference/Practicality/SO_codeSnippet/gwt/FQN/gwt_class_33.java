/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwt_class_33 implements com.google.gwt.core.client.EntryPoint {
    private com.google.gwt.user.client.ui.DockPanel panel;

    private java.util.List clearables;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        clearables = new java.util.ArrayList();
        initDockPanel();
        panel.add(buildActionPanel(), DockPanel.SOUTH);
        panel.add(buildPizzaTypePanel(), DockPanel.WEST);
        panel.add(buildToppingPanel(), DockPanel.EAST);
        com.google.gwt.user.client.ui.RootPanel.get("slicr").add(panel);
    }

    private void initDockPanel() {
        panel = new com.google.gwt.user.client.ui.DockPanel();
        panel.setBorderWidth(1);
        panel.setSpacing(5);
    }

    public com.google.gwt.user.client.ui.HorizontalPanel buildActionPanel() {
        com.google.gwt.user.client.ui.HorizontalPanel actions = new com.google.gwt.user.client.ui.HorizontalPanel();
        actions.setSpacing(10);
        com.google.gwt.user.client.ui.Button clear = new com.google.gwt.user.client.ui.Button("Clear");
        clear.addClickListener(new gwt_class_33.ClearClickListener());
        com.google.gwt.user.client.ui.Button newPizza = new com.google.gwt.user.client.ui.Button("Another Pizza");
        com.google.gwt.user.client.ui.Button submitOrder = new com.google.gwt.user.client.ui.Button("Submit");
        actions.add(clear);
        actions.add(newPizza);
        actions.add(submitOrder);
        return actions;
    }

    public static final java.lang.String[] PIZZA_TYPES = new java.lang.String[]{ "Thin Crust Medium", "Thin Crust Large", "Thin Crust X-Large", "Thick Crust Medium", "Thick Crust Large" };

    private com.google.gwt.user.client.ui.VerticalPanel buildPizzaTypePanel() {
        com.google.gwt.user.client.ui.VerticalPanel pizzaTypes = new com.google.gwt.user.client.ui.VerticalPanel();
        com.google.gwt.user.client.ui.HTML label = new com.google.gwt.user.client.ui.HTML("<h2>Pizza</h2>");
        pizzaTypes.add(label);
        for (int i = 0; i < gwt_class_33.PIZZA_TYPES.length; i++) {
            com.google.gwt.user.client.ui.RadioButton radio = new com.google.gwt.user.client.ui.RadioButton("pizzaGroup", gwt_class_33.PIZZA_TYPES[i]);
            clearables.add(radio);
            pizzaTypes.add(radio);
        }
        return pizzaTypes;
    }

    public static final java.lang.String[] TOPPINGS = new java.lang.String[]{ "Anchovy", "Gardineria", "Garlic", "Green Pepper", "Mushrooms", "Olives", "Onions", "Pepperoni", "Pineapple", "Sausage", "Spinach" };

    private com.google.gwt.user.client.ui.VerticalPanel buildToppingPanel() {
        com.google.gwt.user.client.ui.VerticalPanel toppings = new com.google.gwt.user.client.ui.VerticalPanel();
        toppings.add(new com.google.gwt.user.client.ui.HTML("<h2>Toppings</h2>"));
        com.google.gwt.user.client.ui.Grid topGrid = new com.google.gwt.user.client.ui.Grid(gwt_class_33.TOPPINGS.length + 1, 3);
        topGrid.setText(0, 0, "Topping");
        topGrid.setText(0, 1, "Left");
        topGrid.setText(0, 2, "Right");
        for (int i = 0; i < gwt_class_33.TOPPINGS.length; i++) {
            com.google.gwt.user.client.ui.Button button = new com.google.gwt.user.client.ui.Button(gwt_class_33.TOPPINGS[i]);
            com.google.gwt.user.client.ui.CheckBox leftCheckBox = new com.google.gwt.user.client.ui.CheckBox();
            com.google.gwt.user.client.ui.CheckBox rightCheckBox = new com.google.gwt.user.client.ui.CheckBox();
            clearables.add(leftCheckBox);
            clearables.add(rightCheckBox);
            button.addClickListener(new gwt_class_33.ToppingButtonListener(leftCheckBox, rightCheckBox));
            topGrid.setWidget(i + 1, 0, button);
            topGrid.setWidget(i + 1, 1, leftCheckBox);
            topGrid.setWidget(i + 1, 2, rightCheckBox);
        }
        toppings.add(topGrid);
        return toppings;
    }

    private class ClearClickListener implements com.google.gwt.user.client.ui.ClickListener {
        public void onClick(com.google.gwt.user.client.ui.Widget sender) {
            for (java.util.Iterator iter = clearables.iterator(); iter.hasNext();) {
                com.google.gwt.user.client.ui.CheckBox cb = ((com.google.gwt.user.client.ui.CheckBox) (iter.next()));
                cb.setChecked(false);
            }
        }
    }

    private class ToppingButtonListener implements com.google.gwt.user.client.ui.ClickListener {
        private com.google.gwt.user.client.ui.CheckBox cb1;

        private com.google.gwt.user.client.ui.CheckBox cb2;

        public ToppingButtonListener(com.google.gwt.user.client.ui.CheckBox cb1, com.google.gwt.user.client.ui.CheckBox cb2) {
            this.cb1 = cb1;
            this.cb2 = cb2;
        }

        public void onClick(com.google.gwt.user.client.ui.Widget sender) {
            boolean unchecked = (!cb1.isChecked()) && (!cb2.isChecked());
            cb1.setChecked(unchecked);
            cb2.setChecked(unchecked);
        }
    }
}

