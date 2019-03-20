package com.yx.test;

import it.sauronsoftware.jave.*;

import java.io.File;

/**
 * 视频格式转换
 * User: LiWenC
 * Date: 17-3-20
 */
public class FormatConversion {

    public static void main(String[] args) throws EncoderException {

        long start = System.currentTimeMillis();
        File[] files = new File("E:\\study\\video\\Java并发编程与高并发解决方案(完整)").listFiles();
        for (File file : files) {
            toMp4(file);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void toMp4(File source) {
        try {

            String path = source.getAbsolutePath();
            if (!path.endsWith("wmv")) {
                return;
            }
            path = path.replaceAll("wmv", "mp4");
            File target = new File(path);

            MultimediaInfo info = new Encoder().getInfo(source);
            AudioInfo audioTmp = info.getAudio();
            int audioBitRate = audioTmp.getBitRate();
            int audioChannels = audioTmp.getChannels();
            int audioSamplingRate = audioTmp.getSamplingRate();

            VideoInfo videoTmp = info.getVideo();
            int videoBitRate = videoTmp.getBitRate();
            float videoFrameRate = videoTmp.getFrameRate();

            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libfaac");
            audio.setBitRate(audioBitRate);
            audio.setChannels(audioChannels);
            audio.setSamplingRate(audioSamplingRate);
            VideoAttributes video = new VideoAttributes();
            video.setCodec("mpeg4");
            video.setBitRate(videoBitRate);
            video.setFrameRate((int) videoFrameRate);
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

    public static void toAvi(File source) {
        try {
            String path = source.getAbsolutePath();
            if (!path.endsWith("wmv")) {
                return;
            }
            path = path.replaceAll("wmv", "avi");
            File target = new File(path);

            MultimediaInfo info = new Encoder().getInfo(source);
            AudioInfo audioTmp = info.getAudio();
            int audioBitRate = audioTmp.getBitRate();
            int audioChannels = audioTmp.getChannels();
            int audioSamplingRate = audioTmp.getSamplingRate();
            VideoInfo videoTmp = info.getVideo();
            int videoBitRate = videoTmp.getBitRate();
            float videoFrameRate = videoTmp.getFrameRate();

            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(audioBitRate);
            audio.setChannels(audioChannels);
            audio.setSamplingRate(audioSamplingRate);
            VideoAttributes video = new VideoAttributes();

            video.setCodec(VideoAttributes.DIRECT_STREAM_COPY);
            video.setBitRate(videoBitRate);
            video.setFrameRate((int) videoFrameRate);
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

    public static void toFlv(File source) {
        try {

            String path = source.getAbsolutePath();
            if (!path.endsWith("wmv")) {
                return;
            }
            path = path.replaceAll("wmv", "flv");
            File target = new File(path);

            MultimediaInfo info = new Encoder().getInfo(source);
            AudioInfo audioTmp = info.getAudio();
            int audioBitRate = audioTmp.getBitRate();
            int audioChannels = audioTmp.getChannels();
            int audioSamplingRate = audioTmp.getSamplingRate();
            VideoInfo videoTmp = info.getVideo();
            int videoBitRate = videoTmp.getBitRate();
            float videoFrameRate = videoTmp.getFrameRate();

            AudioAttributes audio = new AudioAttributes();
            audio.setCodec("libmp3lame");
            audio.setBitRate(audioBitRate);
            audio.setChannels(audioChannels);
            audio.setSamplingRate(audioSamplingRate);
            VideoAttributes video = new VideoAttributes();
            video.setCodec("flv");
            video.setBitRate(videoBitRate);
            video.setFrameRate((int) videoFrameRate);
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
}
