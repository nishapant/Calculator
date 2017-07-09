package sample;

/**
 * Created by nishapant on 4/29/17.
 */
import java.util.ArrayList;
public class EditStat {
    ArrayList<Object> data = new ArrayList<>();

    public EditStat(ArrayList<Object> x ){
        System.out.println("start constructor");
        System.out.println(x);
        for(int i =0; i<x.size(); i++){
            if(!(x.get(i) == null)){
                data.add(x.get(i));
            }
        }
        System.out.println("constructor");
    }

    public ArrayList<Object> SortA(){
        System.out.println("A");
        for(int i = 0;i< data.size();i++){
            for(int k = i; k<data.size(); k++){
                if((Double)data.get(i)> (Double)data.get(k)){
                    Object first = (Object) data.get(i);
                    data.set(i,data.get(k));
                    data.set(k, first);
                }
            }
        }
        System.out.println("finish A");
        return data;
    }

    public ArrayList<Object> SortD(){
        for(int i = 0;i< data.size();i++){
            for(int k = i; k < data.size(); k++){
                if((Double)data.get(i) < (Double)data.get(k)){
                    Object first = data.get(i);
                    data.set(i,data.get(k));
                    data.set(k, first);
                }
            }
        }
        return data;
    }



    public ArrayList<Object> clearList(){
        for(int i = data.size()-1; i>=0;i--){
            data.remove(i);
        }
        return data;
    }
}
