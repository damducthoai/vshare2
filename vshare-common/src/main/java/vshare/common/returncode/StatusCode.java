package vshare.common.returncode;

/**
 * Created by Dell on 10/15/2017.
 */
public class StatusCode {
    public static final int DELETE_SUCCESS = 1;
    public static final int DELETE_FOUND_FAIL = 0;
    public static final int DELETE_NOT_FOUND_FAIL = -1;
    public static final int ADD_SUCCESS = 1;
    public static final int ADD_FAIL = -1;
    public static final int UPDATE_SUCCESS = 1;
    public static final int UPDATE_FOUND_FAIL = 0;
    public static final int UPDATE_NOT_FOUND_FAIL = -1;
    public static final int FOUND_SUCCESS = 1;
}
