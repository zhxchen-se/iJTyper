@com.thoughtworks.xstream.annotations.XStreamAlias("Music")


public class xstream_class_31 {
    static java.lang.String xml1 = "<Music><type>rock</type></Music>";

    public static void main(java.lang.String[] args) {
        com.thoughtworks.xstream.XStream xStream = new com.thoughtworks.xstream.XStream();
        xStream.processAnnotations(xstream.Music.class);
        xstream.Music musicObject = ((xstream.Music) (xStream.fromXML(xstream.xstream_class_31.xml1)));
        java.lang.System.out.println(musicObject);
        // prints Music [type=ROCK]
    }
}

class Music {
    public enum genre {

        ROCK,
        JAZZ;}

    xstream.Music.genre type;

    @java.lang.Override
    public java.lang.String toString() {
        return ("Music [type=" + type) + "]";
    }
}
