package com.unauthorisedadults.dnnr.network;

import com.smartarmenia.dotnetcoresignalrclientjava.HubConnection;
import com.smartarmenia.dotnetcoresignalrclientjava.WebSocketHubConnection;
import com.smartarmenia.dotnetcoresignalrclientjava.WebSocketHubConnectionP2;
import com.unauthorisedadults.dnnr.utilities.UTIL;

public class BusinessConnection {

    private static final BusinessConnection instance = new BusinessConnection();
    private HubConnection hubConnection;

    private BusinessConnection() {

    }

    public static BusinessConnection getInstance() {
        return instance;
    }

    public void CastVote(String groupId, int id) {
        hubConnection = new WebSocketHubConnectionP2(UTIL.HUB_URI + "grouphub", "");
        hubConnection.connect();
        System.out.println(hubConnection.isConnected());
    }
}
