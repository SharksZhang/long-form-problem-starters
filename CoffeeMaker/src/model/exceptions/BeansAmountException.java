package model.exceptions;

public class BeansAmountException extends Exception {
    private double beans;
    //todo 感觉这里的异常中的属性没有也可以有相同的效果？
    // 回答：只有需要从异常中获取该属性时才有必要添加属性。第一次写少了get方法
    public BeansAmountException(double beans){
        super(beans + "is not the right amount of beans");
        this.beans = beans;
    }
    public double getBeans(){return this.beans;}
    protected BeansAmountException(double beans, String message){
        super(beans + message);
        this.beans = beans;
    }
}
