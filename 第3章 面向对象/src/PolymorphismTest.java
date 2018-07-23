/**
 * Created by caofanCPU on 2018/7/23.
 */
public class PolymorphismTest {
    public static void main(String[] args){
        
        SuperType father = new SubType();
        // Attention: 静态方法须通过类调用，而非类的实例调用
        father.show();
        System.out.println(father.type + ": " + father.life);
    }
}


class SuperType {
    
    public static String type = "FATHER";
    
    public Integer life = 99;
    
    public static void show() {
        SubType.show();
        System.out.println("fu static method");
    }
}

class SubType extends SuperType {
    
    public static String type = "SUN";
    
    public Integer life = 23;
    
    public static void show() {
        System.out.println("zi static method: " + type);
    }
}