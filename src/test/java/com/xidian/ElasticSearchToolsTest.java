package com.xidian;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class ElasticSearchToolsTest {
	
	public static void main(String[] argv) throws UnknownHostException{  
		// on startup
		TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		        .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.114.132"), 9300));
		        //.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));

		 //搜索数据
        //GetResponse response = client.prepareGet("logstash-http", "article", "1").execute().actionGet();
		GetResponse response = client.prepareGet("logstash-dns", "logs", "AVt5ySwVwDetNwDhw-YW").execute().actionGet();
        //输出结果
        System.out.println(response.getSourceAsString());
        
		// on shutdown
        client.close();
    }
	
	
	public static void temp(){
		
	}
}
