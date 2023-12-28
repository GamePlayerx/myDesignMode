package com.xcc.java.GameTest;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

/**
 * @Author GamePlayer-Joker
 * @Date 2023/12/8
 */
public class QQBoom {

    public static void main(String[] args) {
        try {//改Robot类等需要异常抛出
            Robot robot = new Robot();//机器类实现电脑自动，解放双手
//创建剪切板，分为系统版和本地版，本地版在自身运行，而在qq等运行是在系统版下
            Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();//System是系统版的粘贴板
            robot.delay(4000);//延迟是为了有时间让光标指向qq或微信等
            String msg = "rnmtq,我不玩了,这饼谁爱吃谁吃";//这里是要实现轰炸的文字
            String[] strings = msg.split(",");//改代码是若想一次性多行输入，String方法
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < strings.length; j++) {
                    StringSelection text = new StringSelection(strings[j]);//将需要发送的文字传给粘贴板
                    systemClipboard.setContents(text,null);
                    robot.keyPress(KeyEvent.VK_CONTROL);//按下键盘上的control
                    robot.keyPress(KeyEvent.VK_V);//按下键盘上的V
                    robot.keyRelease(KeyEvent.VK_CONTROL);//放开键盘上的control
                    robot.keyRelease(KeyEvent.VK_V);//放开键盘上的v
                    robot.keyPress(KeyEvent.VK_ENTER);//在将文字粘贴到qq上，然后按下enter发送
                    robot.keyRelease(KeyEvent.VK_ENTER);//松开enter键
//                    robot.delay(500);//可以修改两次消息之间的时间间隔
                    robot.delay(1000);//可以修改两次消息之间的时间间隔
                }
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}
