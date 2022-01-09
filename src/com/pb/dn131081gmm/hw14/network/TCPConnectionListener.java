package com.pb.dn131081gmm.hw14.network;

public interface TCPConnectionListener {
    void onDisconect(TCPConnection tcpConnection);
    void onConnectionReady(TCPConnection tcpConnection);
    void onExeption(TCPConnection tcpConnection, Exception e);
    void onResiveString(TCPConnection tcpConnection, String str);
}
