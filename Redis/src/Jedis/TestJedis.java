package Jedis;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄佳豪
 * @create 2019-08-08-15:09
 */
public class TestJedis {
    public static void main(String[] args) {
        // 创建jedis对象
        Jedis jedis = new Jedis("192.168.1.100", 6379);
        // 测试连接
        String ping = jedis.ping();
        System.out.println(ping);
        // 向Redis中添加String类型数据
        jedis.set("k7", "v7");
        String v7 = jedis.get("k7");
        System.out.println("k7对应的value" + v7);
        //获取Redis中所有的key
        Set<String> keys = jedis.keys("*");
        for (String key : keys) {
            System.out.println(key);
        }

        //关闭
        jedis.close();
    }

    @Test
    public void JedisClusterTest() {

        Set<HostAndPort> set = new HashSet<HostAndPort>();
        set.add(new HostAndPort("192.168.1.100", 6379));
        JedisCluster jedisCluster = new JedisCluster(set);

        jedisCluster.set("k1", "v1");
        System.out.println(jedisCluster.get("k1"));
    }

}

