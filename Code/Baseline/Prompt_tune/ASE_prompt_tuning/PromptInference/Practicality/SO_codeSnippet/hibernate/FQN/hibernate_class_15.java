/**
 *
 *
 * @author dudekta
 */
public class hibernate_class_15 {
    private java.lang.Long id;

    private java.util.Date creationTimeStamp;

    private java.lang.String name;

    private java.lang.String type;

    private java.lang.String description;

    private java.lang.Long length;

    private byte[] content;

    /**
     * Don't invoke this. Used by Hibernate only.
     */
    public void setContentBlob(java.sql.Blob imageBlob) {
        this.content = this.toByteArray(imageBlob);
    }

    /**
     * Don't invoke this. Used by Hibernate only.
     */
    public java.sql.Blob getContentBlob() {
        return org.hibernate.Hibernate.createBlob(this.content);
    }

    private byte[] toByteArray(java.sql.Blob fromBlob) {
        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
        try {
            return toByteArrayImpl(fromBlob, baos);
        } catch (java.sql.SQLException e) {
            throw new java.lang.RuntimeException(e);
        } catch (java.io.IOException e) {
            throw new java.lang.RuntimeException(e);
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (java.io.IOException ex) {
                }
            }
        }
    }

    private byte[] toByteArrayImpl(java.sql.Blob fromBlob, java.io.ByteArrayOutputStream baos) throws java.sql.SQLException, java.io.IOException {
        byte[] buf = new byte[4000];
        java.io.InputStream is = fromBlob.getBinaryStream();
        try {
            for (; ;) {
                int dataSize = is.read(buf);
                if (dataSize == (-1)) {
                    break;
                }
                baos.write(buf, 0, dataSize);
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (java.io.IOException ex) {
                }
            }
        }
        return baos.toByteArray();
    }

    /**
     *
     *
     * @return Returns the creationTimeStamp.
     */
    public java.util.Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    /**
     *
     *
     * @param creationTimeStamp
     * 		The creationTimeStamp to set.
     */
    public void setCreationTimeStamp(java.util.Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    /**
     *
     *
     * @return Returns the description.
     */
    public java.lang.String getDescription() {
        return description;
    }

    /**
     *
     *
     * @param description
     * 		The description to set.
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    /**
     *
     *
     * @return Returns the id.
     */
    public java.lang.Long getId() {
        return id;
    }

    /**
     *
     *
     * @param id
     * 		The id to set.
     */
    public void setId(java.lang.Long id) {
        this.id = id;
    }

    /**
     *
     *
     * @return Returns the length.
     */
    public java.lang.Long getLength() {
        return length;
    }

    /**
     *
     *
     * @param length
     * 		The length to set.
     */
    public void setLength(java.lang.Long length) {
        this.length = length;
    }

    /**
     *
     *
     * @return Returns the name.
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     *
     *
     * @param name
     * 		The name to set.
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     *
     *
     * @return Returns the type.
     */
    public java.lang.String getType() {
        return type;
    }

    /**
     *
     *
     * @param type
     * 		The type to set.
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }

    /**
     *
     *
     * @return Returns the content.
     */
    public byte[] getContent() {
        return content;
    }

    /**
     *
     *
     * @param content
     * 		The content to set.
     */
    public void setContent(byte[] content) {
        this.content = content;
    }
}

