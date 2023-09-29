public class gwt_class_33 implements EntryPoint {
    private DockPanel panel;

    private List clearables;

    public void onModuleLoad() {
        clearables = new ArrayList();
        initDockPanel();
        panel.add(buildActionPanel(), DockPanel.SOUTH);
        panel.add(buildPizzaTypePanel(), DockPanel.WEST);
        panel.add(buildToppingPanel(), DockPanel.EAST);
        RootPanel.get("slicr").add(panel);
    }

    private void initDockPanel() {
        panel = new DockPanel();
        panel.setBorderWidth(1);
        panel.setSpacing(5);
    }

    public HorizontalPanel buildActionPanel() {
        HorizontalPanel actions = new HorizontalPanel();
        actions.setSpacing(10);
        Button clear = new Button("Clear");
        clear.addClickListener(new gwt_class_33.ClearClickListener());
        Button newPizza = new Button("Another Pizza");
        Button submitOrder = new Button("Submit");
        actions.add(clear);
        actions.add(newPizza);
        actions.add(submitOrder);
        return actions;
    }

    public static final java.lang.String[] PIZZA_TYPES = new java.lang.String[]{ "Thin Crust Medium", "Thin Crust Large", "Thin Crust X-Large", "Thick Crust Medium", "Thick Crust Large" };

    private VerticalPanel buildPizzaTypePanel() {
        VerticalPanel pizzaTypes = new VerticalPanel();
        HTML label = new HTML("<h2>Pizza</h2>");
        pizzaTypes.add(label);
        for (int i = 0; i < gwt_class_33.PIZZA_TYPES.length; i++) {
            RadioButton radio = new RadioButton("pizzaGroup", gwt_class_33.PIZZA_TYPES[i]);
            clearables.add(radio);
            pizzaTypes.add(radio);
        }
        return pizzaTypes;
    }

    public static final java.lang.String[] TOPPINGS = new java.lang.String[]{ "Anchovy", "Gardineria", "Garlic", "Green Pepper", "Mushrooms", "Olives", "Onions", "Pepperoni", "Pineapple", "Sausage", "Spinach" };

    private VerticalPanel buildToppingPanel() {
        VerticalPanel toppings = new VerticalPanel();
        toppings.add(new HTML("<h2>Toppings</h2>"));
        Grid topGrid = new Grid(gwt_class_33.TOPPINGS.length + 1, 3);
        topGrid.setText(0, 0, "Topping");
        topGrid.setText(0, 1, "Left");
        topGrid.setText(0, 2, "Right");
        for (int i = 0; i < gwt_class_33.TOPPINGS.length; i++) {
            Button button = new Button(gwt_class_33.TOPPINGS[i]);
            CheckBox leftCheckBox = new CheckBox();
            CheckBox rightCheckBox = new CheckBox();
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

    private class ClearClickListener implements ClickListener {
        public void onClick(Widget sender) {
            for (Iterator iter = clearables.iterator(); iter.hasNext();) {
                CheckBox cb = ((CheckBox) (iter.next()));
                cb.setChecked(false);
            }
        }
    }

    private class ToppingButtonListener implements ClickListener {
        private CheckBox cb1;

        private CheckBox cb2;

        public ToppingButtonListener(CheckBox cb1, CheckBox cb2) {
            this.cb1 = cb1;
            this.cb2 = cb2;
        }

        public void onClick(Widget sender) {
            boolean unchecked = (!cb1.isChecked()) && (!cb2.isChecked());
            cb1.setChecked(unchecked);
            cb2.setChecked(unchecked);
        }
    }
}

