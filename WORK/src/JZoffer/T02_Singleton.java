package JZoffer;

//单例模式Singleton：设计一个类，只能生成该类的一个实例
//1.一个私有的构造器 2.一个私有的该类型的变量 3.一个公有的返回该类型方法返回唯一变量
//new一定要生成一个新对象，分配内存，且只能当次使用
//getInstance（）生成对象是static静态的，可以跨栈区使用，跳用多次返回同一个对象，不浪费系统资源（内存），也可以防止数据冲突，在性能上优于new
public class T02_Singleton {

    public static void main(String[] args)
    {
        System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        System.out.println(Singleton3.getInstance() == Singleton3.getInstance());//推荐
        System.out.println(Singleton4.INSTANCE == Singleton4.INSTANCE);
        System.out.println(Singleton5.getInstance() == Singleton5.getInstance());//推荐
    }

    //单例模式，饿汉式，线程安全(final)
    public static class Singleton1
    {
        private final static Singleton1 INSTANCE = new Singleton1();
        private Singleton1(){}
        public static Singleton1 getInstance()
        {
            return INSTANCE;
        }
    }

    //单例模式，线程不安全(null才能创建),多线程环境下效率不高
    public static class Singleton2
    {
        private static Singleton2 instance = null;
        private Singleton2(){}
        public static synchronized Singleton2 getInstance()
        {
            if(instance == null) instance = new Singleton2();
            return instance;
        }
    }

    //推荐
    //单例模式，使用静态内部类，线程安全
    public static class Singleton3
    {
        private final static class SingletonHolder
        {
            private static final Singleton3 INSTANCE = new Singleton3();
        }
        private Singleton3(){}
        public static Singleton3 getInstance()
        {
            return SingletonHolder.INSTANCE;
        }
    }

    //推荐
    //静态内部类，使用枚举方式，线程安全
    public enum Singleton4
    {
        INSTANCE;
        public void test(){}

    }

    //推荐
    //静态内部类，使用双重校验锁，线程安全
    public static class Singleton5
    {
        private volatile static Singleton5 instance = null;
        private Singleton5(){};
        public static Singleton5 getInstance()
        {
            if(instance == null)
            {
                synchronized(Singleton5.class)
                {
                    if(instance == null)
                    {
                        instance = new Singleton5();
                    }
                }
            }
            return instance;
        }
    }


}
