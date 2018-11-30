<div class="modal-dialog">
    <div class="modal-content" >
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
        &times
    </button>
    <h4 class="modal-title" id="myModalLabel">
        <$!{vote.questionName}>的投票结果
    </h4>
</div>
<div class="modal-body">
        #foreach($vo in $vos)
    <div><h1>选项$!{vo.ques.OptionId}：$!{vo.ques.option}</h1><h1 style="align-content: right">$!{vo.ques.count}</h1>
    </div>
        #end

</div>
<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
    </button>
</div>
    </div>
</div>