var exec = require('cordova/exec');

exports.isAirplaneModeOn = function( success, error) {
    exec(success, error, "DeviceUtility", "isAirplaneModeOn");
};
