package factory;

/**
 * Created by caofanCPU on 2018/7/23.
 */
public class OptimizedSimpleFactoryPatternTest {
    
    public static void main(String[] args) {
        // 静态工厂放在超类接口中
        IChartProduct iFactory = IChartProduct.getChart("B");
        iFactory.display();
        
        // 静态工厂放在抽象类中
        AProduct aFactory = AProduct.getProduct("A");
        aFactory.show();
    }
}

class LineIChartProduct implements IChartProduct {
    @Override
    public void display() {
        System.out.println("Interface: oh my Line !");
    }
}

class PieIChartProduct implements IChartProduct {
    @Override
    public void display() {
        System.out.println("Interface: hello your Pie!");
    }
}

abstract class AProduct {
    public static AProduct getProduct(String type) {
        AProduct result;
        switch (type) {
            case "A":
                result = new LineAProduct();
                break;
            case "B":
            default:
                result = new PieAProduct();
        }
        return result;
    }
    
    public abstract void show();
}

interface IChartProduct {
    static IChartProduct getChart(String type) {
        IChartProduct result;
        switch (type) {
            case "A":
                result = new LineIChartProduct();
                break;
            case "B":
            default:
                result = new PieIChartProduct();
        }
        return result;
    }
    
    void display();
}

class LineAProduct extends AProduct {
    @Override
    public void show() {
        System.out.println("Abstract: oh my Line !");
    }
}

class PieAProduct extends AProduct {
    @Override
    public void show() {
        System.out.println("Abstract: hello your Pie!");
    }
}


