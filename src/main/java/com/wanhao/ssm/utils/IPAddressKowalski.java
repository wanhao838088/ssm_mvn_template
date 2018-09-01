package com.wanhao.ssm.utils;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;

/**
 * Created by LiuLiHao on 2018/9/1 16:57.
 * 描述： 动态获取项目运行时端口号
 * 作者： LiuLiHao
 */
public class IPAddressKowalski {

    public static String getIpAddressAndPort() throws Exception {
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String host = InetAddress.getLocalHost().getHostAddress();
        String port = objectNames.iterator().next().getKeyProperty("port");
        String ipadd = "http" + "://" + host + ":" + port;
        System.out.println(ipadd);
        return ipadd;
    }

    public static int getTomcatPort() throws Exception{
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
                Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
        String port = objectNames.iterator().next().getKeyProperty("port");

        return Integer.valueOf(port);
    }
}
