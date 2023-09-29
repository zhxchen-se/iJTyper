public class hibernate_class_17 {
  public class SessionFactoryImpl {
    private static final java.lang.String SHARD_CFG_0 = "/com/hibshards/config/shard0.hibernate.cfg.xml";

    private static final java.lang.String SHARD_CFG_1 = "/com/hibshards/config/shard1.hibernate.cfg.xml";

    private static final java.lang.String SHARDED_TABLE = "com/hibshards/orm/weather.hbm.xml";

    public org.hibernate.SessionFactory createSessionFactory() throws javax.naming.NamingException {
      org.hibernate.cfg.Configuration prototypeConfig = org.hibernate.cfg.Configuration.configure(java.lang.String);
      org.hibernate.cfg.Configuration.addResource(java.lang.String)
      java.util.List<org.hibernate.shards.cfg.ShardConfiguration> shardConfigs = new java.util.ArrayList<org.hibernate.shards.cfg.ShardConfiguration>();
      java.util.List.add(org.hibernate.shards.cfg.ShardConfiguration)
      java.util.List.add(org.hibernate.shards.cfg.ShardConfiguration)
      org.hibernate.shards.strategy.ShardStrategyFactory shardStrategyFactory = hibernate_class_17$SessionFactoryImpl.buildShardStrategyFactory();
      org.hibernate.shards.ShardedConfiguration shardedConfig = new org.hibernate.shards.ShardedConfiguration(prototypeConfig, shardConfigs, shardStrategyFactory);
      return org.hibernate.shards.ShardedConfiguration.buildShardedSessionFactory();
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
          // TODO Auto-generated method stub
          return null;
        }
      };
      return shardStrategyFactory;
    }

    private org.hibernate.shards.cfg.ShardConfiguration buildShardConfig(java.lang.String configFile) {
      org.hibernate.cfg.Configuration config = org.hibernate.cfg.Configuration.configure(java.lang.String);
      return new org.hibernate.shards.cfg.ConfigurationToShardConfigurationAdapter(config);
    }
  }
}
