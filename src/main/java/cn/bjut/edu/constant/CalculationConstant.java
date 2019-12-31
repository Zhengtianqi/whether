package cn.bjut.edu.constant;

/**
 * @author zhengtianqi and wangkai
 */
public interface CalculationConstant {
    /**
     * 判断矩阵的平均随机一致性指标RI值
     */
    double[] RI = {0, 0, 0.58, 0.90, 1.12, 1.24, 1.32, 1.41, 1.45};
    /**
     * 常数：分母为 0 情况
     */
    double NAN = 1E-6;
    /**
     * 迭代步数
     */
    int STEP = 10;
}
