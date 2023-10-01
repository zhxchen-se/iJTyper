@javax.persistence.Entity
public class hibernate_class_28 implements java.io.Serializable {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
    private int id;

    @javax.persistence.ManyToOne
    @javax.persistence.JoinColumn(name = "user_id")
    private library.model.User user;

    @javax.persistence.OneToMany(targetEntity = hibernate.hibernate_class_28.class)
    @javax.persistence.JoinColumn(name = "parent_id")
    @org.hibernate.annotations.IndexColumn(name = "id", base = 0)
    private java.util.List<hibernate.hibernate_class_28> comments = new java.util.ArrayList<hibernate.hibernate_class_28>();

    @javax.persistence.Column(name = "article_id", length = 10)
    private int articleId;

    @javax.persistence.Column(name = "text", length = 8192)
    private java.lang.String text;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getText() {
        return text;
    }

    public void setText(java.lang.String text) {
        this.text = text;
    }

    public library.model.User getUser() {
        return user;
    }

    public void setUser(library.model.User user) {
        this.user = user;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((((((("Comment [" + "articleId ") + articleId) + " ") + "id ") + id) + " ") + "text ") + text) + " ") + "]";
    }
}

