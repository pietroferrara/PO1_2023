package it.unive.dais.po1.dandd.objects;

public interface DaDObject extends Comparable<DaDObject> {
    public int getStrength();

    @Override
    default public int compareTo(DaDObject o) {

        if(this.equals(o))
            return 0;
        int result = this.getStrength() - o.getStrength();
        if(result!=0)
            return result;
        return 1;//TODO
    }

}
