package com.xcc.designmode.DMA2_抽象工厂.DM2;

/**
 * cpu接口 == 生产cpu
 */
public interface CpuFactory {

    /**
     * 约定cpu生产的规格数据
     * @param name 名称
     * @param type 类型
     */
    public void CpuFactory(String name, String type);

}
