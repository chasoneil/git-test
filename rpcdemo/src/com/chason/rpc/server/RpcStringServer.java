package com.chason.rpc.server;

import com.chason.rpc.service.StringService;
import com.chason.rpc.service.StringServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Rpc 服务端程序
 */
public class RpcStringServer {

    /*
     * 用来存放注册的服务
     * key: service name
     * value : service class
     */
    private static final Map<String, Class<?>> serverMap = new ConcurrentHashMap<>();

    /*
     * 服务启动之后开放的端口
     */
    private int port;

    public RpcStringServer (int port) {
        this.port = port;
    }

    /*
     * 提供注册服务
     * 需要提供注册服务的接口以及实现类
     */
    public RpcStringServer register (Class serviceInterface, Class serviceImpl) {
        serverMap.put(serviceInterface.getName(), serviceImpl);
        return this;
    }

    /*
     * 服务端逻辑
     * 1. 做一个while(true) 循环等待请求
     * 2. 解析请求的参数，获取请求的类名，方法名，参数
     * 3. 执行对应的方法并把结果返回
     */
    public void doService () throws IOException {

        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));   //绑定端口，实现启动监听
        System.out.println("server started!");

        Socket socket          = null;
        ObjectOutputStream oos = null;
        ObjectInputStream  ois = null;

        try {
            while (true) {
                socket = server.accept();
                ois    = new ObjectInputStream(socket.getInputStream());
                String serviceName = ois.readUTF();     // 获取服务名称 本质上就是类名
                Class service = serverMap.get(serviceName);  // 查看已经注册的服务中有没有请求的这个类，如果没有则返回异常
                if (service == null) {
                    throw new ClassNotFoundException(serviceName + "not found");
                }

                String methodName = ois.readUTF();      // 获取请求的方法名
                Class<?>[] parameterTypes = (Class<?>[]) ois.readObject();  // 获取方法参数的类型列表
                Object[] args = (Object[]) ois.readObject(); // 获取参数列表

                Method method = service.getMethod(methodName, parameterTypes);
                if (method == null) {
                    throw new NoSuchMethodException(methodName + "not found");
                }

                Object result = method.invoke(service.newInstance(), args); //通过反射执行类的方法
                oos    = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(result);                                    // 将方法执行的结果返回
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) socket.close();
            if (ois != null) ois.close();
            if (oos != null) oos.close();
        }
    }

    public static void main(String[] args) throws IOException {
        new RpcStringServer(8888).register(StringService.class, StringServiceImpl.class).doService();   // 注册服务并开始监听
    }
}
