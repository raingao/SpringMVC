package cn.itcast.exception;

/**
 * Created by gaoyu on 2017/6/14.
 * Wish you a good day~
 */
public class DiyException extends Exception {

    private String message;

    public DiyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
