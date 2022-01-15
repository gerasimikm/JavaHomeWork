package com.pb.dn131081gmm.hw15.network;

public interface TCPConnectionListener {
    void onConnectionReady(TCPConnection tcpConnection);

    void onResiveString(TCPConnection tcpConnection, String str);

    void onDisconect(TCPConnection tcpConnection);

    void onExeption(TCPConnection tcpConnection, Exception e);

}
