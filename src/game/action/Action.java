package game.action;

public class Action {
    public String message;
    public String actionCharValue;

    public void setMessage(String msg){
        message = msg;
        System.out.println(msg + "\n");

    }
    public void setIntValue(int v){

    }
    public void setCharValue(String c){
        actionCharValue = c;
        
    }
}
