package s1.w1.d3;

public class PartTimeEmployee implements Payable{
    String name;
    double hourlyRate;
    int hours;

    public PartTimeEmployee(String name,double hourlyRate,int hours){
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hours = hours;
    }

    @Override
    public double getPay() {
        return hourlyRate*hours;
    }
}
