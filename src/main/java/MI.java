/*
 *此类用来计算矩阵的最大特征根及特征向量
 * JAVA   幂法求解矩阵特征值及特征向量
 * a[][] 矩阵
 * v[]  初始向量
 * m: 初始向量中绝对值的最大值
 * e: 精度
 */


import java.util.Scanner;

public class MI {

    static double a[][];
    static double v[];
    static double u[];
    static int n = 0;
    static double m;
    static double e = 0;

    public static void main(String[] args) {

        getA();
        jisuan();

    }

    private static void jisuan() {

        for (int i = 0; i < n; i++) {
            u[i] = v[i];
        }
        System.out.println("幂法所得结果：");
        for (int k = 0; k < 10; k++) { // 迭代步数

            for (int i = 0; i < n; i++) {

                v[i] = 0; // 每次相乘后置v[i]=0;
                for (int j = 0; j < n; j++) {

                    v[i] = v[i] + a[i][j] * u[j];

                    m = maximal(v);

                }
                u[i] = v[i] / m;

                System.out.print(u[i] + "   ");
            }

            System.out.print(" 最大特征根" + m);
            System.out.println();
        }

    }

    private static void getA() {
        Scanner as = new Scanner(System.in);
        System.out.print("输入方程组的元数（即输入矩阵阶数）：");
        n = as.nextInt();
        a = new double[n][n];
        v = new double[n];

        u = new double[n];
        System.out.println("输入方程组的系数矩阵a（按行输入矩阵）：");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = as.nextDouble();
            }
        }
        System.out.println("输入初始向量v：");
        for (int i = 0; i < n; i++) {
            v[i] = as.nextDouble();
        }

        System.out.println("输入精度10^(-e)：");
        e = as.nextDouble();

    }

    private static double maximal(double[] v) {
        double max = 0.0;
        for (int i = 0; i < n; i++) {
            if (Math.abs(v[i]) >= max) {
                max = Math.abs(v[i]);
            }
        }
        return max;

    }

}
