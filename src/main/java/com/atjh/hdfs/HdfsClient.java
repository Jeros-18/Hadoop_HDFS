package com.atjh.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 客户端代码常用套路
 * 1.获取客户端对象
 * 2.执行相关的操作命令
 * 3.关闭资源
 * HDFS zookeeper
 */
public class HdfsClient {

    private FileSystem fs;

    @Before
    public void init() throws URISyntaxException, IOException, InterruptedException {
        //连接集群nn地址
        URI uri = new URI("hdfs://hadoop102:8020");
        //创建一个配置文件
        Configuration configuration = new Configuration();
        //创建用户
        String user = "atjh";
        //1.获取客户端对象
        fs = FileSystem.get(uri, configuration, user);
    }

    @After
    public void close() throws IOException {
        //3.关闭资源
        fs.close();
    }


    @Test
    public void testmkdir() throws URISyntaxException, IOException, InterruptedException {

        //2.执行相关的操作命令
        fs.mkdirs(new Path("/xiyou/huaguoshan2"));

    }

}
