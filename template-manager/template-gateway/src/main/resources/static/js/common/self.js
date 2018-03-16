$(function(){
    //复选框
    $('.checkbox').each(function(){
        var $this = $(this);
        $this.click(function(){
            $this.next().next().next().prop('checked', false);
            $this.toggleClass('checkbox-select');
        })
    })

})
function bannerPicMove(){
    var n=0;
    var timer=null;
    var onIndex=0;  
    var $aLi=$(".banner_box ul li");
    console.log($aLi);
    var $aDot=$(".dot i");
    for(var i=0;i<$aDot.length;i++){
        $aDot.eq(i).click(function(){
            clearInterval(timer);
            onIndex=$(this).index();
            $aLi.eq(onIndex).show().siblings().hide();
            $aDot.eq(onIndex).addClass("dot_cur").siblings().removeClass("dot_cur");
            n=onIndex;
            timer=setInterval(picmove,2000);
        });
    }   
    function picmove(){
        if(!$aLi.eq(n).is(":hidden")){
            $aLi.eq(n).hide();
            $aLi.eq(n+1).show();
            n++;
        }else{
            $aLi.eq(n).show();
            $aLi.eq(n+1).hide();
            n++;
        }
        if(n==$aLi.length){
            $aLi.eq(n).hide();
            $aLi.eq(0).show();
            n=0;
        }
        
        $aDot.eq(n).addClass("dot_cur").siblings().removeClass("dot_cur");
    }
    timer=setInterval(picmove,2000);
}



