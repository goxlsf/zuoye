#parse("header.jsp")
<style>.modal-backdrop{z-index:0;}</style>
    <div id="main">
        <div class="container" id="daily">
        <div id="sorti">
            <div class="panel panel-default">
            <div class="panel-heading">
                查询条件
            </div>
            <div class="panel-body form-group" style="margin-bottom:0px;">
                <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px;width: auto">投票名称：</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="Name" id="search_name" style="width: 200px"/>
                </div>

                <div class="col-sm-1 col-sm-offset-4">
                    <button class="btn btn-primary" id="search_btn">查询</button>
                </div>
            </div>
        </div>
            <div>
                <br>
                <button type="button" class="btn btn-primary" onclick="time()">按时间排序</button>
                <button type="button" class="btn btn-primary" onclick="cont()">按点击数排序</button>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <table id="mytable" ></table>
                </div>
            </div>
        </div>

            <div id="sorco" style="display: none">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        查询条件
                    </div>
                    <div class="panel-body form-group" style="margin-bottom:0px;">
                        <label class="col-sm-1 control-label" style="text-align: right; margin-top:5px;width: auto">投票名称：</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="Name" id="search_name1" style="width: 200px"/>
                        </div>

                        <div class="col-sm-1 col-sm-offset-4">
                            <button class="btn btn-primary" id="search_btn1">查询</button>
                        </div>
                    </div>
                </div>
                <div>
                    <br>
                    <button type="button" class="btn btn-primary" onclick="time()">按时间排序</button>
                    <button type="button" class="btn btn-primary" onclick="cont()">按点击数排序</button>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body">
                        <table id="mytable1" ></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<div class="modal" id="deadAdd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
</div>
<div class="modal" id="deadShow" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times
                </button>
            </div>
            <div class="modal-body">
                <div id="xx" style="width: 600px;height: 400px"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    function time() {
        $("#sorco").hide();
        $("#sorti").show();
    }
    function cont() {
        $("#sorti").hide();
        $("#sorco").show();
    }
</script>

#if ($pop)
<script>
window.loginpop = $!{pop};
</script>

#end


#parse("footer.jsp")