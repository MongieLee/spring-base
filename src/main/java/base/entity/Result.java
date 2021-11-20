package base.entity;

public class Result {
    Integer status;
    Object message;
    Boolean success;

    public Result(Integer status, Object message, Boolean success) {
        this.status = status;
        this.message = message;
        this.success = success;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
