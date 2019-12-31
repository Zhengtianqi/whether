/**
 * 此类用来计算矩阵的最大特征根及特征向量
 * JAVA   幂法求解矩阵特征值及特征向量
 */
package cn.bjut.edu.utils;

import cn.bjut.edu.constant.CalculationConstant;
import cn.bjut.edu.entity.CalculationResult;

import java.util.List;

/**
 * @author zhengtianqi and wangkai
 */
public class CalculationUtils {
    /**
     * core 计算
     *
     * @param inputMatrix 输入的 n*n 矩阵 从左到右，从上到下
     * @param inputVector 输入的初始向量
     * @return 返回结果实体
     * @throws ArithmeticException            若不是 n阶初始向量，抛出异常
     * @throws ArrayIndexOutOfBoundsException 若不是 n*n 矩阵，抛出异常
     */
    public static CalculationResult getCalculationResult(List<Double> inputMatrix, List<Double> inputVector) throws ArrayIndexOutOfBoundsException, ArithmeticException {
        double m = 0;
        double[][] matrix = createMatrix(inputMatrix);
        int n = (int) Math.sqrt(inputMatrix.size());

        double[] v = new double[n];
        double[] u = CalculationUtils.listToDoubleArray(inputVector);

        if (n != u.length) {
            throw new ArrayIndexOutOfBoundsException("Vector's length is not correct");
        }
        System.arraycopy(u, 0, v, 0, n);
        // 迭代步数
        for (int k = 0; k < CalculationConstant.STEP; k++) {
            for (int i = 0; i < n; i++) {
                // 每次相乘后置v[i]=0;
                v[i] = 0;
                for (int j = 0; j < n; j++) {
                    v[i] = v[i] + matrix[i][j] * u[j];
                    m = getMaximal(v);
                }
                u[i] = v[i] / m;
            }
        }
        CalculationResult calculationResult = new CalculationResult();
        calculationResult.setCI((m - n) / (n - 1));
        calculationResult.setRI(CalculationConstant.RI[n - 1]);
        double cr = (m - n) / (n - 1) / CalculationConstant.RI[n - 1];
        calculationResult.setCR(Double.isNaN(cr) ? CalculationConstant.NAN : cr);
        calculationResult.setLmax(m);
        return calculationResult;
    }

    /**
     * 创建矩阵
     *
     * @param input 必须为 n*n 正方形矩阵
     * @return 矩阵数组
     * @throws ArithmeticException 若不是 n*n 矩阵，抛出异常
     */
    private static double[][] createMatrix(List<Double> input) throws ArithmeticException {
        int k = 0;
        int inputSize = input.size();
        int n = (int) Math.sqrt(inputSize);

        if (n * n != inputSize) {
            throw new ArithmeticException("matrix's length is not correct");
        }
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.get(k);
                k++;
            }
        }
        return matrix;
    }


    /**
     * 求数组中绝对值最大数字
     *
     * @param v double数组
     * @return 数组中绝对值最大数字
     */
    private static double getMaximal(double[] v) {
        double max = 0.0;
        for (double value : v) {
            if (Math.abs(value) >= max) {
                max = Math.abs(value);
            }
        }
        return max;
    }

    /**
     * List转double[]数组
     *
     * @param list 输入list
     * @return 输出double[]
     */
    private static double[] listToDoubleArray(List<Double> list) {
        Double[] doubles = new Double[list.size()];
        list.toArray(doubles);
        double[] result = new double[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            result[i] = doubles[i];
        }
        return result;
    }

    private CalculationUtils() {
    }
}
