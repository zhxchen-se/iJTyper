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
    gwt_class_33.initDockPanel()
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.HorizontalPanel)
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.VerticalPanel)
    com.google.gwt.user.client.ui.DockPanel.add(com.google.gwt.user.client.ui.VerticalPanel)
    com.google.gwt.user.client.ui.RootPanel.get(java.lang.String)###<unknown>.add(com.google.gwt.user.client.ui.DockPanel)
  }

  private void initDockPanel() {
    panel = new com.google.gwt.user.client.ui.DockPanel();
    com.google.gwt.user.client.ui.DockPanel.setBorderWidth(int)
    com.google.gwt.user.client.ui.DockPanel.setSpacing(int)
  }

  public com.google.gwt.user.client.ui.HorizontalPanel buildActionPanel() {
    com.google.gwt.user.client.ui.HorizontalPanel actions = new com.google.gwt.user.client.ui.HorizontalPanel();
    com.google.gwt.user.client.ui.HorizontalPanel.setSpacing(int)
    com.google.gwt.user.client.ui.Button clear = new com.google.gwt.user.client.ui.Button("Clear");
    com.google.gwt.user.client.ui.Button.addClickListener(gwt_class_33$ClearClickListener)
    com.google.gwt.user.client.ui.Button newPizza = new com.google.gwt.user.client.ui.Button("Another Pizza");
    com.google.gwt.user.client.ui.Button submitOrder = new com.google.gwt.user.client.ui.Button("Submit");
    com.google.gwt.user.client.ui.HorizontalPanel.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.HorizontalPanel.add(com.google.gwt.user.client.ui.Button)
    com.google.gwt.user.client.ui.HorizontalPanel.add(com.google.gwt.user.client.ui.Button)
    return actions;
  }

  public static final java.lang.String[] PIZZA_TYPES = new java.lang.String[]{ "Thin Crust Medium", "Thin Crust Large", "Thin Crust X-Large", "Thick Crust Medium", "Thick Crust Large" };

  private com.google.gwt.user.client.ui.VerticalPanel buildPizzaTypePanel() {
    com.google.gwt.user.client.ui.VerticalPanel pizzaTypes = new com.google.gwt.user.client.ui.VerticalPanel();
    com.google.gwt.user.client.ui.HTML label = new com.google.gwt.user.client.ui.HTML("<h2>Pizza</h2>");
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.HTML)
    for (int i = 0; i < gwt_class_33.PIZZA_TYPES.length; i++) {
      com.google.gwt.user.client.ui.RadioButton radio = new com.google.gwt.user.client.ui.RadioButton("pizzaGroup", gwt_class_33.PIZZA_TYPES[i]);
      java.util.List.add(java.lang.Object)
      com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.RadioButton)
    }
    return pizzaTypes;
  }

  public static final java.lang.String[] TOPPINGS = new java.lang.String[]{ "Anchovy", "Gardineria", "Garlic", "Green Pepper", "Mushrooms", "Olives", "Onions", "Pepperoni", "Pineapple", "Sausage", "Spinach" };

  private com.google.gwt.user.client.ui.VerticalPanel buildToppingPanel() {
    com.google.gwt.user.client.ui.VerticalPanel toppings = new com.google.gwt.user.client.ui.VerticalPanel();
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.HTML)
    com.google.gwt.user.client.ui.Grid topGrid = new com.google.gwt.user.client.ui.Grid(gwt_class_33.TOPPINGS.length + 1, 3);
    com.google.gwt.user.client.ui.Grid.setText(int,int,java.lang.String)
    com.google.gwt.user.client.ui.Grid.setText(int,int,java.lang.String)
    com.google.gwt.user.client.ui.Grid.setText(int,int,java.lang.String)
    for (int i = 0; i < gwt_class_33.TOPPINGS.length; i++) {
      com.google.gwt.user.client.ui.Button button = new com.google.gwt.user.client.ui.Button(gwt_class_33.TOPPINGS[i]);
      com.google.gwt.user.client.ui.CheckBox leftCheckBox = new com.google.gwt.user.client.ui.CheckBox();
      com.google.gwt.user.client.ui.CheckBox rightCheckBox = new com.google.gwt.user.client.ui.CheckBox();
      java.util.List.add(java.lang.Object)
      java.util.List.add(java.lang.Object)
      com.google.gwt.user.client.ui.Button.addClickListener(gwt_class_33$ToppingButtonListener)
      com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.Button)
      com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.CheckBox)
      com.google.gwt.user.client.ui.Grid.setWidget(int,int,com.google.gwt.user.client.ui.CheckBox)
    }
    com.google.gwt.user.client.ui.VerticalPanel.add(com.google.gwt.user.client.ui.Grid)
    return toppings;
  }

  private class ClearClickListener implements com.google.gwt.user.client.ui.ClickListener {
    public void onClick(com.google.gwt.user.client.ui.Widget sender) {
      for (java.util.Iterator iter = java.util.List.iterator(); java.util.Iterator.hasNext();) {
        com.google.gwt.user.client.ui.CheckBox cb = java.util.Iterator.next();
        com.google.gwt.user.client.ui.CheckBox.setChecked(boolean)
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
      boolean unchecked = (!com.google.gwt.user.client.ui.CheckBox.isChecked()) && (!com.google.gwt.user.client.ui.CheckBox.isChecked());
      com.google.gwt.user.client.ui.CheckBox.setChecked(boolean)
      com.google.gwt.user.client.ui.CheckBox.setChecked(boolean)
    }
  }
}
