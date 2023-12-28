package com.xcc.java.video;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/7
 */
public class ConvertVideoUtils {

    public static void main(String[] args) throws Exception {
        System.err.println("---------开始执行----------------");

        //将下载后并解压的 "ffmpeg.exe,ffprobe.exe" 执行文件路径填写进去
        FFmpeg ffmpeg = new FFmpeg("D:/videos/bin/ffmpeg.exe");
        FFprobe ffprobe = new FFprobe("D:/videos/bin/ffprobe.exe");
        FFmpegBuilder builder = new FFmpegBuilder()
                // 源视频文件
                .setInput("D:/vdemo1/demo01.mkv")
                // 目标视频文件
                .addOutput("D:/vdemo2/video222.mp4")
                .done();

        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        executor.createJob(builder).run();

        System.err.println("---------执行完毕----------------");
    }

}
