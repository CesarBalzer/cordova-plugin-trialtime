var exec = require('cordova/exec');

var Trialtime = {
    verificatrial: function (days, successCallback, errorCallback) {
        exec(successCallback, errorCallback, "Trialtime", "verify", [days]);
    }
};
module.exports = Trialtime;
