function $(id) {
    //�ж�id�Ƿ�ΪString����
    if (typeof (id) == "string") {
        //����id��λ�ڵ�
        var idElement = document.getElementById(id);
        //�жϽڵ��Ƿ����
        if (idElement != null) {
            return idElement;
        } else {
            alert("���޴�Ԫ��")
        }
    } else {
        alert("id������string����")
    }
}