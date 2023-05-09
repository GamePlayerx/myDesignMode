package com.xcc.designmode.DMA2_抽象工厂.Gpu;

import com.xcc.designmode.DMA2_抽象工厂.DM2.GpuFactory;

/**
 * Amd显卡生产商
 */
public class AmdG implements GpuFactory {
    @Override
    public void GpuFactory(String name, String type) {
        System.out.println("Amd的显卡代号 ："+name+type);
    }
}
