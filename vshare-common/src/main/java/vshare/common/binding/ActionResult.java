package vshare.common.binding;

public class ActionResult {
    boolean success;
    int statusCode;
    String msg;

    private ActionResult() {
    }

    private ActionResult(boolean success, int statusCode, String msg) {
        this.success = success;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class Builder {
        String msg = "Action Fail";
        private boolean success = false;
        private int statusCode = 0;

        public Builder() {

        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ActionResult build() {
            return new ActionResult(this.success, this.statusCode, this.msg);
        }
    }
}
