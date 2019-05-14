package demo.web;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try{
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.socket().bind(new InetSocketAddress(8081));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while (true){
                    if(serverSelector.select(1) > 0){
                        Set<SelectionKey> keys = serverSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = keys.iterator();

                        while (iterator.hasNext()){
                            SelectionKey next = iterator.next();
                            if(next.isAcceptable()){
                                try{
                                    SocketChannel accept = ((ServerSocketChannel) next.channel()).accept();
                                    accept.configureBlocking(false);
                                    accept.register(clientSelector,SelectionKey.OP_READ);
                                }catch (Exception e){

                                }

                            }
                        }
                    }
                }
            }catch (Exception e){}
        }).start();



        new Thread(() -> {
            try{
                while (true){
                    if(clientSelector.select(1)>0){
                        Set<SelectionKey> selectionKeys = clientSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()){
                            SelectionKey next = iterator.next();
                            if(next.isReadable()){
                                try{
                                    SocketChannel cancel = (SocketChannel) next.channel();
                                    ByteBuffer allocate = ByteBuffer.allocate(1024);
                                    cancel.read(allocate);
                                    allocate.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(allocate).toString());

                                }finally {
                                    iterator.remove();
                                    next.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            }catch (Exception e){}
        }).start();
    }
}
