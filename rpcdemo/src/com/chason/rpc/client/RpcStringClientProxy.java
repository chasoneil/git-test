package com.chason.rpc.client;

import com.chason.rpc.service.StringService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 通过jdk动态代理执行方法
 * 1. 需要一个地址去发送请求
 */
public class RpcStringClientProxy<T> implements InvocationHandler {

    // 代理的服务类
    public Class<T> serviceInterface;

    private InetSocketAddress address;

    public RpcStringClientProxy (String host, int port, Class<T> serviceInterface) {
        this.serviceInterface = serviceInterface;
        this.address = new InetSocketAddress(host, port);
    }

    /*
     * 创建指定类的代理
     */
    public T createRpcClientProxy(){
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, this);
    }


    /*
     * 通过反射将远程调用的参数传给server
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Socket socket          = null;
        ObjectOutputStream oos = null;
        ObjectInputStream  ois = null;

        try {

            socket = new Socket();
            socket.connect(address);

            oos = new ObjectOutputStream(socket.getOutputStream());
            // 注意，这里的顺序和服务端接收的顺序必须一致
            oos.writeUTF(serviceInterface.getName());
            oos.writeUTF(method.getName());
            oos.writeObject(method.getParameterTypes());
            oos.writeObject(args);

            // 等待服务端应答
            ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } finally {
            if (socket != null) socket.close();
            if (oos != null) oos.close();
            if (ois != null) ois.close();
        }

    }

    // 客户端程序启动入口
    public static void main(String[] args) {

        RpcStringClientProxy proxy = new RpcStringClientProxy("127.0.0.1", 8888, StringService.class);
        StringService rpcClientProxy = (StringService) proxy.createRpcClientProxy();
        System.out.println(rpcClientProxy.lower("AAA"));

    }
}
