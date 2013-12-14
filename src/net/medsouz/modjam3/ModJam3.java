package net.medsouz.modjam3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import net.medsouz.modjam3.io.M3U8;
import net.medsouz.modjam3.json.AccessToken;

import org.red5.server.net.rtmp.RTMPClient;

import com.google.gson.Gson;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = "mdsz_ModJam3", name = "", version = "0.1")
public class ModJam3 {
	
	Gson gson = new Gson();
	
	@EventHandler
    public void init(FMLInitializationEvent evt){
		AccessToken access = gson.fromJson(fileToString("https://api.twitch.tv/api/channels/medsouz/access_token.json"), AccessToken.class);
		M3U8 playlist = new M3U8(fileToString(access.toHLSURL("medsouz")));
	}
	
	public String fileToString(String url){
		String result = "";
		try {
			URL u = new URL(url);
			BufferedReader r = new BufferedReader(new InputStreamReader(u.openStream()));
			StringBuffer buff = new StringBuffer();
			int pos;
			char[] b = new char[1024];
			while((pos = r.read(b)) != -1){
				buff.append(b, 0, pos);
			}
			result = buff.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
