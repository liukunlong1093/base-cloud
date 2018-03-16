$(function(){
    var $nav_p = $('.nav_label p');
    var $input = $('input,textarea');
    var $menu = $('.screem_control');
    var $select = $('.select_key ul li');
    var $sort = $('.sorting_menu');
    var $sort_option = $('.sorting_menu li');
    // 左侧导航栏
    $nav_p.click(function(){
        if($(this).parent().find('li').is(':hidden')){
            $(this).parent().find('li').slideDown();
            $(this).children('.label_slide').attr('src','../../images/nav_left/slideUp.png');
        }else{
            $(this).parent().find('li').slideUp();
            $(this).children('.label_slide').attr('src','../../images/nav_left/slideDown.png');
        }
    });

    // 下拉菜单
    selectMenu($menu);
    $select.click(function(){
        var $value = $(this).attr('value');
        var $text = $(this).text();
        $(this).parents('.select_key').siblings('.select_val').val($value);
        $(this).parent().siblings('.show_menu').text($text);
        $(this).parent().siblings('.show_menu').css('color','#333');
        $(this).addClass('li_selected').siblings().removeClass('li_selected');
    });
    selectMenu($sort);

    // placeholder IE9兼容

    // 判断是否支持placeholder
    function isPlaceholer(){
        var input = document.createElement("input");
        return "placeholder" in input;
    }

    if(!isPlaceholer()){ // 如果不支持placeholder属性
        //创建一个类

        $(document).scroll(function(){
            var bb = $(document).scrollTop();
            if(bb>170){
                $('.resume_main').css('marginTop','35px');
            }else{
                $('.resume_main').css('marginTop',0);
            }
        });
function Placeholder(obj){
            this.input = obj; // obj为添加了placeholder属性的input|textarea
            this.label = document.createElement('label'); // 创建label标签
            // label标签的innerHTML设为input|textarea 的placeholder属性值。
            this.label.innerHTML = obj.getAttribute('placeholder');
            this.label.className = 'holder';
            this.label.style.cssText = 'position:absolute; text-indent:4px;color:#999999; font-size:14px;';
            if(obj.value != ''){
                this.label.style.display = 'none';
            };
            this.init();
            }
Placeholder.prototype = {
                //获取input|textarea的位置，以便相应的label定位
                getxy : function(obj){
                var left, top;
                if(document.documentElement.getBoundingClientRect){
                var html = document.documentElement,
                body = document.body,
                pos = obj.getBoundingClientRect(),
                st = html.scrollTop || body.scrollTop,
                sl = html.scrollLeft || body.scrollLeft,
                ct = html.clientTop || body.clientTop,
                cl = html.clientLeft || body.clientLeft;
                left = pos.left + sl - cl;
                top = pos.top + st - ct;
                }else{
                while(obj){
                left += obj.offsetLeft;
                top += obj.offsetTop;
                obj = obj.offsetParent;
                }
                }
                return{
                    left: left,
                    top : top
                }
                },
                //取input|textarea的宽高，将label设为相同的宽高
                getwh : function(obj){
                    return {
                        w : obj.offsetWidth,
                        h : obj.offsetHeight
                    }
                },
                //添加宽高值方法
                setStyles : function(obj,styles){
                for(var p in styles){
                    obj.style[p] = styles[p]+'px';
                }
                },
                init : function(){
                var label = this.label,
                input = this.input,
                getXY = this.getxy,
                xy = this.getxy(input),
                wh = this.getwh(input);
                this.setStyles(label, {'width':wh.w, 'height':wh.h, 'lineHeight':wh.h, 'left':xy.left, 'top':xy.top});
                document.body.appendChild(label);
                label.onclick = function(){
                    this.style.display = "none";
                    input.focus();
                }
                input.onfocus = function(){
                    label.style.display = "none";
                };
                input.onblur = function(){
                    var hh = this;
                    var timer = setTimeout(function(){
                        var aa = hh.value;
                        if(aa == ""){
                            label.style.display = "block";
                        }
                    },300);
                };
                if(window.attachEvent){
                    window.attachEvent("onresize",function(){// 因为label标签添加到body上，以body为绝对定位，所以当页面
                    var xy = getXY(input);
                        Placeholder.prototype.setStyles(label, {'left':xy.left+8, 'top':xy.top});
                    })}else{
                        window.addEventListener("resize",function(){
                        var xy = getXY(input);
                        Placeholder.prototype.setStyles(label, {'left':xy.left+8, 'top':xy.top});
                        },false);
                        }
                    }
                }
                var inpColl = document.getElementsByTagName('input'),
                textColl = document.getElementsByTagName('textarea');
                //html集合转化为数组
                function toArray(coll){
                    for(var i = 0, a = [], len = coll.length; i < len; i++){
                    a[i] = coll[i];
                }
                return a;
                }
            var inpArr = toArray(inpColl),
            textArr = toArray(textColl),
            placeholderArr = inpArr.concat(textArr);
            for (var i = 0; i < placeholderArr.length; i++){ // 分别为其添加替代placeholder的label
                if (placeholderArr[i].getAttribute('placeholder')){
                new Placeholder(placeholderArr[i]);
            }
        }
    }
    // 下划线
    var $label = $('.angleLine');
    var $icon = $('.angleIcon');
    var iconLeft = $('.angleBtn').innerWidth()/2;
    $icon.css('left',iconLeft);
    $('.angleEnter').find('.angleIcon').show();
    $label.on('click','.angleBtn',function(){
        var $this = $(this);
        var e = $this.index();
        $this.addClass('angleEnter').siblings().removeClass('angleEnter');
        $this.find('.angleIcon').show().parents().siblings().find('.angleIcon').hide();
    });
});
function selectMenu(e){
    $(e).on('click',function(){
        if($(this).find('ul').is(':hidden')){
            $(this).find('ul').slideDown();
        }else{
            $(this).find('ul').slideUp();
        }
    });
}
// 匹配度bar长度
function matchBar(){
    $('.grayBar').each(function(){
        var $this = $(this);
        var poi = $this.attr('grade');
        var barLength = $this.width();
        var barHeight = $this.height();
        var $coverBar = $this.find('.coverBar');
        var $textBar = $this.find('.textBar');
        $coverBar.height(barHeight);
        if(poi<=30){
            $('.coverBar').addClass('low');
        }else if(poi>30&&poi<=60){
            $('.coverBar').addClass('medium');
        }else{
            $('.coverBar').addClass('high');
        };
        $coverBar.animate({width:barLength*poi/100},1500);
        $textBar.text(poi + '%');
    });
};
