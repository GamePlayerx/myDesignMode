package com.xcc.designmode.DMA2_抽象工厂.Factory;

import com.xcc.designmode.DMA2_抽象工厂.Cpu.Amd;
import com.xcc.designmode.DMA2_抽象工厂.DM2.AComputerFactory;
import com.xcc.designmode.DMA2_抽象工厂.DM2.CpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.DM2.GpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.Gpu.AmdG;

/**
 * 拯救者R9000P生产商
 */
public class DelivererR9000PFactory implements AComputerFactory {
    @Override
    public CpuFactory cpuCreate() {
        return new Amd();
    }

    @Override
    public GpuFactory gpuCreate() {
        return new AmdG();
    }
}
