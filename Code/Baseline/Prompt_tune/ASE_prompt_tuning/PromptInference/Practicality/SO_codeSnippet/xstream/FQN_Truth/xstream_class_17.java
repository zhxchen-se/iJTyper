public final class xstream_class_17 {
    public static void main(java.lang.String[] args) {
        com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream();
        xstream.autodetectAnnotations(true);
        xstream.registerConverter(new xstream_class_17.PositionConverter());
        final xstream_class_17.Position position = new xstream_class_17.Position();
        position.setTitle("The Title");
        position.setStartDate("The Start Date");
        position.setEndDate("The End Date");
        final java.lang.String xml = xstream.toXML(position);
        java.lang.System.out.println("Generated XML:");
        java.lang.System.out.println(xml);
        final xstream_class_17.Position genPosition = ((xstream_class_17.Position) (xstream.fromXML(xml)));
        java.lang.System.out.println("Generated Position:");
        java.lang.System.out.println("\tTitle: " + genPosition.getTitle());
        java.lang.System.out.println("\tStart Date: " + genPosition.getStartDate());
        java.lang.System.out.println("\tEnd Date: " + genPosition.getEndDate());
    }

    @com.thoughtworks.xstream.annotations.XStreamAlias("Position")
    private static class Position {
        public java.lang.String getEndDate() {
            return endDate;
        }

        public void setEndDate(java.lang.String endDate) {
            this.endDate = endDate;
        }

        public java.lang.String getStartDate() {
            return startDate;
        }

        public void setStartDate(java.lang.String startDate) {
            this.startDate = startDate;
        }

        public java.lang.String getTitle() {
            return title;
        }

        public void setTitle(java.lang.String title) {
            this.title = title;
        }

        private java.lang.String title;

        private java.lang.String startDate;

        private java.lang.String endDate;
    }

    private static class PositionConverter implements com.thoughtworks.xstream.converters.Converter {
        public boolean canConvert(java.lang.Class clazz) {
            return xstream.xstream_class_17.Position.class == clazz;
        }

        public void marshal(java.lang.Object value, com.thoughtworks.xstream.io.HierarchicalStreamWriter writer, com.thoughtworks.xstream.converters.MarshallingContext context) {
            xstream.xstream_class_17.Position position = ((xstream.xstream_class_17.Position) (value));
            writer.startNode("PositionBorder");
            writer.startNode("Title");
            writer.setValue(position.getTitle());
            writer.endNode();
            writer.startNode("StartDate");
            writer.setValue(position.getStartDate());
            writer.endNode();
            writer.startNode("EndDate");
            writer.setValue(position.getEndDate());
            writer.endNode();
            writer.endNode();
        }

        public java.lang.Object unmarshal(com.thoughtworks.xstream.io.HierarchicalStreamReader reader, com.thoughtworks.xstream.converters.UnmarshallingContext context) {
            xstream.xstream_class_17.Position position = new xstream.xstream_class_17.Position();
            // move it to <PositionBorder> tag.
            reader.moveDown();
            // now move it to <Title> tag.
            reader.moveDown();
            java.lang.String title = reader.getValue();
            position.setTitle(title);
            reader.moveUp();// moves back to <PositionBorder>

            reader.moveDown();// should move down to <StartDate> tag

            java.lang.String startDate = reader.getValue();
            position.setStartDate(startDate);
            reader.moveUp();// move back to <PositionBorder>

            reader.moveDown();// should move down to <EndDate> tag

            java.lang.String endDate = reader.getValue();
            position.setEndDate(endDate);
            reader.moveUp();// move back to <PositionBorder>

            return position;
        }
    }
}

