
var folderList = [];
var fileList = [];
var addFolder = function(){
    var name = document.getElementById("folder-name").value;
    var type = document.getElementById("folder-type").value;
    var note = document.getElementById("folder-size").value;
    var folder = [];

    folder.push(name);
    folder.push(type);
    folder.push(note);

    folderList.push(folder);
    //Load friend
    loadFolder();
}



var loadFolder = function(){
    //Remove old data
    deleteTableData();
    var table = document.getElementById("folder-list");
    for(var i =0; i<folderList.length;i++){

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        cell1.innerHTML = '<i class="fa fa-folder-o" aria-hidden="true"></i>' + " " + folderList[i][0]  ;
        cell2.innerHTML = folderList[i][1];
        cell3.innerHTML = folderList[i][2];
        //cell4.innerHTML = "<button id="+"btn-remove "+"onclick="+"deleteRow("+i+")"+">Delete</button>";   C1
        cell4.innerHTML = '<button id="'+i+'" onclick="deleteRow(this)">Delete</button>';   //C2
    }
}

//upload file
var uploadFile = function(){
    var name = "File";
    var size = "Size";
    var date = "date";
    var file = [];

    file.push(name);
    file.push(size);
    file.push(date);

    fileList.push(file);
    //Load friend
    loadFile();
}

var loadFile = function(){
    //Remove old data
    deleteTableDataFile();
    var table = document.getElementById("file-list");
    for(var i =0; i<fileList.length;i++){

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var cell1 = row.insertCell(0);
        var cell2 = row.insertCell(1);
        var cell3 = row.insertCell(2);
        var cell4 = row.insertCell(3);
        cell1.innerHTML = fileList[i][0]  ;
        cell2.innerHTML = fileList[i][1];
        cell3.innerHTML = fileList[i][2];
        //cell4.innerHTML = "<button id="+"btn-remove "+"onclick="+"deleteRow("+i+")"+">Delete</button>";   C1
        cell4.innerHTML = '<button id="'+i+'" onclick="deleteRowFile(this)">Delete</button>';   //C2

    }
}

var deleteTableData = function(){
    var table = document.getElementById("folder-list");
    while(table.rows.length > 1){
        table.deleteRow(1);
    }
}

var deleteRow = function(row){
    var index = row.id;
    folderList.splice(index,1);
    loadFolder();
}

/*delete file*/
var deleteTableDataFile = function(){
    var table = document.getElementById("file-list");
    while(table.rows.length > 1){
        table.deleteRow(1);
    }
}

var deleteRowFile = function(row){
    var index = row.id;
    fileList.splice(index,1);
    loadFile();
}



/*ajax sending data*/
/*

$(document).ready(function(){
    $("#btnAddFolder").click(function(){
        var status="complete";
        var nameFolder = document.getElementById("folder-name").value;
        $.ajax({

            url: '/Vshare/function',
            contentType: "application/json; charset=utf-8",
            data: {'nameFolder': nameFolder},
            type: 'POST',
            cache: false,
            success: function (savingStatus) {
                $("#hdnOrigComments").val($('#txtComments').val());
                $('#lblCommentsNotification').text(savingStatus);
            }
        });
    });
});*/
