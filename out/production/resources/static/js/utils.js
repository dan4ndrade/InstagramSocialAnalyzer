function selectPagelistBox(pageid){
    if (pageid == "null"){
        document.getElementsByClassName("dropdown-menu")[0].children[0].children[0].click();
    }
}
function showReturnMessagePost(resultpost){
    if (resultpost != "null"){
        document.getElementsByClassName("panel-title")[0].click()
    }
}