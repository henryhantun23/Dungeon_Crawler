package game.action;

public class Action {
    public String message;
    public String actionCharValue;
    protected int intVal;

    public void setMessage(String msg){
        message = msg;
        System.out.println(msg + "\n");

    }

    public String getMessage(){
        return message;
    }
    public void setIntValue(int v){
        intVal = v;
    }

    public int getIntValue(){
        return intVal;
    }

    public void setCharValue(String c){
        actionCharValue = c;
        System.out.println(actionCharValue);
    }
}
