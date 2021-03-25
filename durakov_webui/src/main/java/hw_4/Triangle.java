package hw_4;

public class Triangle {
    public double result;
    private int first_side;
    private int second_side;
    private int third_side;

    public Triangle(Integer first_side, Integer second_side, Integer third_side){
            this.first_side = first_side;
            this.second_side = second_side;
            this.third_side = third_side;
    }


    public double calculating_area_triangle(Integer first_side, Integer second_side, Integer third_side){
        int p;
        p = (first_side + second_side + third_side) / 2;
        result = Math.sqrt(p * (p - first_side) * (p - second_side) * (p - third_side));
        return result;
    }

    public boolean isPositive(Integer first_side, Integer second_side, Integer third_side) {
        if (first_side > 0 && second_side > 0 && third_side > 0) return true;
        else return false;
    }

    public boolean isNotNull(Integer first_side, Integer second_side, Integer third_side) {
        if (first_side != 0 && second_side != 0 && third_side != 0) return true;
        else return false;
    }

    public boolean isTriangle(Integer first_side, Integer second_side, Integer third_side) {
        if (first_side + second_side > third_side ) return true;
        else if(first_side + third_side > second_side) return true;
        else if(second_side + third_side > first_side) return true;
        else return false;
    }

}
