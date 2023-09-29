public class xstream_class_34 {
  @com.thoughtworks.xstream.annotations.XStreamAlias("config")
  public class ConfigParameters extends com.cloudbees.api.config.ParameterHolder {
    @com.thoughtworks.xstream.annotations.XStreamImplicit(itemFieldName = "resource")
    private java.util.List<com.cloudbees.api.config.ResourceSettings> resources;

    @com.thoughtworks.xstream.annotations.XStreamImplicit(itemFieldName = "env")
    private java.util.List<com.cloudbees.api.config.Environment> environments;

    public ConfigParameters() {
    }

    public java.util.List<com.cloudbees.api.config.Environment> getEnvironments() {
      if (environments == null)
        environments = new java.util.ArrayList<com.cloudbees.api.config.Environment>();

      return environments;
    }

    public void setEnvironments(java.util.List<com.cloudbees.api.config.Environment> environments) {
      this.environments = environments;
    }

    public void setEnvironment(com.cloudbees.api.config.Environment environment) {
      xstream_class_34$ConfigParameters.deleteEnvironment(java.lang.String)
      xstream_class_34$ConfigParameters.getEnvironments()###java.util.List.add(com.cloudbees.api.config.Environment)
    }

    public com.cloudbees.api.config.Environment getEnvironment(java.lang.String env) {
      for (com.cloudbees.api.config.Environment environment : xstream_class_34$ConfigParameters.getEnvironments()) {
        if (java.lang.String.equals(java.lang.Object))
          return environment;

      }
      return null;
    }

    public void deleteEnvironment(java.lang.String name) {
      java.util.Iterator<com.cloudbees.api.config.Environment> it = xstream_class_34$ConfigParameters.getEnvironments()###java.util.List.iterator();
      while (java.util.Iterator.hasNext()) {
        if (java.util.Iterator.next()###<unknown>.getName()###<unknown>.equals(java.lang.String)) {
          java.util.Iterator.remove()
        }
      } 
    }

    public java.util.List<com.cloudbees.api.config.ResourceSettings> getResources() {
      if (resources == null)
        resources = new java.util.ArrayList<com.cloudbees.api.config.ResourceSettings>();

      return resources;
    }

    public void setResources(java.util.List<com.cloudbees.api.config.ResourceSettings> resources) {
      this.resources = resources;
    }

    public void setResource(com.cloudbees.api.config.ResourceSettings resource) {
      xstream_class_34$ConfigParameters.deleteResource(java.lang.String)
      xstream_class_34$ConfigParameters.getResources()###java.util.List.add(com.cloudbees.api.config.ResourceSettings)
    }

    public com.cloudbees.api.config.ResourceSettings getResource(java.lang.String name) {
      for (com.cloudbees.api.config.ResourceSettings resource : xstream_class_34$ConfigParameters.getResources()) {
        if (com.cloudbees.api.config.ResourceSettings.getName()###<unknown>.equals(java.lang.String))
          return resource;

      }
      return null;
    }

    public void deleteResource(java.lang.String name) {
      java.util.Iterator<com.cloudbees.api.config.ResourceSettings> it = xstream_class_34$ConfigParameters.getResources()###java.util.List.iterator();
      while (java.util.Iterator.hasNext()) {
        if (java.util.Iterator.next()###<unknown>.getName()###<unknown>.equals(java.lang.String)) {
          java.util.Iterator.remove()
        }
      } 
    }

    private com.thoughtworks.xstream.XStream createXStream() {
      com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream() {
        protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(com.thoughtworks.xstream.mapper.MapperWrapper next) {
          return new com.thoughtworks.xstream.mapper.MapperWrapper(next) {
            public boolean shouldSerializeMember(java.lang.Class definedIn, java.lang.String fieldName) {
              return (definedIn != java.lang.Object.class) && <unknown>.shouldSerializeMember(java.lang.Class,java.lang.String);
            }
          };
        }
      };
      com.thoughtworks.xstream.XStream.setClassLoader(java.lang.ClassLoader)
      com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
      com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
      com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
      com.thoughtworks.xstream.XStream.processAnnotations(java.lang.Class)
      return xstream;
    }

    /**
     * Returns a string representation of XML.
     */
    public java.lang.String toXML() {
      return xstream_class_34$ConfigParameters.createXStream()###com.thoughtworks.xstream.XStream.toXML(xstream_class_34$ConfigParameters);
    }

    public xstream_class_34.ConfigParameters parse(java.lang.String xml) {
      if (xml == null)
        return new xstream_class_34.ConfigParameters();

      return xstream_class_34$ConfigParameters.createXStream()###com.thoughtworks.xstream.XStream.fromXML(java.lang.String);
    }
  }
}
