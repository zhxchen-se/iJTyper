public class hibernate_class_15 {
    private java.lang.Long id;

    private java.sql.Date creationTimeStamp;

    private java.lang.String name;

    private java.lang.String type;

    private java.lang.String description;

    private java.lang.Long length;

    private byte[] content;

    public void setContentBlob(java.sql.Blob imageBlob) {
        this.content = this.toByteArray(imageBlob);
    }

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

    public java.sql.Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(java.sql.Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public java.lang.String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.Long getLength() {
        return length;
    }

    public void setLength(java.lang.Long length) {
        this.length = length;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}

