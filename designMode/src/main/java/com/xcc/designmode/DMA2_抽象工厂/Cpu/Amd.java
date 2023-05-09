package com.xcc.designmode.DMA2_抽象工厂.Cpu;

import com.xcc.designmode.DMA2_抽象工厂.DM2.CpuFactory;

/**
 * Amdcpu生产商
 */
public class Amd implements CpuFactory {
    @Override
    public void CpuFactory(String name, String type) {
        System.out.println("Amd的cpu -- "+name+type);
    }
}
