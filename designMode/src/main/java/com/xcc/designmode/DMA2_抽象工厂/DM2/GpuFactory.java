package com.xcc.designmode.DMA2_抽象工厂.DM2;

/**
 * 显卡接口 == 生产显卡
 */
public interface GpuFactory {

    /**
     * 约定gpu生产的规格数据
     * @param name 名称
     * @param type 类型
     */
    public void GpuFactory(String name, String type);

}
