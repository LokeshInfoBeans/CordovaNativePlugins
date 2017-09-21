package cordova-plugin-device-utility;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class DeviceUtility extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("isAirplaneModeOn")) {
            //String message = args.getString(0);
            //this.coolMethod(message, callbackContext);
            this.isAirplaneModeOn(this, callbackContext);
            return true;
        }
        return false;
    }

    /**
     * Gets the state of Airplane Mode.
     *
     * @param context
     * @return true if enabled.
     */
    private static boolean isAirplaneModeOn(Context context, CallbackContext callbackContext) {
        
        var status = Settings.System.getInt(context.getContentResolver(),
                                            Settings.System.AIRPLANE_MODE_ON, 0) != 0;
        if (status > 0) {
            callbackContext.success("Flight Mode On");
        } else {
            callbackContext.error("Flight Mode off");
        }
    }
//    private void coolMethod(String message, CallbackContext callbackContext) {
//        if (message != null && message.length() > 0) {
//            callbackContext.success(message);
//        } else {
//            callbackContext.error("Expected one non-empty string argument.");
//        }
//    }
}
