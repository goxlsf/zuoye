<div class="modal-dialog">
    <div class="modal-content" >
        <div class="modal-header">
            用户名:<br>
            <input type="text" name="username" value=$!{user.UserName} style="width:300px">
            <br>

            <br>密码<br>
            <input type="text" name="password" value=$!{user.PassWord} style="width:300px">
            <input type="text" name="userId" style="display:none" value=$!{userId} >
            <br>
            <br>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="alter()">
                提交
            </button>
        </div>
    </div>
</div>
