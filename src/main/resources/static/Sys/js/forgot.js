layui.define(['layer', 'form', 'tips'], function(exports) {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.$,
        tips = layui.tips;

    //刷新验证码
    var captchaImg = $('.lau-sign-captcha'), captchaSrc = captchaImg.attr('src');
    captchaImg.click(function () {
        $(this).attr('src', captchaSrc + '?_t=' + Math.random());
    });

    //ajax请求出错提示
    $(document).ajaxError(function (event, request, setting) {
        if (request.status === 200) {
            tips.error('Invalid response');
        } else {
            tips.error(request.status + ': ' + request.statusText);
        }
    });

    //获取手机验证码
    $('.lau-sign-sms').click(function () {
        var phone = $('input[name="phone"]').val();
        if (!/^1\d{10}$/.test(phone)) {
            return tips.warning('请输入正确的手机号码');
        }

        var captcha = $('input[name="captcha"]').val();
        if (!/^\S{4,}$/.test(captcha)) {
            return tips.warning('图形验证码格式不正确');
        }

        var that = $(this);
        that.attr('disabled', true).addClass('layui-btn-disabled');
        $.post('/json/sms.json', {phone: phone, captcha: captcha}, function (json) {
            if (json.errcode == 0) {
                tips.success(json.errmsg);
                var expire = json.data.expire;
                var handle = setInterval(function () {
                    if (expire) {
                        that.text('重新获取 (' + expire + ')');
                        expire--;
                    } else {
                        that.text('获取验证码');
                        that.attr('disabled', false).removeClass('layui-btn-disabled');
                        clearInterval(handle);
                    }
                }, 1000);
            } else {
                tips.error(json.errmsg, function () {
                    that.attr('disabled', false).removeClass('layui-btn-disabled');
                });
            }
        }, 'json');
    });

    //重置
    form.on('submit(forgot)', function (data) {
        if (!/^1\d{10}$/.test(data.field.phone)) {
            tips.warning('请输入正确的手机号码');
            return false;
        } else if (!/^\S{4,}$/.test(data.field.code)) {
            tips.warning('手机验证码格式不正确');
            return false;
        } else if (!/^\S{6,16}$/.test(data.field.password) || !/^\S{6,16}$/.test(data.field.repassword)) {
            tips.warning('密码必须6-12位且不能出现空格');
            return false;
        } else if (data.field.password !== data.field.repassword) {
            tips.warning('两次密码输入不一致');
            return false;
        }

        //请稍后
        tips.loading('请稍后...', 0, -1);

        //发送重置表单
        $.post('/json/forgot.json', data.field, function (json) {
            if (json.errcode == 0) {
                tips.success(json.errmsg, function () {
                    location.href = '/html/login.html';
                });
            } else {
                tips.error(json.errmsg);
            }
        }, 'json');

        return false;
    });

    exports('forgot', {});
});
