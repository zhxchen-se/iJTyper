public class hibernate_class_17 {
    public class SessionFactoryImpl {
        private static final java.lang.String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";

        private static final java.lang.String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";

        private static final java.lang.String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

        public org.hibernate.SessionFactory createSessionFactory() throws javax.naming.NamingException {
            org.hibernate.cfg.Configuration prototypeConfig = new org.hibernate.cfg.Configuration().configure(hibernate.hibernate_class_17.SessionFactoryImpl.SHARD_CFG_0);
            prototypeConfig.addResource(hibernate.hibernate_class_17.SessionFactoryImpl.SHARDED_TABLE);
            java.util.List<org.hibernate.shards.cfg.ShardConfiguration> shardConfigs = new java.util.ArrayList<org.hibernate.shards.cfg.ShardConfiguration>();
            shardConfigs.add(buildShardConfig(hibernate.hibernate_class_17.SessionFactoryImpl.SHARD_CFG_0));
            shardConfigs.add(buildShardConfig(hibernate.hibernate_class_17.SessionFactoryImpl.SHARD_CFG_1));
            org.hibernate.shards.strategy.ShardStrategyFactory shardStrategyFactory = buildShardStrategyFactory();
            org.hibernate.shards.ShardedConfiguration shardedConfig = new org.hibernate.shards.ShardedConfiguration(prototypeConfig, shardConfigs, shardStrategyFactory);
            return shardedConfig.buildShardedSessionFactory();
        }

        private org.hibernate.shards.strategy.ShardStrategyFactory buildShardStrategyFactory() {
            org.hibernate.shards.strategy.ShardStrategyFactory shardStrategyFactory = new org.hibernate.shards.strategy.ShardStrategyFactory() {
                public org.hibernate.shards.strategy.ShardStrategy newShardStrategy1(java.util.List<org.hibernate.shards.ShardId> shardIds) {
                    org.hibernate.shards.loadbalance.RoundRobinShardLoadBalancer loadBalancer = new org.hibernate.shards.loadbalance.RoundRobinShardLoadBalancer(shardIds);
                    org.hibernate.shards.strategy.selection.ShardSelectionStrategy pss = new org.hibernate.shards.strategy.selection.RoundRobinShardSelectionStrategy(loadBalancer);
                    org.hibernate.shards.strategy.resolution.ShardResolutionStrategy prs = new org.hibernate.shards.strategy.resolution.AllShardsShardResolutionStrategy(shardIds);
                    org.hibernate.shards.strategy.access.ShardAccessStrategy pas = new org.hibernate.shards.strategy.access.SequentialShardAccessStrategy();
                    return new org.hibernate.shards.strategy.ShardStrategyImpl(pss, prs, pas);
                }

                @java.lang.Override
                public org.hibernate.shards.strategy.ShardStrategy newShardStrategy(java.util.List<org.hibernate.shards.ShardId> arg0) {
                    return null;
                }
            };
            return shardStrategyFactory;
        }

        private org.hibernate.shards.cfg.ShardConfiguration buildShardConfig(java.lang.String configFile) {
            org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration().configure(configFile);
            return new org.hibernate.shards.cfg.ConfigurationToShardConfigurationAdapter(config);
        }
    }
}

