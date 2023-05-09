package com.xcc.designmode.DMA2_抽象工厂.DM2;

/**
 * 电脑抽象工厂 == 只提供电脑组件的组装，具体组装成什么型号电脑，在由具体工厂类决定
 */
public abstract interface AComputerFactory {

    CpuFactory cpuCreate();

    GpuFactory gpuCreate();

}
