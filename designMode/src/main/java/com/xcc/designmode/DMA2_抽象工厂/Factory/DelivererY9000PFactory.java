package com.xcc.designmode.DMA2_抽象工厂.Factory;

import com.xcc.designmode.DMA2_抽象工厂.Cpu.Intel;
import com.xcc.designmode.DMA2_抽象工厂.DM2.AComputerFactory;
import com.xcc.designmode.DMA2_抽象工厂.DM2.CpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.DM2.GpuFactory;
import com.xcc.designmode.DMA2_抽象工厂.Gpu.Invida;

/**
 * 拯救者Y9000P生产商
 */
public class DelivererY9000PFactory implements AComputerFactory {
    @Override
    public CpuFactory cpuCreate() {
        return new Intel();
    }

    @Override
    public GpuFactory gpuCreate() {
        return new Invida();
    }
}
