package sample;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {
    int[] Array = new int[50];
    static int arraysize = 0;
    public Button insbutton;
    public Button delete;
    public RadioButton linear;
    public RadioButton binary;
    public RadioButton ascending;
    public RadioButton descending;
    public TextField valuebox;
    public TextField indexbox;
    public Button findbutton;
    public Button searchbutton;
    public Button sortbutton;
    public void sortselect(){
        if(ascending.isSelected()){
            ascsort();
        }
        if(descending.isSelected()){
            descsort();
        }
    }
    public void insertvalue(){
            int value = Integer.parseInt(valuebox.getText());
            Array[arraysize] = value;
            arraysize++;
            for(int i=0;i<arraysize;i++){
                System.out.println(Array[i]);
            }
            System.out.println("-------------");
    }
    public void getvalueatindex(){
        int index = Integer.parseInt(indexbox.getText());
        if(index<arraysize){
            System.out.println("||"+Array[index]+"||");
        }
    }
    public void deletevalueatindex(){
        int index = Integer.parseInt(indexbox.getText());
        System.out.println(arraysize);
        if(index<arraysize){
            for(int i = index;i<arraysize;i++){
                Array[i] = Array[i+1];
            }
            arraysize--;
            for(int i=0;i<arraysize;i++){
                System.out.println("-------------");
                System.out.println(Array[i]);
            }
        }
    }
    public void searchbutton(){
        if(linear.isSelected()){
            linearsearch();
        }
        if(binary.isSelected()){
            binarysearch();
        }
    }
    public void linearsearch(){
        boolean found = false;
        try{
        int value = Integer.parseInt(valuebox.getText());
        for (int i =0;i<arraysize;i++){
            if(value==Array[i]){
                System.out.println("Found at Index :"+i);
                found = true;
                break;
            }
            else{
                found = false;
            }
        }
        if (found==false){
            System.out.println("Not Found");
        }
            }
    catch (Exception e){
            if(arraysize==0){System.out.println("Array is Empty");}
            else {
                System.out.println("Please enter a Value first");
            }
            }
    }
    public void binarysearch(){
        int value = Integer.parseInt(valuebox.getText());
        int i = 0,j = arraysize-1;
        int mid = (i+j)/2;
        while(i<j){
            if(value==Array[mid]){
                System.out.println("Found at Index :"+mid);
            }
            else if (value>Array[mid]){
                i = mid+1;
            }
            else{
                j=mid-1;
            }
            i++;
        }
    }
    public void ascsort(){
        int temp;
        for(int i = 0;i<arraysize-1;i++){
            for(int j = 0;j<arraysize-i-1;j++){
                if(Array[j]>Array[j+1]){
                 temp = Array[j];
                 Array[j] = Array[j+1];
                 Array[j+1] = temp;
                }
            }
        }
        System.out.println("The Sorted Array is: ");
        for(int i = 0;i<arraysize;i++){
            System.out.println("||"+Array[i]+"||");
        }
    }
    public void descsort(){
        int temp;
        for(int i = 0;i<arraysize-1;i++){
            for(int j = 0;j<arraysize-i-1;j++){
                if(Array[j]<Array[j+1]){
                    temp = Array[j];
                    Array[j] = Array[j+1];
                    Array[j+1] = temp;
                }
            }
        }
        System.out.println("The Sorted Array is: ");
        for(int i = 0;i<arraysize;i++){
            System.out.println("||"+Array[i]+"||");
        }
    }
}
