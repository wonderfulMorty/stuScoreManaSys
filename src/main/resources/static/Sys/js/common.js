layui.define(['jquery'], function(exports) {
    var $ = layui.$,
        lau = top.layui.lau;

    //监听锚点打开选项卡
    $(document).on('click', '*[lau-href]', function () {
        var _this = $(this);
        lau.go(_this.attr('lau-href'), _this.attr('lau-title'), _this.attr('lau-icon'));
    });

    exports('common', lau);
});
