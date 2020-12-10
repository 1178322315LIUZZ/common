package com.zhenzhen.common.utils;

/**
 * 定期巡检模型，保养模型周期单位使用
 * 最好不要改动，以免造成大量逻辑修改
 * @author 何军龙
 * 创建日期 2019/12/27 16:06
 **/
public enum ModelPeriodUnitEnum {
    YEAR("F"),MONTH("C"),DAY("A"),WEEK("B"),JIDU("D"),BANNIAN("E");
    private String unit;
    ModelPeriodUnitEnum(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return this.unit;
    }

    public static boolean isContains(String unit)
    {
        return get(unit) != null;
    }

    public static ModelPeriodUnitEnum get(String unit) {
        if(unit == null)
            return null;
        for (ModelPeriodUnitEnum e : ModelPeriodUnitEnum.values()) {
            if (e.getUnit().equals(unit)) {
                return e;
            }
        }
        return null;
    }
}
