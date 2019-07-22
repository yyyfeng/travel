var dataForWeixin = {
appId: "",
MsgImg: "http://chivashi.gotoip1.com/cover.jpg",
TLImg: "http://chivashi.gotoip1.com/cover.jpg",
url: "http://mp.weixin.qq.com/s?__biz=MzA3OTQ2NjkwMA==&mid=200600448&idx=1&sn=459125c55439aef94e6eb1df8ab179f3#rd",
title: '参加NaviCam我知道，赢免费体验！小小胶囊做胃镜，轻轻松松送享胃检！',
desc: '参加NaviCam我知道，赢免费体验！',
fakeid: "",
callback: function () {
}
};
(function () {
var onBridgeReady = function () {
// 发送给好友; 
WeixinJSBridge.on('menu:share:appmessage', function (argv) {
WeixinJSBridge.invoke('sendAppMessage', {
"appid": dataForWeixin.appId,
"img_url": dataForWeixin.MsgImg,
"img_width": "120",
"img_height": "120",
"link": dataForWeixin.url,
"desc": dataForWeixin.title,
"title": dataForWeixin.desc
}, function (res) {
});
});
// 分享到朋友圈;
WeixinJSBridge.on('menu:share:timeline', function (argv) {
(dataForWeixin.callback)();
WeixinJSBridge.invoke('shareTimeline', {
"img_url": dataForWeixin.TLImg,
"img_width": "120",
"img_height": "120",
"link": dataForWeixin.url,
"desc": dataForWeixin.desc,
"title": dataForWeixin.title
}, function (res) {
});
});
// 分享到微博;
WeixinJSBridge.on('menu:share:weibo', function (argv) {
WeixinJSBridge.invoke('shareWeibo', {
"content": dataForWeixin.title,
"url": dataForWeixin.url
}, function (res) {
});
});
};
if (document.addEventListener) {
document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
} else if (document.attachEvent) {
document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
}
})();

//关注指定的微信号
function weixinAddContact(name){ 
    WeixinJSBridge.invoke("addContact", {webtype: "1",username: name}, function(e) { 
        WeixinJSBridge.log(e.err_msg); 
        //e.err_msg:add_contact:added 已经添加
        //e.err_msg:add_contact:cancel 取消添加
        //e.err_msg:add_contact:ok 添加成功
        if(e.err_msg == 'add_contact:added' || e.err_msg == 'add_contact:ok'){ 
            //关注成功，或者已经关注过
        } 
    }) 
} 