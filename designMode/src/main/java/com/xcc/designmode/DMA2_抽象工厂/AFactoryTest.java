package com.xcc.designmode.DMA2_抽象工厂;

import com.xcc.designmode.DMA2_抽象工厂.Cpu.Intel;
import com.xcc.designmode.DMA2_抽象工厂.DM2.CpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.DM2.GpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.Factory.DelivererR9000PFactory;
import com.xcc.designmode.DMA2_抽象工厂.Factory.DelivererY9000PFactory;

/**
 * 抽象工厂测试 == 具体工厂类实现不同电脑组件的生产
 */
public class AFactoryTest {

    /**
     * 好处：横向扩展很容易，如果我需要再增加一个电脑型号的生产线，比如暗影精灵，只需要在创建一个对应的工厂实现抽象工厂即可
     * 坏处：纵向扩展很麻烦，如果我需要增加内存条的生产接口，那么改动的地方就太多了，自己领会吧，可以尝试一下
     * @param args
     */
    public static void main(String[] args) {

        // 用户现在想要买个拯救者电脑，想要因特尔的cpu和英伟达的显卡，于是找Y9000P生产商生产
        DelivererY9000PFactory Y9000P = new DelivererY9000PFactory();
        CpuFactory intel = Y9000P.cpuCreate();
        intel.CpuFactory("I9", "139800HK");
        GpuFactory invida = Y9000P.gpuCreate();
        invida.GpuFactory("RTX", "4090");

        System.out.println("===========================================分割线");

        // 用户现在没多少钱，想买个拯救者电脑Amd的cpu和显卡，于是找R9000P生产商生产
        DelivererR9000PFactory R9000P = new DelivererR9000PFactory();
        CpuFactory amd = R9000P.cpuCreate();
        amd.CpuFactory("R9", "7900x");
        GpuFactory amdG = R9000P.gpuCreate();
        amdG.GpuFactory("7980", "HX");


    }

}
