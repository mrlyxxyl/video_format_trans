package com.yx.test;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * 视频格式转换
 * User: LiWenC
 * Date: 17-3-20
 */
public class FormatConversion {

    public static void main(String[] args) {
        String[] strings = {"e:/test.avi", "e:/test.3gp", "e:/test.wmv"};
        long start = System.currentTimeMillis();
        for (int i = 0; i < strings.length; i++) {
//            toFlv(strings[i]);
//            toMp4(strings[i]);
            toAvi(strings[i]);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void toFlv(String src) {
        try {
            File source = new File(src);
            File target = new File("e:/" + System.currentTimeMillis() + ".flv");
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(new Integer(180000));
            video.setFrameRate(new Integer(15));
            EncodingAttributes attributes = new EncodingAttributes();
            attributes.setFormat("flv");
            attributes.setAudioAttributes(audio);
            attributes.setVideoAttributes(video);
            Encoder encoder = new Encoder();
            encoder.encode(source, target, attributes);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

    public static void toMp4(String src) {
        try {
            File source = new File(src);
            File target = new File("e:/" + System.currentTimeMillis() + ".mp4");
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libfaac");
            audio.setBitRate(new Integer(64000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
            VideoAttributes video = new VideoAttributes();
            video.setCodec("mpeg4");
            video.setBitRate(new Integer(600000));
            video.setFrameRate(new Integer(15));
            EncodingAttributes attributes = new EncodingAttributes();
            attributes.setFormat("mpegvideo");
            attributes.setAudioAttributes(audio);
            attributes.setVideoAttributes(video);
            Encoder encoder = new Encoder();
            encoder.encode(source, target, attributes);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }

    public static void toAvi(String src) {
        try {
            File source = new File(src);
            File target = new File("e:/" + System.currentTimeMillis() + ".avi");
            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(new Integer(56000));
            audio.setChannels(new Integer(1));
            audio.setSamplingRate(new Integer(22050));
            VideoAttributes video = new VideoAttributes();
            video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
            EncodingAttributes attributes = new EncodingAttributes();
            attributes.setFormat("avi");
            attributes.setAudioAttributes(audio);
            attributes.setVideoAttributes(video);
            Encoder encoder = new Encoder();
            encoder.encode(source, target, attributes);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
