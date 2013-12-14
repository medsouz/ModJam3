package net.medsouz.modjam3.json;

//java-ified version of https://api.twitch.tv/api/channels/{channel name}/access_token.json

public class AccessToken {
	public String token;
	public String sig;
	public boolean mobile_restricted;
	
	public String toHLSURL(String chan){
		return "http://usher.twitch.tv/api/channel/hls/"+chan+".m3u8?allow_source=true&token="+token.replace("\\", "")+"&sig=" + sig;
	}
}
