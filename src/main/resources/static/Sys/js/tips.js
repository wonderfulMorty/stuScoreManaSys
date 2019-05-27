layui.define(['layer'], function(exports) {
    exports('tips', {
        warning: function (title, call, timer) {
            return layer.msg(title, {icon: 0, shade: 0.3, time: timer||1000}, function () {
                typeof call === "function" && call();
            });
        },
        error: function (title, call, timer) {
            return layer.msg(title, {icon: 2, shade: 0.3, time: timer||1000}, function () {
                typeof call === "function" && call();
            });
        },
        success: function (title, call, timer) {
            return layer.msg(title, {icon: 1, shade: 0.3, time: timer||1000}, function () {
                typeof call === "function" && call();
            });
        },
        loading: function (title, call, timer) {
            return layer.msg(title, {icon: 16, shade: 0.3, time: timer||1000}, function () {
                typeof call === "function" && call();
            });
        }
    });
});
