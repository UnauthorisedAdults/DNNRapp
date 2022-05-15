package com.unauthorisedadults.dnnr.services.nearbyConnect;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import static java.nio.charset.StandardCharsets.UTF_8;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

import okio.Utf8;

public class ReceiveBytePayload extends PayloadCallback {


    @Override
    public void onPayloadReceived(@NonNull String endpointId, @NonNull Payload payload) {
        //Modtager et byte array i UTF_8 encoding og pakker det ud til food id
         int affirmativeVoteId = Integer.parseInt(new String(payload.asBytes(), UTF_8));
    }

    @Override
    public void onPayloadTransferUpdate(@NonNull String endpointId, @NonNull PayloadTransferUpdate payloadTransferUpdate) {
        //Hvad der skal ske når man har modtaget en opdatering
        //Noget med if(IsMatch()) do something
    }
}
