package com.kartuzov.mafiaonline;

import io.socket.emitter.Emitter;
import org.json.JSONArray;
import org.json.JSONObject;

class decodeEmitterListener implements Emitter.Listener {
    Emitter.Listener l;

    public decodeEmitterListener(Emitter.Listener var1) {
        this.l = var1;
    }

    public void call(Object... var1) {
        if (var1 != null && var1.length >= 1 && var1[0] instanceof JSONArray && ((JSONArray)var1[0]).length() >= 1 && ((JSONArray)var1[0]).get(0).getClass().equals(JSONObject.class) && !((JSONArray)var1[0]).getJSONObject(0).isNull("lfm5") || var1 != null && var1.length >= 1 && var1[0] instanceof JSONObject && !((JSONObject)var1[0]).isNull("lfm5")) {
            var1[0] = MafSocket.decodeData(var1[0], 0);
        }

        this.l.call(var1);
    }
}