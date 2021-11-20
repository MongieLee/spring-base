package base.entity;

import java.io.Serializable;

public class RItem implements Serializable {
    String message;
    Boolean success;

    public RItem(String message, Boolean sucess) {
        this.message = message;
        this.success = sucess;
    }
}
