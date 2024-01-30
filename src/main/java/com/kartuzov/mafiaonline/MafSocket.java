package com.kartuzov.mafiaonline;

import com.badlogic.gdx.math.MathUtils;
import io.socket.client.Ack;
import io.socket.client.Manager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MafSocket {
    Socket socket;

    public MafSocket(Socket var1) {
        this.socket = var1;
    }

    public static JSONObject createCopyOfJson(JSONObject var0) {
        JSONObject var1 = new JSONObject();

        for(int var2 = 0; var2 < var0.names().length(); ++var2) {
            var1.put(var0.names().getString(var2), var0.get(var0.names().getString(var2)));
        }

        return var1;
    }

    public static JSONArray createCopyOfJsonArr(JSONArray var0) {
        JSONArray var1 = new JSONArray();

        for(int var2 = 0; var2 < var0.length(); ++var2) {
            var1.put(var0.get(var2));
        }

        return var1;
    }

    private static Object decode(Object var0, int var1) {
        int var3;
        if (!(var0 instanceof JSONArray)) {
            if (var0 instanceof Boolean) {
                return var0;
            } else {
                Object var6 = var0;
                if (!(var0 instanceof String)) {
                    var6 = var0.toString();
                }

                char[] var5 = ((String)var6).toCharArray();

                for(var3 = 0; var3 < var5.length; ++var3) {
                    if (var3 == var5.length - 1 && var5[var3] == ' ') {
                        return Integer.valueOf((new String(var5)).substring(0, var3));
                    }

                    var5[var3] = (char)(var5[var3] - var1);
                }

                return new String(var5);
            }
        } else {
            JSONArray var2 = new JSONArray();
            var3 = 0;

            while(true) {
                JSONArray var4 = (JSONArray)var0;
                if (var3 >= var4.length()) {
                    if (var2.length() >= 5) {
                        Object var7 = var2.get(0);
                        var0 = var2.get(1);
                        var2.put(0, var2.get(var2.length() - 1));
                        var2.put(var2.length() - 1, var7);
                        var2.put(1, var2.get(3));
                        var2.put(3, var0);
                    }

                    return var2;
                }

                var2.put(decode(var4.get(var3), var1));
                ++var3;
            }
        }
    }

    public static Object decodeData(Object var0, int var1) {
        if (var0 != null) {
            boolean var10001;
            int var2;
            label174: {
                try {
                    if (!var0.getClass().equals(JSONArray.class)) {
                        break label174;
                    }
                } catch (ArrayIndexOutOfBoundsException var21) {
                    var10001 = false;
                    return var0;
                }

                var2 = 0;

                while(true) {
                    label96: {
                        label186: {
                            try {
                                if (var2 >= ((JSONArray)var0).length()) {
                                    break;
                                }

                                if (((JSONArray)var0).get(var2).getClass().equals(JSONObject.class) || ((JSONArray)var0).get(var2).getClass().equals(JSONArray.class)) {
                                    break label186;
                                }
                            } catch (ArrayIndexOutOfBoundsException var10) {
                                var10001 = false;
                                return var0;
                            }

                            try {
                                ((JSONArray)var0).put(var2, decode(((JSONArray)var0).get(var2), var1));
                                break label96;
                            } catch (ArrayIndexOutOfBoundsException var9) {
                                var10001 = false;
                                return var0;
                            }
                        }

                        try {
                            decodeData(((JSONArray)var0).get(var2), var1);
                        } catch (ArrayIndexOutOfBoundsException var8) {
                            var10001 = false;
                            return var0;
                        }
                    }

                    ++var2;
                }

                try {
                    if (((JSONArray)var0).length() >= 5) {
                        Object var3 = ((JSONArray)var0).get(0);
                        Object var4 = ((JSONArray)var0).get(1);
                        ((JSONArray)var0).put(0, ((JSONArray)var0).get(((JSONArray)var0).length() - 1));
                        ((JSONArray)var0).put(((JSONArray)var0).length() - 1, var3);
                        ((JSONArray)var0).put(1, ((JSONArray)var0).get(3));
                        ((JSONArray)var0).put(3, var4);
                    }

                    return var0;
                } catch (ArrayIndexOutOfBoundsException var7) {
                    var10001 = false;
                    return var0;
                }
            }

            JSONObject var23;
            try {
                var23 = (JSONObject)var0;
            } catch (ArrayIndexOutOfBoundsException var20) {
                var10001 = false;
                return var0;
            }

            var2 = var1;
            if (var1 == 0) {
                try {
                    var2 = var23.getInt("lfm5");
                } catch (ArrayIndexOutOfBoundsException var19) {
                    var10001 = false;
                    return var0;
                }
            }

            Iterator var5;
            ArrayList var22;
            try {
                var22 = new ArrayList();
                var5 = var23.keys();
            } catch (ArrayIndexOutOfBoundsException var17) {
                var10001 = false;
                return var0;
            }

            while(true) {
                try {
                    if (!var5.hasNext()) {
                        break;
                    }

                    var22.add(var5.next());
                } catch (ArrayIndexOutOfBoundsException var18) {
                    var10001 = false;
                    return var0;
                }
            }

            var1 = 0;

            while(true) {
                String var6;
                label183: {
                    label141: {
                        label178: {
                            try {
                                if (var1 >= var22.size()) {
                                    return var0;
                                }

                                var6 = (String)var22.get(var1);
                                if (var23.get(var6).getClass().equals(JSONObject.class) || var23.get(var6).getClass().equals(JSONArray.class) && var23.getJSONArray(var6).length() >= 1 && var23.getJSONArray(var6).get(0).getClass().equals(JSONObject.class)) {
                                    break label178;
                                }
                            } catch (ArrayIndexOutOfBoundsException var16) {
                                var10001 = false;
                                break;
                            }

                            try {
                                if (!var23.get(var6).getClass().equals(JSONArray.class) || var23.getJSONArray(var6).length() < 1 || !var23.getJSONArray(var6).get(0).getClass().equals(JSONArray.class)) {
                                    break label141;
                                }
                            } catch (ArrayIndexOutOfBoundsException var15) {
                                var10001 = false;
                                break;
                            }
                        }

                        try {
                            var23.put((String)decode(var6, var2), decodeData(var23.get(var6), var2));
                            break label183;
                        } catch (ArrayIndexOutOfBoundsException var12) {
                            var10001 = false;
                            break;
                        }
                    }

                    String var24;
                    try {
                        if (var6.equals("lfm5")) {
                            break label183;
                        }

                        var24 = (String)decode(var6, var2);
                        if (var24.equals("logo")) {
                            var23.put(var24, var23.get(var6));
                            break label183;
                        }
                    } catch (ArrayIndexOutOfBoundsException var14) {
                        var10001 = false;
                        break;
                    }

                    try {
                        var23.put(var24, decode(var23.get(var6), var2));
                    } catch (ArrayIndexOutOfBoundsException var13) {
                        var10001 = false;
                        break;
                    }
                }

                try {
                    var23.remove(var6);
                } catch (ArrayIndexOutOfBoundsException var11) {
                    var10001 = false;
                    break;
                }

                ++var1;
            }

            return var0;
        } else {
            return var0;
        }
    }

    private Object encode(Object var1, int var2) {
        boolean var3 = var1 instanceof String;
        int var4 = 0;
        boolean var5 = true;
        if (!var3 && !(var1 instanceof Number)) {
            if (!(var1 instanceof JSONArray)) {
                return var1;
            } else {
                JSONArray var10 = new JSONArray();
                int var9 = 0;

                while(true) {
                    JSONArray var7 = (JSONArray)var1;
                    if (var9 >= var7.length()) {
                        if (var10.length() >= 5) {
                            Object var11 = var10.get(0);
                            var1 = var10.get(1);
                            var10.put(0, var10.get(var10.length() - 1));
                            var10.put(var10.length() - 1, var11);
                            var10.put(1, var10.get(3));
                            var10.put(3, var1);
                        }

                        return var10;
                    }

                    var10.put(this.encode(var7.get(var9), var2));
                    ++var9;
                }
            }
        } else {
            if (var1 instanceof Number) {
                var1 = var1.toString();
            } else {
                var5 = false;
            }

            char[] var8;
            for(var8 = ((String)var1).toCharArray(); var4 < var8.length; ++var4) {
                var8[var4] = (char)(var8[var4] + var2);
            }

            if (var5) {
                StringBuilder var6 = new StringBuilder();
                var6.append(new String(var8));
                var6.append(" ");
                return var6.toString();
            } else {
                return new String(var8);
            }
        }
    }

    private Object encodeData(Object var1, int var2) {
        if (!var1.getClass().equals(JSONObject.class)) {
            return var1;
        } else {
            JSONObject var6 = createCopyOfJson((JSONObject)var1);
            int var3 = var2;
            if (var2 == 0) {
                var3 = MathUtils.random(100, 200);
            }

            ArrayList var4 = new ArrayList();
            Iterator var5 = var6.keys();

            while(var5.hasNext()) {
                var4.add(var5.next());
            }

            for(var2 = 0; var2 < var4.size(); ++var2) {
                String var7 = (String)var4.get(var2);
                if (var6.get(var7) instanceof JSONObject) {
                    var6.put((String)this.encode(var7, var3), this.encodeData(var6.get(var7), var3));
                } else {
                    var6.put((String)this.encode(var7, var3), this.encode(var6.get(var7), var3));
                }

                var6.remove(var7);
            }

            var6.put("lfm5", var3);
            return var6;
        }
    }

    public Socket close() {
        return this.socket.close();
    }

    public Socket connect() {
        return this.socket.connect();
    }

    public boolean connected() {
        return this.socket.connected();
    }

    public Socket disconnect() {
        return this.socket.disconnect();
    }

    public Emitter emit(String var1, Object... var2) {
        if (var2 != null && var2.length > 0) {
            var2[0] = this.encodeData(var2[0], 0);
        }

        return this.socket.emit(var1, var2);
    }

    public Emitter emit(String var1, Object[] var2, Ack var3) {
        return this.socket.emit(var1, var2, var3);
    }

    public boolean hasListeners(String var1) {
        return this.socket.hasListeners(var1);
    }

    public String id() {
        return this.socket.id();
    }

    public Manager io() {
        return this.socket.io();
    }

    public List<Emitter.Listener> listeners(String var1) {
        return this.socket.listeners(var1);
    }

    public Emitter off() {
        return this.socket.off();
    }

    public Emitter off(String var1) {
        return this.socket.off(var1);
    }

    public Emitter off(String var1, Emitter.Listener var2) {
        return this.socket.off(var1, var2);
    }

    public MafSocket on(String var1, Emitter.Listener var2) {
        this.socket.on(var1, (Emitter.Listener) new decodeEmitterListener(var2));
        return this;
    }

    public Emitter once(String var1, Emitter.Listener var2) {
        return this.socket.once(var1, var2);
    }

    public Socket open() {
        return this.socket.open();
    }

    public Socket send(Object... var1) {
        return this.socket.send(var1);
    }
}
