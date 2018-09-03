/**
 * Created by Administrator on 2017/5/20.
 * @name:   vip-admin 后台模板 菜单navJS
 * @author: 随丶
 */
layui.define(['layer', 'element'], function (exports) {
    // 操作对象
    var layer = layui.layer
        , element = layui.element
        , $ = layui.jquery;

    // 封装方法
    var mod = {
        // 添加 HTMl
        addHtml: function (addr, obj, treeStatus, data) {
            // 请求数据
            $.get(addr, data, function (res) {
                var view = "";
                if (res.data) {
                    $(res.data).each(function (k, v) {
                        v.subset && treeStatus ? view += '<li>' : view += '<li>';
                        if (v.subset) {
                            //一级标题部分
                            view += '<a href="javascript:;"><i class="layui-icon">' + v.icon + '</i><cite>' + v.text +
                                '</cite> <i class="iconfont nav_right">&#xe697;</i></a><ul class="sub-menu">';

                            //二级标题部分 (就是一级菜单的展开)
                            $(v.subset).each(function (ko, vo) {
                                view += '<li>';
                                if(vo.target){
                                    view += '<a href="' + vo.href + '" target="_blank">';
                                }else{
                                    view += '<a href="javascript:;" _href="' + vo.href + '">';
                                }
                                view += '<i class="layui-icon">' + vo.icon + '</i>' + vo.text + '</a></li>';
                            });
                            view += '<ul>';
                        } else {
                            if (v.target) {
                                view += '<a href="' + v.href + '" target="_blank">';
                            } else {
                                view += '<a href="javascript:;" _href="' + v.href + '">';
                            }
                            view += '<i class="layui-icon">' + v.icon + '</i>' + v.text + '</a>';
                        }
                        view += '</li>';
                    });

                } else {
                    layer.msg('接受的菜单数据不符合规范,无法解析');
                }
                // 添加到 HTML
                $(document).find("#nav").html(view);

                // 更新渲染
                element.init();


                $('.left-nav #nav li').click(function (event) {
                    if($(this).children('.sub-menu').length){
                        //隐藏和显示子菜单
                        if($(this).hasClass('open')){
                            $(this).removeClass('open');
                            $(this).find('.nav_right').html('&#xe697;');
                            $(this).children('.sub-menu').stop().slideUp();
                            $(this).siblings().children('.sub-menu').slideUp();
                        }else{
                            $(this).addClass('open');
                            $(this).children('a').find('.nav_right').html('&#xe6a6;');
                            $(this).children('.sub-menu').stop().slideDown();
                            $(this).siblings().children('.sub-menu').stop().slideUp();
                            $(this).siblings().find('.nav_right').html('&#xe697;');
                            $(this).siblings().removeClass('open');
                        }
                    }else{

                        var url = $(this).children('a').attr('_href');
                        var title = $(this).find('cite').html();
                        var index  = $('.left-nav #nav li').index($(this));

                        for (var i = 0; i <$('.x-iframe').length; i++) {
                            if($('.x-iframe').eq(i).attr('tab-id')==index+1){
                                tab.tabChange(index+1);
                                event.stopPropagation();
                                return;
                            }
                        };

                        tab.tabAdd(title,url,index+1);
                        tab.tabChange(index+1);
                    }

                    event.stopPropagation();

                })

                // 跳转导航
                // $(".layui-nav *[lay-href]").each(function (o) {
                //     if(location.href.indexOf($(this).attr("lay-href")) != -1){
                //         $(this).parent().removeClass("layui-this").addClass("layui-this")
                //     }
                // })
                // $(".layui-nav *[lay-href]").on("click",function () {
                //     location.href = $(this).attr("lay-href");
                // })
            },'json');
        }
        // 左侧主体菜单 [请求地址,过滤ID,是否展开,携带参数]
        , main: function (addr, obj, treeStatus, data) {
            // 添加HTML
            this.addHtml(addr, obj, treeStatus, data);
        }
        // 顶部左侧菜单 [请求地址,过滤ID,是否展开,携带参数]
        , top_left: function (addr, obj, treeStatus, data) {
            // 添加HTML
            this.addHtml(addr, obj, treeStatus, data);
        }
        /*// 顶部右侧菜单
         ,top_right: function(){

         }*/
    };

    // 输出
    exports('vip_nav', mod);
});


