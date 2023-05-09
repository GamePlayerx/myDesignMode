package com.xcc.designmode.DMA2_抽象工厂.Cpu;

import com.xcc.designmode.DMA2_抽象工厂.DM2.CpuFactory;

/**
 * 因特尔cpu生产商
 */
public class Intel implements CpuFactory {
    @Override
    public void CpuFactory(String name, String type) {
        System.out.println("因特尔的cpu -- "+name+type);
    }
}
