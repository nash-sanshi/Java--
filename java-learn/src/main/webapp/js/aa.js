function $(id) {
    //判断id是否为String类型
    if (typeof (id) == "string") {
        //根据id定位节点
        var idElement = document.getElementById(id);
        //判断节点是否存在
        if (idElement != null) {
            return idElement;
        } else {
            alert("查无此元素")
        }
    } else {
        alert("id必须是string类型")
    }
}