package net.medsouz.modjam3.io;
//basic class for disecting *.m3u8 files
public class M3U8 {
	public int duration;//how long this instance is valid before needing to be refreshed
	public int sequence;//position in time.
	
	public M3U8(String data){
		if(data.startsWith("#EXTM3U")){
			System.out.println("Valid m3u8 entered");
			String[] s = data.split("#EXT");
			for(int x = 0; x < s.length; x++){
				System.out.println(x+": "+s[x]);
			}
		}else{
			System.err.println("Invalid m3u8 file.");
		}
	}
}
