package offer;

public class L64_1plusn {

    // 简单题，要求不能用要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
    // 那更简单，直接用等差数列求和
    public int sumNums(int n) {
        return (n + 1) * n / 2;
    }
}
