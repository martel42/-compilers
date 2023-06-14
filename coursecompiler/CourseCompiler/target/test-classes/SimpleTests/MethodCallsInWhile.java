class MethodCallsInWhile {
    public static void main() {
        int i = 0;
        Test t = new Test();
        while (i < 10) {
            i = i + t.foo(i);
        }
    }
}
class Test {
    int foo(int number) {
        if (number > 5) {
            number = number * 2;
        }
        else {
            number = number * 3;
        }
        return number;
    }
}
