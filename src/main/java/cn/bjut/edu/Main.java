package cn.bjut.edu;

import cn.bjut.edu.entity.CalculationResult;
import cn.bjut.edu.utils.CalculationUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhengtianqi and wangkai on 2019/12/30 16:28
 */
public class Main {
    /**
     * 这是一个测试用例
     *
     * @param args args字符串数组
     */
    public static void main(String[] args) {
        //   输入矩阵为：
        //        ——             ——
        //        | 1.0  0.5  1.0 |
        //        | 2.0  1.0  2.0 |
        //        | 1.0  0.5  1.0 |
        //        ——             ——
        //   输入单层权重为：
        //   [0.2500 0.5000 0.2500]
        List<Double> inputMatrix = Arrays.asList(1.0, 0.5, 1.0, 2.0, 1.0, 2.0, 1.0, 0.5, 1.0);
        List<Double> inputVector = Arrays.asList(0.2500, 0.5000, 0.2500);
        try {
            // 输出
            CalculationResult result = CalculationUtils.getCalculationResult(inputMatrix, inputVector);
            System.out.println("lmax=" + result.getLmax());
            System.out.println("CI=" + result.getCI());
            System.out.println("CR=" + result.getCR());
            System.out.println("RI=" + result.getRI());
        } catch (ArithmeticException e) {
            System.out.println("输入矩阵 不是 n * n 的矩阵");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("输入单层权重 不是 n 向量");
        }

    }
}
