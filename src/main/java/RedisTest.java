import redis.clients.jedis.Jedis;

public class RedisTest {


    public static Jedis jedis = new Jedis("192.168.134.146", 6379);


    public static void main(String[] args) throws Exception{
        Long m1 = Long.valueOf(getMemory());
        insertData2();

        Long m2 = Long.valueOf(getMemory());

        System.out.println(m2 - m1);

    }



    public static void insertData(){

        for(int i = 10000; i < 100000; i++){

            jedis.set("aa" + i, "aa" + i); //key和value长度都是7字节，且不是整数
        }
    }
    public static void insertData2(){

        for(int i = 10000; i < 100000; i++){

            jedis.set("aaa" + i, "aaa" + i); //key和value长度都是8字节，且不是整数

        }

    }

    public static String getMemory(){

        String memoryAllLine = jedis.info("memory");

        String usedMemoryLine = memoryAllLine.split("\r\n")[1];

        String memory = usedMemoryLine.substring(usedMemoryLine.indexOf(':') + 1);

        return memory;
    }

}