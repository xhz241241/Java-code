public class StudyClass {
    private static int i =100;
        public static void main(String[] args) {
            StudyClass s1 = new StudyClass();
            s1.i++;
            StudyClass s2 = new StudyClass();
            s2.i++;
            s1 = new StudyClass();
            s1.i++;
            StudyClass.i--;
            System.out.println(i);//102
            //因为i加了static, 就是类相关的变量, 只跟着类变化, 跟指向哪个对象无关
            //所以这里的s1和s2和Studyclass指向的都是同一个i
            //初始化代码执行顺序:
    //就地初始化 = 代码块初始化(static修饰的代码块在类加载时就执行了,比main方法先) > 构造方法初始化
    }
}

//class School{
//    public School(String s) {
//        System.out.println("AAAA");
//    }
//
//}
