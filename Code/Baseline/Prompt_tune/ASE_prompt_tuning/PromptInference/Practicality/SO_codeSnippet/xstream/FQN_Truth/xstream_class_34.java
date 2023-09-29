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
            if (environments == null) {
                environments = new java.util.ArrayList<com.cloudbees.api.config.Environment>();
            }
            return environments;
        }

        public void setEnvironments(java.util.List<com.cloudbees.api.config.Environment> environments) {
            this.environments = environments;
        }

        public void setEnvironment(com.cloudbees.api.config.Environment environment) {
            deleteEnvironment(environment.getName());
            getEnvironments().add(environment);
        }

        public com.cloudbees.api.config.Environment getEnvironment(java.lang.String env) {
            for (com.cloudbees.api.config.Environment environment : getEnvironments()) {
                if (env.equals(environment.getName())) {
                    return environment;
                }
            }
            return null;
        }

        public void deleteEnvironment(java.lang.String name) {
            java.util.Iterator<com.cloudbees.api.config.Environment> it = getEnvironments().iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(name)) {
                    it.remove();
                }
            } 
        }

        public java.util.List<com.cloudbees.api.config.ResourceSettings> getResources() {
            if (resources == null) {
                resources = new java.util.ArrayList<com.cloudbees.api.config.ResourceSettings>();
            }
            return resources;
        }

        public void setResources(java.util.List<com.cloudbees.api.config.ResourceSettings> resources) {
            this.resources = resources;
        }

        public void setResource(com.cloudbees.api.config.ResourceSettings resource) {
            deleteResource(resource.getName());
            getResources().add(resource);
        }

        public com.cloudbees.api.config.ResourceSettings getResource(java.lang.String name) {
            for (com.cloudbees.api.config.ResourceSettings resource : getResources()) {
                if (resource.getName().equals(name)) {
                    return resource;
                }
            }
            return null;
        }

        public void deleteResource(java.lang.String name) {
            java.util.Iterator<com.cloudbees.api.config.ResourceSettings> it = getResources().iterator();
            while (it.hasNext()) {
                if (it.next().getName().equals(name)) {
                    it.remove();
                }
            } 
        }

        private com.thoughtworks.xstream.XStream createXStream() {
            com.thoughtworks.xstream.XStream xstream = new com.thoughtworks.xstream.XStream() {
                protected com.thoughtworks.xstream.mapper.MapperWrapper wrapMapper(com.thoughtworks.xstream.mapper.MapperWrapper next) {
                    return new com.thoughtworks.xstream.mapper.MapperWrapper(next) {
                        public boolean shouldSerializeMember(java.lang.Class definedIn, java.lang.String fieldName) {
                            return (definedIn != java.lang.Object.class) && super.shouldSerializeMember(definedIn, fieldName);
                        }
                    };
                }
            };
            xstream.setClassLoader(xstream_class_34.ConfigParameters.class.getClassLoader());
            xstream.processAnnotations(com.cloudbees.api.config.ResourceSettings.class);
            xstream.processAnnotations(com.cloudbees.api.config.Environment.class);
            xstream.processAnnotations(xstream_class_34.ConfigParameters.class);
            xstream.processAnnotations(com.cloudbees.api.config.ParameterHolder.class);
            return xstream;
        }

        /**
         * Returns a string representation of XML.
         */
        public java.lang.String toXML() {
            return createXStream().toXML(this);
        }

        public xstream.xstream_class_34.ConfigParameters parse(java.lang.String xml) {
            if (xml == null) {
                return new xstream.xstream_class_34.ConfigParameters();
            }
            return ((xstream.xstream_class_34.ConfigParameters) (createXStream().fromXML(xml)));
        }
    }
}

