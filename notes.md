Research
========

How Twitch Streams
------------------
Apparently Twitch.Tv has two different ways of streaming, desktop and mobile. The desktop version uses a protocol known as RTMP (Real Time Messaging Protocol) which is used to provide the content in a *.FLV container (Flash Video) to flash clients. The mobile version uses HLS (HTTP Live Streaming). This gives an *.m3u8 file that contains links to different *.TS containers (MPEG TS)

As far as I know both protocols use H.264 video and either MP3 or AAC audio.

Java Libraries That Could Help
------------------------------
- [red5](http://www.red5.org/) - Provides RTMP support to Java. Allows the user to demux FLV containers
- [JCodec](https://github.com/jcodec/jcodec) - Supports H.264 decoding, can also demux MPEG TS.
- [JLayer](http://www.javazoom.net/javalayer/javalayer.html) - Can decode MP3 files.


Process to get stream URLs
--------------------------
*Warning: One of these might not work, try both methods before assuming the stream doesn't exist.*

**HLS**:
> 1. Request https://api.twitch.tv/api/channels/{channel name}/access_token.json
> 2. Use variables from access_token in URL: http://usher.twitch.tv/api/channel/hls/{channel name}.m3u8?allow_source=true&token={token from access_token}&sig={sig from access_token}

*Note: be sure to remove the all of the \ in the token*

**RTMP**:
> 1. Request http://usher.twitch.tv/find/{channel name}.json?type=any
> 2. The required data to set up an RTMP connection is contained in this file