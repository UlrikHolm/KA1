
var memberTable = document.getElementById('member_table');


//http://localhost:8080/ka1/api/student/all
let url = 'https://jjugroup.ga/KA1/api/student/all';
fetch(url)
    .then(res => res.json())
    .then(data => {
        var i;
        for (i = 0; i < data.length; i++) {
            
            memberTable.innerHTML += '<tr><td>' + data[i].name +'</td>\
            <td>' + data[i].studentID + '</td>\
            <td>' + data[i].color + '</td></tr>'
            console.log(data.length);
        }
    } )