package com.xcc.designmode.DMA2_抽象工厂.Gpu;

import com.xcc.designmode.DMA2_抽象工厂.DM2.GpuFactory;

/**
 * 英伟达显卡生产商
 */
public class Invida implements GpuFactory {
    @Override
    public void GpuFactory(String name, String type) {
        System.out.println("英伟达的显卡："+name+type);
    }
}
