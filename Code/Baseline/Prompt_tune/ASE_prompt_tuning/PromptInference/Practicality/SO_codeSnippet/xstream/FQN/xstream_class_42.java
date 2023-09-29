public class xstream_class_42 {
    @com.thoughtworks.xstream.annotations.XStreamAlias("addressServiceConfig")
    public class AddressServiceConfig {
        private java.lang.String pathToCodeposFiles;

        @com.thoughtworks.xstream.annotations.XStreamImplicit(itemFieldName = "region")
        private java.util.List<xstream_class_42.Region> regions;
    }

    @com.thoughtworks.xstream.annotations.XStreamAlias("region")
    public class Region {
        private java.lang.String regionName;

        @com.thoughtworks.xstream.annotations.XStreamImplicit(itemFieldName = "province")
        private java.util.List<xstream_class_42.Province> provinces;
    }

    @com.thoughtworks.xstream.annotations.XStreamAlias("province")
    public class Province {
        private int code;

        private java.lang.String name;
    }
}

